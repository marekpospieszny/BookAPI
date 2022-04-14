<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h4>Book details:</h4>
<br/>
<ul class="list-group">
<label class="form-label">ID:</label>
    <li class="list-group-item">${book.id}</li>
<label class="form-label">Author:</label>
    <li class="list-group-item">${book.author}</li>
<label class="form-label">Isbn:</label>
    <li class="list-group-item">${book.isbn}</li>
<label class="form-label">Publisher:</label>
    <li class="list-group-item">${book.publisher}</li>
<label class="form-label">Title:</label>
    <li class="list-group-item">${book.title}</li>
<label class="form-label">Type:</label>
    <li class="list-group-item">${book.type}</li>
</ul>

<a href="/admin/books/all" class="btn btn-secondary">Return</a>

</body>
</html>
