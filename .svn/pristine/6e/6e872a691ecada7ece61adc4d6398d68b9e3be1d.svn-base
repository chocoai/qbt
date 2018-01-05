const http = require('http');
const _ = require('underscore');
const querystring = require('querystring');

module.exports = function(options,data){

    let defaultOptions = {
        method : 'GET',
        headers : {
            'Content-Type': 'application/json'
        }
    };
    if(options.hostname.indexOf(':') > 0){
        options.host = options.hostname.split(':')[0];
        options.port = options.hostname.split(':')[1];
        options.hostname = '';
    }
    defaultOptions = _.extend(defaultOptions,options);

    if(defaultOptions.method.toUpperCase() == 'GET' && data){
        defaultOptions.path += '?' + querystring.stringify(data);
    }

    return new Promise((reslove,reject) => {
        var req = http.request(defaultOptions,(res) => {
            var chunks = "";
            res.on('data',(chunk) => {
                chunks += chunk;
            });
            res.on('end',()=>{
                console.log(`API：${defaultOptions.path} | RESPONE : ${chunks}`);
                if(res.statusCode == 200){
                    reslove(JSON.parse(chunks));
                }else{
                    reject('网络繁忙');
                }
            });
        });

        req.on('error',(e) => {
            console.error(`请求错误:${defaultOptions.path} | ${e.message}`);
            reject('网络繁忙');
        });

        if(defaultOptions.method.toUpperCase() == 'POST' && data){
            req.write(JSON.stringify(data));
        }

        req.end();
    })
}
