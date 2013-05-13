	/* variables */
var assert = require('assert'),
	restify = require('restify'),
	proxy = require('./proxy');


	/* methods */
exports.doTheMath = function(request, response, callback) {
	console.log('> doing maths');
	if (request.param('p1') && request.param('op') && request.param('p2')) {
		op = request.query.op;
		if (op=='sumar' || op=='restar' || op=='multiplicar' || op=='dividir') {
			callService(request.query.p1, op, request.query.p2, function(result){
				callback(result);
			});
		} else {
			console.log('> no entiendo la operacion');
			callback('no entiendo la operacion');
		}
	} else {
		console.log('> no entiendo los parametros');
		callback('no entiendo los parametros');
	}
};

function callService(a, op, b, callback) {
	console.log('> locate the service');
	proxy.locateService(op, function(path){
		console.log(path);
		var urlService = path;
		var wsClient = restify.createJsonClient({
			url : urlService,
			version : '~0.0.1'
		});
		var path = '/' + op + '?p1=' + a + '&p2=' + b;
		console.log('> calling the servcie !');
		wsClient.get(wsClient.url.href + path, function(err, req, res, obj){
			assert.ifError(err);
			if (obj.result) {
				console.log('%s called with: p1=%d & p2=%d - Server returned: %d', op, a, b, obj.result);
				callback(a + ' ' + signo(op) + ' ' + b + ' = ' + obj.result);
			} else {
				callback('ERROR');	
			}
		});
	});
};

function signo(operation) {
	if (operation == 'sumar') return '+';
	if (operation == 'restar') return '-';
	if (operation ==  'multiplicar') return '*';
	if (operation == 'dividir') return '/';
	return 'UNKNOW';
}