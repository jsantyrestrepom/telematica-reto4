	/* variables */
var fs = require('fs'),
    xml2js = require('xml2js'),
    parser = new xml2js.Parser();


    /* methods */
exports.locateService = function locateService(serviceName, callback) {
	console.log('> searching the service');
	fs.readFile(__dirname + '/public/calcserver.xml', function(err, data) {
	    parser.parseString(data, function (err, result) {
	        if (serviceName == 'sumar' || serviceName == 'multiplicar') {
	        	console.log('> ' + serviceName + ' -> ' + result.urls.url[0]);
	        	callback(result.urls.url[0]);
	        } else if (serviceName == 'restar' || serviceName == 'dividir') {
	        	console.log('> ' + serviceName + ' -> ' + result.urls.url[1]);
	        	callback(result.urls.url[1]);
	        }
	    });
	});
};