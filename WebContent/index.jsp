<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
 <h1>どこぶつへようこそ</h1>
 <form action="/docoTsubu/Login" method="post">
 ユーザー名：<input type="text" name="username"><br>
 パスワード：<input type="password" name="pass"><br>
 <input type="submit" value="ログイン">
 </form>
 <a href="/docoTsubu/Usersave">登録</a>
</body>
</html>