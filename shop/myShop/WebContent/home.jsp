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



<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/project" user="root" password="gohil"/>
	<sql:query var="rs" dataSource="${db}">select * from products</sql:query> 

<center>

<h3>My Cart</h3>
<table border="1">
	 <tr>
	 	<td>Name of Product</td>
	 	<td>Price</td>
	 </tr>
	
	
	<c:forEach items="${rs.rows}" var="product">
	
	
	<tr>

	 
	 	<td><a href="/myShop/ViewProduct?id=${product.id}"><c:out value="${product.name }"></c:out></a></td>
	 	<td><c:out value="${product.price}"></c:out>
	 	
	</tr>
	  
	</c:forEach>
	
            
 	 
 	
 </table>
 

 

 <a href="addproduct.html">Add Product</a>
 
 </center>
</body>
</html>