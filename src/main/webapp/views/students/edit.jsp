<%--
  Created by IntelliJ IDEA.
  User: chickadoo
  Date: 11/12/2023
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h2>Edit Student</h2>
<form action="/student?action=update" method="post">
    <div class="form-group">
        <label for="exampleInputName">Name</label>
        <input type="text" name="name" value="<c:out value="${student.getStudentName()}"/>" class="form-control" id="exampleInputName">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail">Email address</label>
        <input type="email" name="email" value="<c:out value="${student.getEmail()}"/>" class="form-control" id="exampleInputEmail">
    </div>
    <div class="form-group">
        <label for="exampleInputDate">Date of Birth</label>
        <input type="date" name="date" value="<c:out value="${student.getDateOfBirth()}"/>" class="form-control" id="exampleInputDate" placeholder="Enter date of birth">
    </div>
    <div class="form-group">
        <label for="exampleInputAddress">Address</label>
        <input type="text" name="address" value="<c:out value="${student.getAddress()}"/>" class="form-control" id="exampleInputAddress" placeholder="Enter address">
    </div>
    <div class="form-group">
        <label for="exampleInputPhone">Phone Number</label>
        <input type="number" name="phone" value="<c:out value="${student.getPhone()}"/>" class="form-control" id="exampleInputPhone" placeholder="Enter phone number">
    </div>
    <div class="form-group">
        <label>Class</label>
        <select class="form-control form-control-lg" name="class" required>
            <option value="<c:out value="${student.getClassName()}"/>">Open this select menu</option>
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
