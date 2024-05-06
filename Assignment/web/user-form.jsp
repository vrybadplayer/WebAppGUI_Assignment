<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<fmt:formatDate value="${user.dob}" pattern="yyyy-MM-dd" var="formattedDate" />


<html>
    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #8500A6">
                <ul class="navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/list" class="nav-link">Customers</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${user != null}">
                        <form action="${pageContext.request.contextPath}/update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="${pageContext.request.contextPath}/insert" method="post">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${user != null}">
                                        Edit Customer
                                    </c:if>
                                    <c:if test="${user == null}">
                                        Add New Customer
                                    </c:if>
                                </h2>
                            </caption>

                            <c:if test="${user != null}">
                                <input type="hidden" name="id" value="${user.custID}" />
                            </c:if>

                            <fieldset class="form-group">
                                <label>Full Name</label> <input type="text" value="${user.fullName}" class="form-control" name="fullName" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Date of Birth</label>
                                <input type="date" value="${formattedDate}" class="form-control" name="dob">
                            </fieldset>


                            <fieldset class="form-group">
                                <label>Address</label> <input type="text" value="${user.address}" class="form-control" name="address">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Email</label> <input type="email" value="${user.email}" class="form-control" name="email">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Phone Number</label> <input type="tel" value="${user.phoneNumber}" class="form-control" name="phoneNumber">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Username</label> <input type="text" value="${user.username}" class="form-control" name="username">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Password</label> <input type="password" value="${user.password}" class="form-control" name="password">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>IC Number</label> <input type="text" value="${user.icNumber}" class="form-control" name="icNumber">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>City</label> <input type="text" value="${user.city}" class="form-control" name="city">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Postcode</label> <input type="text" value="${user.postcode}" class="form-control" name="postcode">
                            </fieldset>

                            <button type="submit" class="btn btn-success">Save</button>
                        </form>
                </div>
            </div>
        </div>
    </body>
</html>
