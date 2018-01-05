const _ = require('underscore');

exports.isResSucc = function(data){
    return data && data.code == '0000';
}

// 按数组对象属性分组
exports.groupByKey = function(list,key){
    if(!_.isArray(list)) return [];

    var result = {};
    list.forEach((item) => {
        if(_.has(result,item[key])){
            result[item[key]].push(item);
        }else{
            result[item[key]] = [item];
        }
    })

    var newList = [];
    for(let key of Object.keys(result)){
        newList.push(result[key]);
    }
    return newList;
}
