<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<title>Optic Store</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="">Web Optical Store</a>
		
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    
	    <div class="collapse navbar-collapse" id="navbarResponsive">
	      <ul class="navbar-nav ml-auto">
	        <li class="nav-item active">
	          <a class="nav-link" href="">UserName: ${customer.getName()}
	            <span class="sr-only">(current)</span>
	          </a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="">User id: ${customer.getId()}</a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="http://localhost:8080/OpticStore/cart">Cart</a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="http://localhost:8080/OpticStore/customerPage/logout">LogOut</a>
	        </li>
	      </ul>
	    </div>
	</nav>
	
	<div class="container" style="padding-top:70px;">
	
		<div class="jumbotron">
			<div style='text-align:center;'>
				<h3>Home Page</h3>
				<p>You can check or add your prescriptions and go to the store.</p>
			</div>
			<hr class="my-4">
		</div>
		
		<table class="table table-hover">
			<caption>List of Prescriptions</caption>
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Sphere</th>
		      <th scope="col">Cil</th>
		      <th scope="col">Axis</th>
		    </tr>
		  </thead>
		  <tbody>
		    ${prescriptions}
		  </tbody>
		</table>
		
		<form method="post">
			<button type="submit" class="btn btn-outline-secondary" name="addPresc" value="submit">Add Prescription</button>
		</form>
		
		<div class="bd-example" style="padding-top: 30px">
 			<div id="shopOptions" class="carousel slide" data-ride="carousel">
 			
				<ol class="carousel-indicators">
					<li data-target="#shopOptions" data-slide-to="0" class="active"></li>
					<li data-target="#shopOptions" data-slide-to="1"></li>
		    	</ol>
		    	
		    	<div class="carousel-inner">
		      		<div class="carousel-item active">
		        		<a href="http://localhost:8080/OpticStore/shop/frames"><img src="./resources/glasses.jpg" class="d-block w-100"></a>
		        		<div class="carousel-caption d-none d-md-block">
		          			<h5>Glasses</h5>
		          			<p>Find your best fit</p>
		        		</div>
		      		</div>
		      		
		      		<div class="carousel-item">
		        		<a href="http://localhost:8080/OpticStore/shop/contact-lens"><img src="./resources/glasses.jpg" class="d-block w-100"></a>
		        		<div class="carousel-caption d-none d-md-block">
		          			<h5>Contact lens</h5>
		          			<p>Get the most comfortable lens</p>
		        		</div>
		      		</div>
		    	</div>
		    	
		    <a class="carousel-control-prev" href="#shopOptions" role="button" data-slide="prev">
		      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		      <span class="sr-only">Previous</span>
		    </a>
		    <a class="carousel-control-next" href="#shopOptions" role="button" data-slide="next">
		      <span class="carousel-control-next-icon" aria-hidden="true"></span>
		      <span class="sr-only">Next</span>
		    </a>
		  </div>
		</div>
	</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>