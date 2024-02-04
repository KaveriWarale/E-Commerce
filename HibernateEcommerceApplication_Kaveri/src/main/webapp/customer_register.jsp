<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rgistration</title>
<%@include file="components/commen_css_js.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
				
				<%@include file="components/message.jsp"%>
				
					<h3 class="text-center my-3">Sign Up Here..</h3>
					<div class="container-fluid">
						<form action="EcommerceController" method="POST" enctype="multipart/form-data">
							<input type="hidden" name="action" value="signUp">
							<div class="form-group">
								<label>Name</label> <input type="text" name="customerName"
									class="form-control" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label>Email</label> <input type="email" name="customerEmail"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Password</label> <input type="password"
									name="customerPassword" class="form-control">
							</div>
							<div class="form-group">
								<label>Contact</label> <input type="number"
									name="customerContact" class="form-control">
							</div>
							<div class="form-group">
								<label>Address</label> <input type="text"
									name="customerAddress" class="form-control">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Photo</label> <input
									type="file" name="customerPhoto" class="form-control">
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>

							<button type="button" class="btn btn-warning">Cancel</button>
						</form>
					</div>
				</div>
			</div>





		</div>
	</div>



</body>
</html>