
<%
String success_message = (String) session.getAttribute("success_message");

String error_message = (String) session.getAttribute("error_message");

if (success_message != null) {
%>

<div class="alert alert-success alert-dismissible fade show"
	role="alert">
	<strong><%=success_message%></strong>
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<%
}
session.removeAttribute("success_message");
%>


<%
if (error_message != null) {
%>

<div class="alert alert-danger alert-dismissible fade show" role="alert">
	<strong><%=error_message%></strong>
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<%
}
session.removeAttribute("error_message");
%>