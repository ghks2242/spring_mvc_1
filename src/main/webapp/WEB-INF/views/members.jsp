<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>

    <c:forEach var="member" items="${members}" varStatus="index">
        <tr>
         <td><c:out value="${member.id}"/></td>
         <td><c:out value="${member.username}"/></td>
         <td><c:out value="${member.age}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

