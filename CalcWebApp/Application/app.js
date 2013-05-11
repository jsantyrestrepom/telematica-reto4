	/* variables */
var express = require('express'),
	routes = require('./routes'),
	app = express(),
	server = require('http').createServer(app);

server.listen(8080);
console.log("=> Running . . . .");


	/* configuration */
app.configure(function(){
	app.set('view engine', 'ejs');		// templates motor
	app.set('views', __dirname + '/views');
	app.use(express.bodyParser());
	app.use('/static', express.static(__dirname + '/public'));
})


	/* paths */
//	POST - GET - PUT - DELETE - OPTIONS - HEAD
app.get('/', routes.index);