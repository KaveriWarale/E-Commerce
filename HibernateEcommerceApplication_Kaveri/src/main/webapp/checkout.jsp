
<%
Customer customer1 = (Customer) session.getAttribute("current_user");
if (customer1 == null) {
	session.setAttribute("error_message", "You are not Login, Please Login..");
	response.sendRedirect("login.jsp");
	return;
}
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
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
	<div class="row ml-2 mr-2 mt-2">
		<div class="col-md-6">
			<div class="cart-body border"></div>
			<div class="text-center mt-2">
				<a href="index.jsp">
					<button type="button" class="btn btn-primary">Continue
						Shopping</button>
				</a>
			</div>
		</div>
		<div class="col-md-6">
			<%=customer1.getCustomerName()%>
			<br>
			<%=customer1.getCustomerAddress()%>
			<br>
			<%=customer1.getCustomerContact()%>
		</div>
	</div>

</body>
</html>