<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
<!-- display user name and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role : <security:authentication property="principal.authorities"/>
	</p>
	<hr>

<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/api/leaders">Leadership Meeting</a>
		(Only for Manager peeps)
	</p>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/api/systems">IT Systems Meeting</a>
		(Only for Admin peeps)
	</p>
</security:authorize>

	<p>Welcome to the luv2code company home page!</p>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
<input type="submit" value="Logout" />
</form:form>

</body>

</html>