	/* variables */
var restify = require('restify'),
	//services = require('./webservice'),
	server = restify.createServer({
		name : 'myserver',
		version : '0.0.1'
	});


	/* configurations */
server.use(restify.acceptParser(server.acceptable));
server.use(restify.queryParser());
server.use(restify.bodyParser());

server.listen(8004, function(){
	console.log('%s listening at %s', server.name, server.url);
})


	/* paths */
server.get('/echo/:name', function(req, res, next){		// test
	res.send(req.params);
	return next();
});

server.get('/wscalc2/restar', function(req, res, next){
	console.log('=> Service called !');
	var a = parseInt(req.query.p1),
		b = parseInt(req.query.p2);
	console.log('> parameters: %d y %d',a, b);
	var data = String(a - b);
	console.log('> result: %d', data);
	res.send({'result' : data});
	return next();
});

server.get('/wscalc2/dividir', function(req, res, next){
	console.log('=> Service called !');
	var a = parseInt(req.query.p1),
		b = parseInt(req.query.p2);
	console.log('> parameters: %d y %d',a, b);
	var data = String(a / b);
	console.log('> result: %d', data);
	res.send({'result' : data});
	return next();
});