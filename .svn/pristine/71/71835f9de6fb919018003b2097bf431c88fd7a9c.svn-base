module.exports = {

    httpConfig :  process.env.NODE_ENV === 'test'
        ? require('../config/http_test.json') : process.env.NODE_ENV === 'production'
        ? require('../config/http.json') : require('../config/http_dev.json')

}
