<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin-Thính
  Date: 7/2/2021
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List blog</title>
</head>
<body>
<C:forEach items="${blogs}" var="blog">
    <a href=""><h2>${blog.id}</h2></a>
    <h3>${blog.content}</h3>
    <h3>${blog.name}</h3>
</C:forEach>
</body>
</html>
