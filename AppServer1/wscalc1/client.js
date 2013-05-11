	/* variables */
var assert = require('assert'),
	restify = require('restify'),
	client = restify.createJsonClient({
		url : 'http://localhost:8002',
		version : '~0.0.1'
	});


	/* configurations */


	/* paths */
client.get('/wscalc1/echo/Santy', function(err, req, res, obj){
	assert.ifError(err);
	console.log('Server returned: %j', obj);
});

client.get('/wscalc1/sumar?p1=2&p2=1', function(err, req, res, obj){
	assert.ifError(err);
	console.log('sumar called with: p1=2&p2=1 - Server returned: %j', obj);
});

client.get('/wscalc1/multiplicar?p1=2&p2=1', function(err, req, res, obj){
	assert.ifError(err);
	console.log('multiplicar called with: p1=2&p2=1 - Server returned: %j', obj);
});