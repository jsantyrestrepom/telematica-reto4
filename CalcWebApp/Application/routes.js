	/* variables */
var model = require('./model');


	// return the ejs templates with the apropiate data
exports.index = function(request, response) {
	var rdata = model.doTheMath(request, response);
	response.render('index', {result : rdata});
}