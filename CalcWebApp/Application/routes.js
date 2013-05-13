	/* variables */
var model = require('./model');


	/* methods */
// return the ejs templates with the apropiate data
exports.index = function(request, response) {
	response.render('index', {results : ''});
};

exports.webservice = function(request, response) {
	var data = '';
	data = model.doTheMath(request, response, function(data){
		response.render('index', {results : data});
	});
};