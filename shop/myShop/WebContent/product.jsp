<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<center>

Name of Product :<h2 style="color:green"><c:out value="${data[1]}"></c:out> <br></h2>
Price :<h4><c:out value="${data[2]}$"></c:out></h4>

<form action="/myShop/DelProduct" method="post">

<input type="hidden" value="${data[0]}" name="id">
<input type="submit" value="Delete">


</form>
<form action="/myShop/update.jsp">

<input type="hidden" value="${data[0]}" name="id">
<input type="submit" value="Update">

</form>
</center>

</body>
</html>