"use strict"

var gulp = require("gulp");
var del = require("del");
var concat = require("gulp-concat");
var cleanCss = require("gulp-clean-css");
var uglifyjs = require("gulp-uglify");
var rename = require("gulp-rename");
// var sass = require("gulp-ruby-sass");
var sass = require("gulp-sass-china");
var livereload = require('gulp-livereload');
var connect = require('gulp-connect');
var cgiMock = require('connect-cgi-mock');
var zip = require('gulp-zip');
var Client = require('ssh2').Client;
var sftp = require("gulp-sftp");
var replaceMd5 = require('gulp-replace-md5');
var renameMd5 = require('gulp-rename-md5');
var cleanhtml = require("gulp-cleanhtml");
var replace = require('gulp-replace');
var mergeStream = require('merge-stream');
// var cheerio = require('gulp-cheerio');
var fileinclude = require('gulp-file-include');

gulp.task("clean", [], function(cb){
    return del(["./dist"], cb);
});

gulp.task('default',function () {
    gulp.start('server');
});

gulp.task("build:Js",[], function(){
    return gulp.src("src/js/*.js")
        .pipe(fileinclude({
            prefix: '@@',
            basepath: '@file'
        }))
        .pipe(gulp.dest("dist/js"));
});

gulp.task("buildDev:Js",[], function(){
    return gulp.src("src/js/*.js")
        .pipe(fileinclude({
            prefix: '@@',
            basepath: '@file'
        }))
        .pipe(uglifyjs())
        .pipe(gulp.dest("dist/js"))
        .pipe(renameMd5())
        .pipe(gulp.dest("dist/js"));
});

gulp.task("build:Images",[], function(){
     return gulp.src("src/images/**")
        .pipe(gulp.dest("dist/images"));
});

gulp.task("build:Libs",[], function(){
    return gulp.src("src/assets/**")
        .pipe(gulp.dest("dist/assets"));
});

gulp.task("build:html",[], function(){
     return gulp.src("src/*.html")
        .pipe(fileinclude({
            prefix: '@@',
            basepath: '@file'
        }))
        .pipe(replace(/{{{/g, ''))
        .pipe(replace(/}}}/g, ''))
        .pipe(gulp.dest("dist"));
});
gulp.task("buildDev:html",["buildDev:Js","build:Libs","build:Images","minify"], function(){
    return gulp.src("src/*.html")
        .pipe(fileinclude({
            prefix: '@@',
            basepath: '@file'
        }))
        .pipe(replaceMd5({ base: __dirname + '/dist/' ,openTag : '{{{', closeTag : '}}}' }))
        .pipe(cleanhtml())
        .pipe(gulp.dest("dist"));
});

gulp.task("minify", function(){
    return gulp.src('src/css/*.css')
      //  .pipe(sass())
        .pipe(cleanCss({compatibility: true}))
      // .pipe(rename("main.min.css"))
        .pipe(gulp.dest("dist/css"))
        .pipe(renameMd5())
        .pipe(gulp.dest("dist/css"));
});

gulp.task('server', ['watch'], function () {
    connect.server({
        root: 'dist',
        port: 8001,
        livereload: true,
        middleware: function(){
            return [
                cgiMock({
                    root: __dirname + '/src/mock',
                    route: '/api'
                })
            ]
        }
    });
    require('opn')('http://localhost:8001/order.html');
});

gulp.task('watch', ['build'], function () {

	gulp.watch('src/css/*.css', ['minify']);
    gulp.watch('src/js/**', ['build:Js']);
    gulp.watch('src/*.html', ['build:html']);
    gulp.watch('src/images/*.*', ['build:Images']);
    var server = livereload();
    gulp.watch('dist/**/**').on('change', function (file) {
        server.changed(file.path);
    });
});

gulp.task("build", ["build:Js","build:Libs","build:Images","build:html","minify"]);

gulp.task("buildDev", ["buildDev:html"]);

gulp.task("deploy",['buildDev','build:other'],function(){
    gulp.src('dist/**')
    .pipe(zip('dist.zip'))
    .pipe(gulp.dest('./'))
    .pipe(sftp({
        host: '192.168.0.88',
        user: 'qbt',
        pass: 'Ms123456!',
        remotePath: '/home/qbt/website/',
        callback : function(){
            var conn = new Client();
            conn.on('ready', function() {
                console.log('exec unzip dist.zip...');
                conn.exec('cd /home/qbt/website/ && unzip -o dist.zip', function(err, stream) {
                    if (err) throw err;
                    stream.on('close', function(code, signal) {
                      console.log('exec end :: code: ' + code );
                      conn.end();
                    }).on('data', function(data) {
                      //console.log('STDOUT: ' + data);
                    }).stderr.on('data', function(data) {
                      console.log('STDERR: ' + data);
                    });
              });
            }).connect({
                    host: '192.168.0.88',
                    port: 22,
                    username: 'qbt',
                    password: 'Ms123456!'
            });
        }
    }));
});

gulp.task("build:upgrade",['buildDev','build:other'],function(){
    gulp.src('dist/**')
    .pipe(zip('upgrade_website.zip'))
    .pipe(gulp.dest('./'));
});

gulp.task("build:other",function(){
    return gulp.src(['src/robots.txt','src/sitemap.xml'])
        .pipe(gulp.dest('dist'));
});
