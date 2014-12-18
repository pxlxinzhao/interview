<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Congratulations!</h1>
Your username is <%= request.getParameter ("username") %> 
password is <%= request.getParameter ("passwd") %>
<br>
<c:forEach var="user" items="${userSet}">
<c:out value="${user}"></c:out>
</c:forEach>

<c:forEach var="i" begin="1" end="5">
    Item <c:out value="${i}"/>
</c:forEach>

</body>
</html>