<%@page import="com.kaveri.ecomapp.model.Customer"%>
<%
Customer customer = (Customer) session.getAttribute("current_user");
%>
<nav class="navbar navbar-expand-lg navbar-light navabr-bg">
	<a class="navbar-brand" href="#"> <img
		src="images/shopping-bag.png" width="45px" height="45px">
	</a>

	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">About</a></li>

			<li class="nav-item"><a class="nav-link">Product</a></li>

		</ul>
		<form class="form-inline">
			<input style="width: 400px; margin-left: 20px;"
				class="form-control mr-sm-2" type="search" placeholder="Search for Products"
				aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>

	<div data-toggle="modal" data-target="#cart_ckeckout">
		<img src="images/cart.png"
			style="width: 45px; height: 35px; margin-right: 2px;"> <span
			style="margin-right: 10px; color: white;" class="cart-items">
			<b>( 0 )</b></span>
	</div>
	<%
	if (customer == null) {
	%>
	<a href="customer_register.jsp">
		<button class="btn btn-outline-success my-2 my-sm-0 mr-sm-2"
			type="button">Register</button>
	</a> <a href="login.jsp">
		<button class="btn btn-outline-success my-2 my-sm-0 mr-sm-2"
			type="button">Login</button>
	</a>
	<%
	} else {
	%>
	<h5 class="my-2 my-sm-0 mr-sm-2 text-white">
		<a
			href="<%=customer.getUserType().equals("admin") ? "admin_dashboard.jsp" : "customer_dashboard.jsp"%>"
			class="text-white"> <%=customer.getCustomerName()%>
		</a>
	</h5>
	<!-- <form action="logout" method="get"> -->
	<a href="Logout">
		<Button class="btn btn-danger my-2 my-sm-0 mr-sm-2">Logout</Button>
	</a>
	<!-- </form> -->
	<%
	}
	%>
</nav>


<div class="modal fade" id="cart_ckeckout" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Your Cart</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="cart-body"></div>

			</div>
			<div class="modal-footer mt-0">
				<a href="index.jsp">
					<button type="button" class="btn btn-primary">Continue
						Shopping</button>
				</a> <a href="checkout.jsp">
					<button type="button" class="btn btn-success checkout-button">
						CheckOut</button>
				</a>
			</div>
		</div>
	</div>
</div>


