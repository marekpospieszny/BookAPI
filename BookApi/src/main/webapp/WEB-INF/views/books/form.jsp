<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:hidden path="id"/>
<div class="mb-3">
<div class="mb-3">
    <label class="form-label">Author:</label>
        <form:input path="author"/>
        <form:errors path="author"/>
</div>
<div class="mb-3">
    <label class="col-form-label">ISBN:</label>
        <form:input path="isbn"/>
        <form:errors path="isbn"/>
</div>
<div class="mb-3">
    <label class="col-form-label">Publisher:</label>
        <form:input path="publisher"/>
        <form:errors path="publisher"/>
</div>
<div class="mb-3">
    <label class="col-form-label">Title:</label>
        <form:input path="title"/>
        <form:errors path="title"/>
</div>
<div class="mb-3">
    <label class="col-form-label">Type:</label>
        <form:input path="type"/>
        <form:errors path="type"/>
</div>
</div>
<br/>