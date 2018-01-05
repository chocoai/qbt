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
var cheerio = require('gulp-cheerio');
var fileinclude = require('gulp-file-include');
var autoprefixer = require('gulp-autoprefixer');
gulp.task("clean", [], function(cb){
    return del(["./dist"], cb);
});

gulp.task('default',function () {
    gulp.start('server');
});

gulp.task("build:time",[], function(){
    return gulp.src("src/js/app.js")
        .pipe(replace(/version\ =\ \'\d+\'/g, "version = '" + new Date().getTime() +"'"))
        .pipe(gulp.dest("src/js"));
});

gulp.task("build:Js",[], function(){
    return gulp.src("src/js/*.js")
        .pipe(fileinclude({
            prefix: '@@',
            basepath: '@file'
        }))
        .pipe(gulp.dest("dist/js"));
});

gulp.task("buildDev:Js",["build:time"], function(){
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
     return gulp.src("src/img/**")
        .pipe(gulp.dest("dist/img"));
});

gulp.task("build:Libs",[], function(){
    return mergeStream(
        gulp.src("src/assets/**")
            .pipe(gulp.dest("dist/assets")),

        gulp.src(['src/assets/js/zepto.min.js',
            'src/assets/js/layer.js',
            'src/assets/js/fastclick.min.js',
            'src/assets/js/vue.min.js',
            'src/assets/js/vue-touch.min.js',
            'src/assets/js/vuex.min.js',
            'src/assets/js/vue-router.min.js'])
            .pipe(concat('libs.min.js'))
            .pipe(gulp.dest("dist/assets/js")),

        gulp.src(['src/assets/js/zepto.min.js',
            'src/assets/js/layer.js',
            'src/assets/js/fastclick.min.js',
            'src/assets/v3/vue.min.js',
            'src/assets/v3/vuex.min.js',
            'src/assets/v3/vue-router.min.js'
            ])
            .pipe(concat('libs_v3.min.js'))
            .pipe(gulp.dest("dist/assets/js"))
    );
});

gulp.task("build:html",[], function(){
     return gulp.src("src/view/*.html")
        .pipe(fileinclude({
            prefix: '@@',
            basepath: '@file'
        }))
        .pipe(replace(/{{{/g, ''))
        .pipe(replace(/}}}/g, ''))
        .pipe(gulp.dest("dist/view"));
});
gulp.task("buildDev:html",["buildDev:Js","build:Libs","build:Images","minify"], function(){
    return gulp.src("src/view/*.html")
        .pipe(fileinclude({
            prefix: '@@',
            basepath: '@file'
        }))
        .pipe(cheerio({
            run : function($,file,done){
                 $('head').append('<script src="//hm.baidu.com/hm.js?b1e5d5d4ac80f4bf7425665d4e3514c5"></script>');
                 done();
            },
            parserOptions : {
                decodeEntities : false
            }
        }))
        .pipe(replaceMd5({ base: __dirname + '/dist/' ,openTag : '{{{', closeTag : '}}}' }))
        .pipe(cleanhtml())
        .pipe(gulp.dest("dist/view"));
});
gulp.task("build:upgrade:html",["buildDev:Js","build:Libs","build:Images","minify"], function(){
    return gulp.src("src/view/*.html")
        .pipe(fileinclude({
            prefix: '@@',
            basepath: '@file'
        }))
        .pipe(cheerio({
            run : function($,file,done){
                 $('head').append('<script src="//hm.baidu.com/hm.js?185a3f830043ee9fc73f7e9f5428bf41"></script>');
                 done();
            },
            parserOptions : {
                decodeEntities : false
            }
        }))
        .pipe(replaceMd5({ base: __dirname + '/dist/' ,openTag : '{{{', closeTag : '}}}' }))
        .pipe(cleanhtml())
        .pipe(gulp.dest("dist/view"));
});

gulp.task("minify", function(){
    return mergeStream (
        gulp.src('src/sass/main.scss')
        .pipe(sass())
        .pipe(cleanCss({compatibility: true}))
        .pipe(rename("main.min.css"))
        .pipe(autoprefixer({
                browsers: ['last 2 versions'],
                cascade: false
            })
        )
        .pipe(gulp.dest("dist/css"))
        .pipe(renameMd5())
        .pipe(gulp.dest("dist/css")),

        gulp.src('src/sass/main_v3.scss')
        .pipe(sass())
        .pipe(cleanCss({compatibility: true}))
        .pipe(rename("main_v3.min.css"))
        .pipe(autoprefixer({
                browsers: ['last 2 versions'],
                cascade: false
            })
        )
        .pipe(gulp.dest("dist/css"))
        .pipe(renameMd5())
        .pipe(gulp.dest("dist/css"))
    );
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
    require('opn')('http://localhost:8001/view/index.html?code=1');
});

gulp.task('watch', ['build'], function () {

	gulp.watch('src/sass/*.scss', ['minify']);
    gulp.watch('src/js/**', ['build:Js']);
    gulp.watch('src/view/**', ['build:html']);
    gulp.watch('src/img/*.*', ['build:Images']);
    var server = livereload();
    gulp.watch('dist/**/**').on('change', function (file) {
        server.changed(file.path);
    });
});

gulp.task("build", ["build:Js","build:Libs","build:Images","build:html","minify"]);

gulp.task("buildDev", ["buildDev:html"]);

gulp.task("deploy",['buildDev'],function(){
    gulp.src('dist/**')
    .pipe(zip('dist.zip'))
    .pipe(gulp.dest('./'))
    .pipe(sftp({
        host: '192.168.0.88',
        user: 'qbt',
        pass: 'Ms123456!',
        remotePath: '/home/qbt/wechat/',
        callback : function(){
            var conn = new Client();
            conn.on('ready', function() {
                console.log('exec unzip dist.zip...');
                conn.exec('cd /home/qbt/wechat/ && unzip -o dist.zip', function(err, stream) {
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

gulp.task("build:upgrade",['build:upgrade:html'],function(){
    gulp.src('dist/**')
    .pipe(zip('upgrade_weixin.zip'))
    .pipe(gulp.dest('./'));
});
