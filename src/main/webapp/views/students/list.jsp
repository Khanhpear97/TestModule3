<%--
  Created by IntelliJ IDEA.
  User: chickadoo
  Date: 11/12/2023
  Time: 00:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Students</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="col-12 col-md-12">
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col-md-6">
                        <a href="/student?action=create" class="btn btn-primary">Add</a>
                    </div>
                    <div class="col-md-5">
                        <form action="/student" method="get">
                            <input type="text" class="input-group-text" name="keyword" value="">
                            <button type="submit" class="btn btn-outline-success">Search</button>
                        </form>
                    </div>
                </div>
            </div>

            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Date Of Birth</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Classroom</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td><c:out value="${student.getId()}"/></td>
                            <td><c:out value="${student.getStudentName()}"/></td>
                            <td><c:out value="${student.getDateOfBirth()}"/></td>
                            <td><c:out value="${student.getEmail()}"/></td>
                            <td><c:out value="${student.getAddress()}"/></td>
                            <td><c:out value="${student.getPhone()}"/></td>
                            <td><c:out value="${student.getClassName()}"/></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/student?action=update&id=<c:out value="${student.getId()}"/>" class="btn btn-warning">Edit</a>
                                <a onclick="return confirm('Are you sure?')" href="${pageContext.request.contextPath}/student?action=delete&id=<c:out value="${student.getId()}"/>" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
