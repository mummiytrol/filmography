<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>

    <title>Title</title>
</head>
<body>
<h2>Films</h2>
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Year</th>
        <th>Genre</th>
        <th>Watched</th>
        <th>Action</th>
    </tr>
    <c:forEach var="film" items="${filmsList}">
    <tr>
        <td>${film.id}</td>
        <td>${film.title}</td>
        <td>${film.year}</td>
        <td>${film.genre}</td>
        <td>${film.watched}</td>
        <td>
            <a href="/edit/${film.id}">edit</a>
            <a href="/delete/${film.id}">delete</a>
        </td>
    </tr>
    </c:forEach>
    </table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
    <a href="${add}">Add page</a>
</body>
</html>