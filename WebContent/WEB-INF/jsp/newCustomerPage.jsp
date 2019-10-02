<!DOCTYPE html>
<html>
<head>
<title>Optic Store</title>
<link rel="shortcut icon" href="./resources/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <meta http-equiv = "refresh" content = "4; url = http://localhost:8080/OpticStore/welcome" />
</head>

<body>

	<div class="container" style="padding-top:70px;">
		<div class="alert alert-success" role="alert">
			<h4 class="alert-heading">Thank you for register!</h4>
			<p>Your account is being created.</p>
			<hr>
			<p class="mb-0">You will be redirected to the HomePage.</p>
		</div>
	
		<div class="progress">
		  	<div id="bar" class="progress-bar progress-bar-striped progress-bar-animated bg-success" role="progressbar" style="width: 1%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
	</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
	var bar = document.getElementById("bar");
	var width = 1;
	
	function barInit() {
		setInterval(function(){
			width++;
			bar.style.width = width + "%";
		}, 20);		
	}
	
	barInit();
</script>
</body>
</html>