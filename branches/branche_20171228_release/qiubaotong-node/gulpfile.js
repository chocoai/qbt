"use strict"

var gulp = require("gulp");
var zip = require('gulp-zip');
var Client = require('ssh2').Client;
var sftp = require("gulp-sftp");

gulp.task('default',function () {
    gulp.start('pack');
});

gulp.task('pack',function(){
    return gulp.src(['./bin/**','./config/**','./lib/**','./pulibc/**','./routers/**','./views/**','app.js'],{base : '.'})
    .pipe(zip('dist.zip'))
    .pipe(gulp.dest('./'));
});

gulp.task('packModules',function(){
    return gulp.src('./node_modules/**',{base : '.'})
    .pipe(zip('dist.zip'))
    .pipe(gulp.dest('./'));
});

gulp.task("upload",function(){
    gulp.src('dist.zip')
    .pipe(sftp({
        host: '192.168.0.88',
        user: 'qbt',
        pass: 'Ms123456!',
        remotePath: '/home/qbt/node/',
        callback : function(){
            var conn = new Client();
            conn.on('ready', function() {
                console.log('exec unzip dist.zip...');
                conn.exec('cd /home/qbt/node/ && unzip -o dist.zip', function(err, stream) {
                    if (err) throw err;
                    stream.on('close', function(code, signal) {
                      console.log('exec end :: code: ' + code );
                      conn.end();
                    }).on('data', function(data) {
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

gulp.task('deploy',['pack'],function(){
    gulp.start('upload');
});

gulp.task('deployModule',['packModules'],function(){
    gulp.start('upload');
});
