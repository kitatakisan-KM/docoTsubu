<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>ユーザー登録</h1>
<form action="/docoTsubu/Usersave" method="post">
 ユーザー名：<input type="text" name="username"><br>
 パスワード：<input type="password" name="pass"><br>
 <input type="submit" value="登録">
 </form>
</body>
</html>