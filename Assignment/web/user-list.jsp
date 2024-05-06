<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<html>
    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: #8500A6">
                
                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list"
                           class="nav-link">Customers</a></li>
                </ul>
            </nav>
        </header>
        <br>

        <div class="row">

            <div class="container">
                <h3 class="text-center">List of Customers</h3>
                <hr>
                <div class="container text-left">

                    <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Customer</a>

                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Date of Birth</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>IC Number</th>
                            <th>City</th>
                            <th>Postcode</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="user" items="${listUser}">
                            <tr>
                                <td><c:out value="${user.custID}" /></td>
                                <td><c:out value="${user.fullName}" /></td>
                                <td><c:out value="${user.dob}" /></td>
                                <td><c:out value="${user.address}" /></td>
                                <td><c:out value="${user.email}" /></td>
                                <td><c:out value="${user.phoneNumber}" /></td>
                                <td><c:out value="${user.username}" /></td>
                                <td><c:out value="${user.password}" /></td>
                                <td><c:out value="${user.icNumber}" /></td>
                                <td><c:out value="${user.city}" /></td>
                                <td><c:out value="${user.postcode}" /></td>
                                <td>
                                    <a href="edit?id=<c:out value='${user.custID}' />">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a href="delete?id=<c:out value='${user.custID}' />">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>

                </table>
            </div>
        </div>
    </body>
</html>
