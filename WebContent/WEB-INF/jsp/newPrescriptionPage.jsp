<!DOCTYPE html>
<html>
<head>
<title>Optic Store</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="#">Web Optical Store</a>
		
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    
	    <div class="collapse navbar-collapse" id="navbarResponsive">
	      <ul class="navbar-nav ml-auto">
	        <li class="nav-item active">
	          <a class="nav-link" href="http://localhost:8080/OpticStore/customerPage">UserName: ${customer.getName()}
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
	          <a class="nav-link" href="http://localhost:8080/OpticStore/newPrescriptionPage/logout">LogOut</a>
	        </li>
	        
	      </ul>
	    </div>
	</nav>

	<div class="container" style="padding-top:70px;">
	
		${alert}
	
		<form method="post">
		
			<div class="form-group">
				<label class="my-1 mr-2" for="sphere">Sphere</label>
				<input type="number" min="-10" max="10" step="0.25" class="form-control" id="sphere" name="sphere" placeholder="Enter sphere">
			</div>
			
			<div class="form-group">
				<label class="my-1 mr-2" for="cil">Cylinder</label>
				<input type="number" min="-6" max="+6" step="0.25" class="form-control" id="cil" name="cil" placeholder="Enter cylinder">
			</div>
			
			<div class="form-group">
				<label class="my-1 mr-2" for="axis">Axis</label>
				<input type="number" min="0" max="180" class="form-control" id="axis" name="axis" placeholder="Enter axis">
			</div>
			
			<button type="submit" class="btn btn-outline-success" name="save" value="submit">Save</button>
		</form>
	</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>