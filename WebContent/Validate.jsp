<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validate Page</title>
</head>
<body>
<c:set var="pageVisited" value="authenticated" scope="session"></c:set>
<jsp:useBean id="validateBean" class="com.training.entity.ValidatorBean" scope="session"/>

<jsp:setProperty property="*" name="validateBean"/>

<c:set var="status" value="${validateBean.validate()}"/>

<c:if test="${status}">
 <jsp:forward page="Welcome.jsp"/>
</c:if>


<c:if test="${!status}">
 <jsp:forward page="index.jsp">
       <jsp:param value="Invalid UserName or passWord" name="errMsg"/>
 </jsp:forward>
</c:if>

</body>
</html>