<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit form</title>
</head>
<body>
<h1>Edit book id ${book.id}:</h1>
<form method="post" action="/books/edit/${book.id}">
    <label>ISBN:<input type="text" name="isbn" value="${book.isbn}"></label>
    <label>Title:<input type="text" name="title" value="${book.title}"></label>
    <label>Author:<input type="text" name="author" value="${book.author}"></label>
    <label>Publisher:<input type="text" name="publisher" value="${book.publisher}"></label>
    <label>Type:<input type="text" name="type" value="${book.type}"></label>
    <button type="submit">Edit</button>
</form>
</body>
</html>
