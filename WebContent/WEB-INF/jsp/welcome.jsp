<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<title>Optic Store</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

	<div class="container">
		<div class="jumbotron">
			<h1 class="display-4">Web Optic Store</h1>
			<p>Optical services online</p>
			<hr class="my-4">
			<div style='text-align:center;'>
				
				<h3>Welcome</h3>
				<p>Insert your UserName and your login number</p>
			</div>
		</div>
		
  		${alert}
		
		<form method="post">
			<div class="form-group">
				<label for="name">UserName</label>
				<input type="text" class="form-control" name="name" id="name" placeholder="Enter UserName">
			</div>
			<div class="form-group">
				<label for="id">Longin Number</label>
				<input type="text" class="form-control" name="id" id="id" placeholder="Enter Login Number">
			</div>
			
			<div class="button-box col-lg-12">
				<button type="submit" class="btn btn-outline-secondary" value="submit">Submit</button>
				<button type="submit" class="btn btn-outline-secondary" name="newCustomer" value="submit">New Customer</button>
			</div>
			
		</form>
	</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>