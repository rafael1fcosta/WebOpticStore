<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
 <meta charset="UTF-8"> 
<title>Optic Store</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="shortcut icon" href="./resources/favicon.ico" type="image/x-icon">
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="http://localhost:8080/OpticStore/customerPage"><img alt="" src="./resources/logo.png" style="width:35px; height:auto;">    Web Optical Store</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/OpticStore/customerPage"><button class="btn btn-sm btn-secondary"><i class="fas fa-user"></i> ${customer.getName()}</button></a></li>

				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/OpticStore/cart"><button class="btn btn-sm btn-success"><i class="fa fa-shopping-cart"></i> <b>${customer.getProductCount()}</b></button></a></li>
				
				<li class="nav-item">
	          		<a class="nav-link" href="http://localhost:8080/OpticStore/shop/logout"><button class="btn btn-sm btn-danger">LogOut</button></a>
	        	</li>
			</ul>
		</div>
	</nav>
	
	<div class="jumbotron" style="text-align: center; margin-top: 20px;">
		<h1 class="display-4">Cart</h1>
	</div>

	<div class="container">

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Product Id</th>
					<th scope="col">Product Name</th>
					<th scope="col">Brand</th>
					<th scope="col">Price</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				${products}
			</tbody>
		</table>
		<div class="container text-right">
			<button type="button" class="btn btn-outline-success btn-lg">Checkout</button>
		</div>

	</div>



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>