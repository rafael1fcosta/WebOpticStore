<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
 <meta charset="UTF-8"> 
<title>Optic Store</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="">Web Optical Store</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="http://localhost:8080/OpticStore/customerPage">
					UserName: ${customer.getName()} <span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="">User id:
						${customer.getId()}</a></li>

				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/OpticStore/cart">Cart</a></li>
				
				<li class="nav-item">
	          		<a class="nav-link" href="http://localhost:8080/OpticStore/shop/logout">LogOut</a>
	        	</li>
			</ul>
		</div>
	</nav>
	
	<div class="jumbotron" style="text-align: center; margin-top: 20px;">
		<h1 class="display-4">${type}</h1>
	</div>

	<div class="container">

		<div class="row">

			${options}


			<div class="col-lg-9">

				<div id="headLines" class="carousel slide my-4" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#headLines" data-slide-to="0" class="active"></li>
						<li data-target="#headLines" data-slide-to="1"></li>
						<li data-target="#headLines" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#headLines" role="button"
						data-slide="prev"> <span class="carousel-control-prev-icon"
						aria-hidden="true"></span> <span class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#headLines" role="button"
						data-slide="next"> <span class="carousel-control-next-icon"
						aria-hidden="true"></span> <span class="sr-only">Next</span>
					</a>
				</div>



				<div class="row" id="products">
				
					${products}

				</div>
			</div>
		</div>
	</div>

	
	<script>
	
		var brands = document.getElementById("brands").childNodes;
	
		var products = document.getElementById("products");
		
		console.log(brands);
		console.log(products);

	
	</script>


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