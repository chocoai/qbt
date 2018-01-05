const express = require('express');
const moment = require('moment');
const commHttp = require('../lib/commHttp');
const httpConfig = require('../lib/configLoader').httpConfig;

var getPreAndNext = function(ids, titles, id){
    var index = ids.indexOf(parseInt(id));
    var isLast = (ids.length - index) <= 1 ? true : false;
    var isFirst = !index ? true : false;
    var data = {};
    if(isLast){
        data = {id:id,isLast:true,preId:ids[index-1],preTitle:titles[index-1]};
    }
    else if(isFirst){
        data = {id:id,isFirst:true,nextId:ids[index+1],nextTitle:titles[index+1]};
    }
    else{
        data = {id:id, isLast:false,preId:ids[index-1],preTitle:titles[index-1],nextId:ids[index+1],nextTitle:titles[index+1]}
    }
    return data;
}

var news = express();

news.get('/',(req,res,next) => {
    Promise.all([
        commHttp({
            hostname : httpConfig.boss_api,
            path : '/api/baseNews/findByPageOfficial.api',
            method: 'post'
            },{pageNo:req.query.pageNo || 1,categoryId:req.query.type || ''}
        ),
        commHttp({
            hostname : httpConfig.boss_api,
            path : '/api/newsCategory/findList.api',
            method: 'get'
            }
        )
    ]).then((data)=>{
        var page = data[0].page;
        let datas = {
            static_url : httpConfig.static_url,
            file_url : httpConfig.file_url,
            lists : data[0].datas,
            page_string : JSON.stringify(data[0].page),
            page : page,
            currentPage:page.pageNo,
            newTypes : data[1].datas,
            theType : req.query.type || '',
            theTypeName:req.query.typeName || ''
        };
        if(datas.lists && datas.lists.length > 0){
            datas.lists.forEach((data) => {
                data.createTime = moment(data.createTime).format('YYYY年MM月DD日');
            }); 
        }
        var pages = [];
        var totalPage = page.totalPages;
        if (totalPage <= 7){
            for (var index=1; index <= totalPage; index++)
                pages.push(index);
        }
        else{
            if (datas.currentPage < 7){
                for (var index = 1; index <= 7; index++)
                    pages.push(index);
                pages.push("...");
            }
            else if (datas.currentPage >= totalPage - 2){
                pages.push(1);
                pages.push(2);
                pages.push("...");
                pages.push(totalPage - 4);
                pages.push(totalPage - 3);
                pages.push(totalPage - 2);
                pages.push(totalPage - 1);
                pages.push(totalPage);
            }
            else{
                pages.push(1);
                pages.push(2);
                pages.push("...");
                pages.push(datas.currentPage - 2);
                pages.push(datas.currentPage - 1);
                pages.push(datas.currentPage);
                pages.push(datas.currentPage + 1);
                pages.push(datas.currentPage + 2);
                pages.push("...");
            };
        };
        datas.pages = pages;
        res.render('news',datas);
    },(err)=>{
        next(new Error(err));
    });
});

news.get('/:id',(req,res,next) => {
    Promise.all([
        commHttp({
            hostname : httpConfig.boss_api,
            path : '/api/baseNews/findByIdOfficial.api',
            method: 'get'
        	},{id: req.params.id}
        ),
        commHttp({
            hostname : httpConfig.boss_api,
            path : '/api/baseNews/list.api',
            method: 'get'
            },{categoryId:req.query.type || ''}
        ),
        commHttp({
            hostname : httpConfig.boss_api,
            path : '/api/newsCategory/findList.api',
            method: 'get'
            }
        )
        ]).then((data)=>{
	        let datas = {
	            static_url : httpConfig.static_url,
	            file_url : httpConfig.file_url,
	            detail : data[0].datas,
                newTypes : data[2].datas
	        };
	        if(datas.detail){
                var lists = data[1].datas;
                var ids = [], titles = [];
                if(lists && lists.length > 0){
                    lists.forEach(function(list){
                        ids.push(list.id);
                        titles.push(list.title);
                    });
                    datas.preAndNext = getPreAndNext(ids,titles,req.params.id);
                }
	        	datas.detail.createTime = moment(datas.detail.createTime).format('YYYY年MM月DD日');
		        res.render('newsDetail',datas);
	        }
	        else{
	        	res.render('404');
	        }
	    },(err)=>{
	        next(new Error(err));
	    });
});


module.exports = news;
