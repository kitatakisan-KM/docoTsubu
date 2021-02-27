<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<c:choose>
 <c:when test="${result}">
 <h1>登録に成功しました</h1>
 </c:when>
 <c:otherwise>
 <h1>登録に失敗しました</h1>
 </c:otherwise>
</c:choose>
<a href="/docoTsubu/">トップへ戻る</a>

</body>
</html>