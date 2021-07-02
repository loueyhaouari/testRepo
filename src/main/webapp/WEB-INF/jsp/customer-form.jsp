<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Save customer</title>
    <link type="text/css" rel="stylesheet" href="../../ressources/css/style.css">
    <link type="text/css" rel="stylesheet" href="../../ressources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
<h2 style="background-color: #09c332">Customer RelationShip Manager</h2>
    </div>
</div>
<div id="container">
<h3>Save Customer</h3>
<%--@elvariable id="customer" type="java"--%>
<form:form action="saveCustomer" modelAttribute="customer" method="post">
<form:hidden path="id"/>
    <table>
<tbody>
<tr>
    <td><label>First name:</label></td>
    <td><form:input path="firstName" /></td>
</tr>
<tr>
    <td><label>Last name:</label></td>
    <td><form:input path="lastName" /></td>
</tr>
<tr>
    <td><label>Email:</label></td>
    <td><form:input path="email" /></td>
</tr>
</tbody>
    </table>
    <tr>
        <td><label></label></td>
        <td><input type="submit" value="Save" class="save" /></td>
    </tr>
</form:form>

</div>
</body>
</html>