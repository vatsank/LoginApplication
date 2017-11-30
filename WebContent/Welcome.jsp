<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome </title>
</head>
<body>
<%@include file="Header.html" %>


<% if(session.getAttribute("pageVisited")!=null) { %>
<div style="float: right;">
Current User:<span style="font-style: italic;"><c:out value="${sessionScope.validateBean.userName}"/></span> 
</div>

<section>
 <form action="AddPlayerServlet">
 <fieldset>
 <div>
 	<label for="">Jersey Number</label>
 	<input type="text" name="jerseyNumber"/>
 	</div>
 	<div>
 	<label for="">Player Name</label>
 	<input type="text"  name="playerName"/>
 	</div>
 	
 	<div>
 	<label for="">Matches Played</label>
 	<input type="text"  name="matchPlayed"/>
 	</div>
 	<div>
 	<label for="">Wicket Taken</label>
 	<input type="text"  name="wicketTaken"/>
 	</div>
 	<div>
 	<label for="">Runs Scored</label>
 	<input type="text"  name="runScored"/>
 	</div>
 	<div>
 	<label for="">Rating</label>
 	<input type="text" name="rating" />
 	</div>
 	<div>
 	<input type="submit" value="Add">
 	</div>
 	</fieldset>
 </form>
</section>
<jsp:include page="Footer.jsp"/>

<%} else { %>
<jsp:forward page="index.jsp">
<jsp:param value="You are Not Authorized to View This page" name="errMsg"/>
</jsp:forward>
<%} %>
</body>
</html>