<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<%--
// action 에 /save 하면 절대경로로 인식되지만 / 없이 save 를 하면 현재 디렉토리에서 save 라는 패스로 생성된다
// ex) /save : http://localhost:8080/save
// ex) save : http://localhost:8080/servlet-mvc/members/save 가 된다
// 보통은 절대경로로 해주는게 더좋다고한다.
--%>
<form action="save" method="post">
    username: <input type="text" name="username" />
    age:      <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
