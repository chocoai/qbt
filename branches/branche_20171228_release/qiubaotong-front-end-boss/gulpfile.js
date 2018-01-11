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

gulp.task("clean", [], function(cb){
    return del(["./dist"], cb);
});

gulp.task('default',function () {
    gulp.start('server');
});

gulp.task("build:Js",[], function(){
    return gulp.src("src/js/*.js")
        .pipe(gulp.dest("dist/js"));
});

gulp.task("buildDev:Js",[], function(){
    return gulp.src("src/js/*.js")
        .pipe(uglifyjs())
        .pipe(gulp.dest("dist/js"))
        .pipe(renameMd5())
        .pipe(gulp.dest("dist/js"));
});

gulp.task("build:Images",[], function(){
     return gulp.src("src/img/**")
        .pipe(gulp.dest("dist/img"));
});

gulp.task("build:Libs",[], function(){
    return gulp.src("src/assets/**")
        .pipe(gulp.dest("dist/assets"));
});

gulp.task("build:html",[], function(){
     return gulp.src("src/view/**")
        .pipe(replace(/{{{/g, ''))
        .pipe(replace(/}}}/g, ''))
        .pipe(gulp.dest("dist/view"));
});
gulp.task("buildDev:html",["buildDev:Js","build:Libs","build:Images","minify"], function(){
    return gulp.src("src/view/**")
        .pipe(replaceMd5({ base: __dirname + '/dist/' ,openTag : '{{{', closeTag : '}}}' }))
        .pipe(cleanhtml())
        .pipe(gulp.dest("dist/view"));
});

gulp.task("minify", function(){
    // return sass('src/sass/main.scss', { noCache: true })
    //     .on('error', sass.logError)
    //     .pipe(cleanCss({compatibility: true}))
    //     .pipe(rename("main.min.css"))
    //     .pipe(gulp.dest("dist/css"))
    //     .pipe(renameMd5())
    //     .pipe(gulp.dest("dist/css"));
    return gulp.src('src/sass/main.scss')
        .pipe(sass())
        .pipe(cleanCss({compatibility: true}))
        .pipe(rename("main.min.css"))
        .pipe(gulp.dest("dist/css"))
        .pipe(renameMd5())
        .pipe(gulp.dest("dist/css"));
});

gulp.task('server', ['watch'], function () {
    connect.server({
        root: 'dist',
        port: 8002,
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
    require('opn')('http://localhost:8002/view/login.html');
});

gulp.task('watch', ['build'], function () {

	gulp.watch('src/sass/*.scss', ['minify']);
    gulp.watch('src/js/*.js', ['build:Js']);
    gulp.watch('src/view/*.*', ['build:html']);
    gulp.watch('src/img/*.*', ['build:Images']);
    var server = livereload();
    gulp.watch('dist/**/**').on('change', function (file) {
        server.changed(file.path);
    });
});

gulp.task("build", ["build:Js","build:Libs","build:Images","build:html","minify"]);

gulp.task("buildDev", ["buildDev:html"],function(){
    return gulp.src('dist/assets/ueditor/config.json')
            .pipe(replace(/http:\/\/\w+.qiubaotong.com/,'http://testboss.qiubaotong.com'))
            .pipe(gulp.dest('dist/assets/ueditor'));
});
gulp.task("buildUpgrade", ["buildDev:html"],function(){
    return gulp.src('dist/assets/ueditor/config.json')
            .pipe(replace(/http:\/\/\w+.qiubaotong.com/,'http://boss.qiubaotong.com'))
            .pipe(gulp.dest('dist/assets/ueditor'));
});

gulp.task("deploy",['buildDev'],function(){
    gulp.src('dist/**')
    .pipe(zip('dist.zip'))
    .pipe(gulp.dest('./'))
    .pipe(sftp({
        host: '192.168.0.88',
        user: 'qbt',
        pass: 'Ms123456!',
        remotePath: '/home/qbt/boss/',
        callback : function(){
            var conn = new Client();
            conn.on('ready', function() {
                console.log('exec unzip dist.zip...');
                conn.exec('cd /home/qbt/boss/ && unzip -o dist.zip', function(err, stream) {
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

gulp.task("build:upgrade",['buildUpgrade'],function(){
    gulp.src('dist/**')
    .pipe(zip('upgrade_boss.zip'))
    .pipe(gulp.dest('./'));
});
