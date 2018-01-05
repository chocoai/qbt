const express = require('express');
const commHttp = require('../lib/commHttp');
const httpConfig = require('../lib/configLoader').httpConfig;
const util = require('../lib/util');

var index = express();

index.get('/',(req,res,next) => {
    Promise.all([
        commHttp({
            hostname : httpConfig.boss_api,
            path : '/api/baseNews/listGroupByCategoryId.api'
        }),
        commHttp({
            hostname : httpConfig.boss_api,
            path : '/api/baseLink/list.api'
        })
    ]).then((data)=>{
        let datas = {
            static_url : httpConfig.static_url,
            file_url : httpConfig.file_url,
            newsList : util.groupByKey(data[0].datas,'categoryId'),
            links : data[1].datas
        }
        res.render('index',datas);
    },(err)=>{
        // next(new Error(err));

        res.render('index',{
            static_url : httpConfig.static_url,
            file_url : httpConfig.file_url,
            newsList : [],
            links : []
        });
    });

})

module.exports = index;
