	/* variables */
var assert = require('assert'),
	restify = require('restify'),
	client = restify.createJsonClient({
		url : 'http://localhost:8004',
		version : '~0.0.1'
	});


	/* configurations */


	/* paths */
client.get('/echo/Santy', function(err, req, res, obj){
	assert.ifError(err);
	console.log('Server returned: %j', obj);
});

client.get('/wscalc2/restar?p1=-1&p2=1', function(err, req, res, obj){
	assert.ifError(err);
	console.log('restar called with: p1=-1&p2=1 - Server returned: %j', obj);
});

client.get('/wscalc2/dividir?p1=100&p2=4', function(err, req, res, obj){
	assert.ifError(err);
	console.log('dividir called with: p1=100&p2=4 - Server returned: %j', obj);
});