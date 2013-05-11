$('#op').submit(function() {
	alert('Handler for .submit() called.');
	return false;
});

$('.operations li').click(function(){
	if (this.val()=='SUMAR') {
		$('#op').val('sumar');
	}
	if (this.val()=='RESTAR') {
		$('#op').val('restar');
	}
	if (this.val()=='MULTIPLICAR') {
		$('#op').val('multiplicar');
	}
	if (this.val()=='DIVIDIR') {
		$('#op').val('dividir');
	}
	$('#form-calc').submit();
});