<%-- 
    Document   : StaffChangeCredentials
    Created on : 29 Apr 2024, 5:04:52 PM
    Author     : sumsn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Change Credentials</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@500;700&display=swap" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@500&display=swap" />
        <link rel="stylesheet" href="css/StaffChangeCredentials.css">
    </head>
    <body>
        <form action="StaffChangeUserPassword">
            <div class="main-container">
                <div class="paragraph-with-heading">
                    <div class="group-1">
                        <span class="staff-login-form">Staff Login Form</span>
                    </div>
                </div>
                <span class="staff-id">Staff ID</span>
                <div class="flex-row-ae">
                    <span class="label-placeholder">Placeholder</span>
                    <input class="div-field" name="staffid">
                </div>
                <span class="span-new-username">New Username</span>
                <div class="div-flex-row-eb">
                    <span class="label-placeholder-2">Placeholder</span>
                    <input class="field" name="newStaffUsername">
                </div>
                <div class="flex-row-bb">
                    <div class="input-field-label">
                        <div class="group-3">
                            <span class="new-confirm-password">New Confirm Password</span>
                        </div>
                    </div>
                    <div class="input-field-label-4">
                        <div class="group-5">
                            <span class="new-password">New Password</span>
                        </div>
                    </div>
                    <span class="label">Placeholder</span>
                    <input type="password" class="field-6" name="newStaffPassword">
                </div>
                <div class="flex-row">
                    <span class="label-7">Placeholder</span>
                    <input type="password" class="field-8" name="newStaffConfirmPassword">
                </div>
                <button class="secondary-button">
                    <div class="group-9"><span class="button">Button</span></div>
                </button>
            </div>
        </form>
    </body>
</html>
