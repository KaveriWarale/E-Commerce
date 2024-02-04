<%@page import="com.kaveri.ecomapp.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.kaveri.ecomapp.service.EcommerceServiceImpl"%>
<%@page import="com.kaveri.ecomapp.service.EcommerceService"%>
<%@page import="com.kaveri.ecomapp.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<%@include file="components/commen_css_js.jsp"%>
</head>
<body>
	
	<%@include file="components/navbar.jsp"%>

	<div class="container">
		<div class="container-fluid mt-3">
			<%@include file="components/message.jsp"%>
		</div>
	</div>
	<div class="row mt-2 ml-2 mr-2">
		<div class="col-md-2">
			<img src="data:image/jpeg;base64,<%=customer.getCustomerImage()%>"
				width="100" height="100" class="rounded-circle" />
		</div>

		<div class="col-md-10">
			<div class="row">

				<div class="col-md-6">
					<div class="card">
						<div class="card-body">
							<button type="button" class="dropdown-item" data-toggle="modal"
								data-target="#addCategory">Category</button>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card">
						<div class="card-body">
							<button type="button" class="dropdown-item" data-toggle="modal"
								data-target="#addProducts">Product</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Start Modal for Add Category -->
	<div class="modal fade" id="addCategory" data-backdrop="static"
		data-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">

		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header bg-primary text-white">
					<h5 class="modal-title" id="exampleModalLabel">Add Category
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="EcommerceController" method="POST">
						<input type="hidden" name="action" value="addCategory">

						<div class="form-group">
							<label>Category Name</label> <input type="text"
								name="categoryName" class="form-control">
						</div>
						<div class="form-group">
							<label>Category Description</label>
							<textarea rows="7" cols="30" class="form-control"
								name="categoryDes"></textarea>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-primary">Add
								Category</button>

							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- End Closed Modal for Add Category -->


	<!-- Start Modal for Add Products -->
	<div class="modal fade" id="addProducts" data-backdrop="static"
		data-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">

		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header bg-primary text-white">
					<h5 class="modal-title" id="exampleModalLabel">Add Product
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="EcommerceController" method="POST"
						enctype="multipart/form-data">
						<input type="hidden" name="action" value="addProducts">

						<div class="form-group">
							<label>Product Name</label> <input type="text" name="productName"
								placeholder="Product Name" class="form-control">
						</div>
						<div class="form-group">

							<textarea rows="5" cols="30" class="form-control"
								name="productDescription" placeholder="Product Description"></textarea>
						</div>
						<div class="form-group">
							<input type="file" name="productPhoto" class="form-control">
						</div>
						<div class="form-group">
							<input type="text" name="productColor"
								placeholder="Product Color" class="form-control">
						</div>
						<div class="form-group">
							<input type="number" name="productPrice"
								placeholder="Product Price" class="form-control">
						</div>
						<div class="form-group">
							<input type="number" name="productDiscount"
								placeholder="Product Discount" class="form-control">
						</div>
						<div class="form-group">
							<input type="number" name="productQuantity"
								placeholder="Product Quantity" class="form-control">
						</div>

						<div class="form-group">
							<select name="productCategory" class="form-control">
								<option>Select Category</option>
								<%
								EcommerceService ecommerceService = new EcommerceServiceImpl();
								List<Category> list = ecommerceService.allCategory();
								for (Category c : list) {
								%>
								<option value="<%=c.getCategoryId()%>"><%=c.getCategoryName()%></option>
								<%
								}
								%>
							</select>
						</div>

						<div class="text-center">
							<button type="submit" class="btn btn-primary">Add
								Product</button>

							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!--End Closed Modal for Add Products -->

</body>
</html>