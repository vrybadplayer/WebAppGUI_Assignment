<%-- 
    Document   : staffLogin
    Created on : 27 Apr 2024, 3:24:14 PM
    Author     : sumsn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Staff Intranet</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@500&display=swap" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@500;700&display=swap" />
        <link rel="stylesheet" href="css/staffLogin.css" />
    </head>
    <body>
        <% //logout, everytime user access this page, ends current user session
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession sessionEnd = request.getSession(false);
            sessionEnd.invalidate();
        %>
        <form action="StaffLogin">
            <div class="main-container">
                <div class="paragraph-heading">
                    <div class="group-1">
                        <span class="staff-login-form">Staff Login Form</span>
                    </div>
                </div>
                <span class="staff-id">Staff ID</span>
                <div class="flex-row-ae">
                    <span class="label">Placeholder</span>
                    <input class="field" name="staffId">
                </div>
                <span class="username">Username</span>
                <div class="flex-row-eb">
                    <span class="label-2">Placeholder</span>
                    <input class="field-3" name="staffUsername">
                </div>
                <div class="input-field-label">
                    <div class="group-4"><span class="password-input">Password</span></div>
                </div>
                <div class="flex-row">
                    <span class="placeholder-label">Placeholder</span>
                    <input type="password" class="input-field" name="staffPassword">
                </div>
                <div class="link-container">
                    <br/><a href="StaffChangeCredentials.jsp">Change Username and Password ></a>
                    <br/><a href="manager/StaffHomepage.jsp">Manager's Intranet ></a>
                </div>
                <button class="secondary-button">
                    <div class="section-3"><span class="text-8">Button</span></div>
                </button>
                <div class="img"></div>
            </div>
        </form>
    </body>
</html>
