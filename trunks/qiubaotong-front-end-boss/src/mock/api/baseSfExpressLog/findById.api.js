next(null,{
    "code": "0000",
    "datas": {
        "createTime": 1488795581000,
        "keyword": "",
        "requestBody": "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Request service=\"DeliverTmService\" lang=\"zh-CN\">\n    <Head>SHGLXX</Head>\n    <Body>\n        <DeliverTmRequest weight=\"18\" consigned_time=\"2017-03-06 18:00:00\">\n            <SrcAddress province=\"海南\" city=\"万宁市\" district=\"东澳镇\" address=\"全部\"/>\n            <DestAddress province=\"海南\" city=\"三亚市\" district=\"吉阳区\" address=\"全部\"/>\n        </DeliverTmRequest>\n    </Body>\n</Request>",
        "responseBody": "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Response service=\"DeliverTmService\">\n    <Head>OK</Head>\n    <Body>\n        <DeliverTmResponse>\n            <DeliverTm business_type=\"3\" business_type_desc=\"电商特惠\" deliver_time=\"2017-03-07 18:00:00,2017-03-07 18:00:00\">\n                <price>0.0</price>\n            </DeliverTm>\n            <DeliverTm business_type=\"1\" business_type_desc=\"顺丰次日\" deliver_time=\"2017-03-07 18:00:00,2017-03-07 18:00:00\">\n                <price>0.0</price>\n            </DeliverTm>\n            <DeliverTm business_type=\"7\" business_type_desc=\"电商速配\" deliver_time=\"2017-03-07 18:00:00,2017-03-07 18:00:00\">\n                <price>0.0</price>\n            </DeliverTm>\n            <DeliverTm business_type=\"15\" business_type_desc=\"生鲜速配\" deliver_time=\"2017-03-07 18:00:00,2017-03-07 18:00:00\">\n                <price>0.0</price>\n            </DeliverTm>\n        </DeliverTmResponse>\n    </Body>\n</Response>",
        "serviceName": "deliverTmService",
        "status": 1
    },
    "msg": "ok"
})