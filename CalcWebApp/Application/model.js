	/* variables */
var assert = require('assert'),
	restify = require('restify');


exports.doTheMath = function(request, response, callback) {
	var result = '';
	if (request.param('p1') && request.param('op') && request.param('p2')) {
		var op = request.query.op;
		if (validateOperation(op)) {
			result = callService(request.query.p1, op, request.query.p2, function(){
				console.log('> ' + result);
			});
			//console.log('> ' + result);
			// return result;
		} else {
			console.log('> no entiendo la operacion');
			//return result;
		}
	} else {
		console.log('> no entiendo los parametros');
		// return result;
	}
}

function callService(a, op ,b, callback) {
	console.log('=> Locate the service');
	var signo = 'sgino';
	var path = '/wscalc2/' + op + '?p1=' + a + '&p2=' + b;
	var wsClient = restify.createJsonClient({
		url : "http://localhost:8004",
		version : "~0.0.1"
	});
	console.log('=> Calling the servcie !');
	wsClient.get(path, function(err, req, res, obj){
		assert.ifError(err);
		console.log('%s called with: p1=%d&p2=%d - Server returned: %j', op, a, b, obj);
		if (obj.result) {
			return a + ' ' + signo + ' ' + b + ' = ' + obj.result;
		} else {
			return 'ERROR';	
		}
	});
}


function validateOperation(op) {
	if (!(op=='sumar' || op=='restar' || op=='multiplicar' || op=='dividir'))
		return false;
	else
		return true;
}