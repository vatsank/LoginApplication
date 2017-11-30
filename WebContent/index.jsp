<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Application</title>
</head>
<body>
<%@include file="Header.html" %>
<span style="color: red"><c:out value="${param.errMsg}"/></span>
<section>
<fieldset>
<form action="Validate.jsp" method="post">

<div>
	<label for="">User Name</label>
	<input type="text"  name="userName" required placeholder="Enter the User Name" />
</div>
<div>
	<label for="">PassWord</label>
	<input type="password"  name="passWord"  required/>
	</div>
	<div>
		<input type="submit"  value="Login"/>
</div>
</form>
</fieldset>
</section>
<jsp:include page="Footer.jsp"/>
</body>
</html>