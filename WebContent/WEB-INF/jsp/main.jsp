<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="login.User,login.Mutter,java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
 <h1>どこつぶメイン</h1>
 <c:out value="${user.name}"/>さん、ログイン中
 <a href="/docoTsubu/Logout">ログアウト</a><br>
 <a href="/docoTsubu/Main">更新</a><br>
 <form action="/docoTsubu/Main" method="post">
 <input type="text" name="text">
 <input type="submit" value="つぶやく">
 </form>
 <c:if test="${not empty errorMsg}">
 <p>${errorMsg}</p>
 </c:if>
 <c:forEach var="mutter" items="${mutterList}">
 <p><c:out value="${mutter.userName}"/>:<c:out value="${mutter.mutter}"/></p>
 </c:forEach>
</body>
</html>