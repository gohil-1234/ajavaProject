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
<% String id= request.getParameter("id"); %>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/project" user="root" password="gohil"/>
	<sql:query var="rs" dataSource="${db}">select * from products where id=<%=id %></sql:query> 

<c:forEach items="${rs.rows}" var="product">
	
         	
          <form action="/myShop/UpdateProduct" method="post">
          
          <input type="text" name="name" value="${product.name }"><br>
          <input type="text" name="price" value="${product.price }"><br>
          <input type="hidden" value="${product.id }" name="id">
          <input type="submit" value="Update">
          </form>
            
      
     
 	</c:forEach>



</body>
</html>