<%--
  Created by IntelliJ IDEA.
  User: chickadoo
  Date: 11/12/2023
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h2>Add new Student</h2>
<form action="/student?action=create" method="post">
    <div class="form-group">
        <label for="exampleInputName">Name</label>
        <input type="text" name="name" class="form-control" id="exampleInputName" placeholder="Enter name">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail">Email address</label>
        <input type="email" name="email" class="form-control" id="exampleInputEmail" placeholder="Enter email">
    </div>
    <div class="form-group">
        <label for="exampleInputDate">Date of Birth</label>
        <input type="date" name="date" class="form-control" id="exampleInputDate" placeholder="Enter date of birth">
    </div>
    <div class="form-group">
        <label for="exampleInputAddress">Address</label>
        <input type="text" name="address" class="form-control" id="exampleInputAddress" placeholder="Enter address">
    </div>
    <div class="form-group">
        <label for="exampleInputPhone">Phone Number</label>
        <input type="number" name="phone" class="form-control" id="exampleInputPhone" placeholder="Enter phone number">
    </div>
    <div class="form-group">
        <label>Class</label>
        <select class="form-control form-control-lg" name="class" required>
            <option value="">Open this select menu</option>
            <c:forEach items="${classRooms}" var="className">
                <option value="${className.getId()}">${className.getClassName()}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
