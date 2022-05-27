<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main menu</title>
</head>
<body>
<h1>Books list:</h1>

<table>
  <tr>
    <th>Book Id</th>
    <th>ISBN</th>
    <th>Title</th>
    <th>Author</th>
    <th>Publisher</th>
    <th>Type</th>
    <th>Action</th>
  </tr>
  <c:forEach items="${booksList}" var="book">
    <tr>
      <td>${book.id}.</td>
      <td>${book.isbn}</td>
      <td>${book.title}</td>
      <td>${book.author}</td>
      <td>${book.publisher}</td>
      <td>${book.type}</td>
      <td>
        <form method="get" action="/books/edit/${book.id}">
          <button type="submit">Edit</button>
        </form>
        <form method="get" action="/books/delete/${book.id}">
          <button type="submit">Delete</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>

<h2>Add new book:</h2>
<form method="post" action="/books/">
  <label>ISBN:<input type="text" name="isbn"></label>
  <label>Title:<input type="text" name="title"></label>
  <label>Author:<input type="text" name="author"></label>
  <label>Publisher:<input type="text" name="publisher"></label>
  <label>Type:<input type="text" name="type"></label>
  <button type="submit">Add</button>
</form>

</body>
</html>
