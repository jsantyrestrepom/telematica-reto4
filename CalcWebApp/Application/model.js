exports.doTheMath = function(request, response) {
	var data;
	if (request.param('p1') && request.param('op') && request.param('p2')) {
		var result = callService(request.query.p1, request.query.op, request.query.p2);
		data = request.query.p1 + ' ' + request.query.op + ' ' + request.query.p2 + ' ' + result;
	} else {
		data = '';
	}
	return data;
}

function callService(p1, op ,p2) {
	if (op=='sumar') return p1 + p2;
	if (op=='restar') return p1 - p2;
	if (op=='multiplicar') return p1 * p2;
}