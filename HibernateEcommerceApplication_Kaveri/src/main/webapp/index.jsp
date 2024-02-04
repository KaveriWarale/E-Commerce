<%@page import="com.kaveri.ecomapp.model.Product"%>
<%@page import="com.kaveri.ecomapp.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.kaveri.ecomapp.service.EcommerceServiceImpl"%>
<%@page import="com.kaveri.ecomapp.service.EcommerceService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="components/commen_css_js.jsp"%>

<style>
@media ( min-width : 576px) {
	.card-columns {
		orphans: 0;
		widows: 0;
	}
}

.card-columns {
	-webkit-column-count: 5;
	-moz-column-count: 5;
	column-count: 5;
	column-gap: 0.5rem;
	column-width: 200px;
}

.button-remove {
    background-color: transparent;
    background-repeat: no-repeat;
    border: none;
    cursor: pointer;
    overflow: hidden;
    outline: none;
}
</style>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="ml-2 mr-2">
		<div class="row mt-2 ">
			<div class="col-md-2">

				<div class="list-group">
					<a href="#" style="background: #ff4081; border-color: #ff4081;"
						class="list-group-item list-group-item-action active active-bg">
						Search By Categories</a>
					<%
					EcommerceService ecommerceService = new EcommerceServiceImpl();
					List<Category> list = ecommerceService.allCategory();
					for (Category c : list) {
					%>
					<a href="#" class="list-group-item list-group-item-action"><%=c.getCategoryName()%></a>
					<%
					}
					%>
				</div>
			</div>
			<div class="col-md-10">
				<div class="card-columns">
					<%
					List<Product> productList = ecommerceService.allProducts();
					for (Product p : productList) {
					%>
					<div class="card">
						<img src="data:image/jpeg;base64,<%=p.getProductPhoto()%>"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title mb-0"><%=p.getProductTitle()%>..
							</h5>
							<div><small><%=p.getProductDes() %></small></div>
							<div>
								<b class="mr-2" style="font-size:18px;">&#x20B9;<%=p.getFinalPriceWithDiscount()%></b>
								<b class="text-success"><%=p.getProductDiscount()%>% off</b>
								<b class="text-muted" style="text-decoration: line-through; margin-left: 10px;">
									&#x20B9;<%=p.getProductPrice()%></b>
							</div>
							<small><%=p.getProductColor()%></small>
							<p class="card-text mt-3">
				<button type="button" onclick="addToCart(<%=p.getProductId()%>,'<%=p.getProductName()%>',<%=p.getFinalPriceWithDiscount()%>)"
				class="btn btn-success btn-sm">Add to Cart </button>
							</p>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>