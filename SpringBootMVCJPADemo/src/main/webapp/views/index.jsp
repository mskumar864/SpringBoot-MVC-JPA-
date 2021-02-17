<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to the SPring MVC

<form action="addUser" method="post">

 Enter user id<input type="text" name="uid"/><br>
  Enter user name<input type="text" name="uname"/><br>
  
  <input type="submit">
</form>

<form action="getUser" method="get">

 Enter user id<input type="text" name="uid"/><br>

  
  <input type="submit">
</form>
</body>
</html>