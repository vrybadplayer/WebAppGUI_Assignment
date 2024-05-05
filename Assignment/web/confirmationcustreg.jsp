<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirm Registration</title>
    <link rel="stylesheet" href="css/confirmationcustreg.css">
</head>
<body>
    <div class="container">
        <h1>Confirm Registration</h1>
        <form action="CustomerConfirmation" method="post">
            <input type="hidden" name="fullName" value="${fullName}">
            <input type="hidden" name="dob" value="${dob}">
            <input type="hidden" name="address" value="${address}">
            <input type="hidden" name="email" value="${email}">
            <input type="hidden" name="phoneNumber" value="${phoneNumber}">
            <input type="hidden" name="username" value="${username}">
            <input type="hidden" name="password" value="${password}">
            <input type="hidden" name="icNumber" value="${icNumber}">
            <input type="hidden" name="city" value="${city}">
            <input type="hidden" name="postcode" value="${postcode}">
            <input type="hidden" name="confirmed" value="true">

            <!-- Display user details for review -->
            <div class="user-details">
                <p>Please review your details:</p>
                <p><span class="label">Full Name:</span> ${fullName}</p>
                <p><span class="label">Date of Birth:</span> ${dob}</p>
                <p><span class="label">Address:</span> ${address}</p>
                <p><span class="label">Email:</span> ${email}</p>
                <p><span class="label">Phone Number:</span> ${phoneNumber}</p>
                <p><span class="label">Username:</span> ${username}</p>
                <p><span class="label">Password:</span> ${password}</p>
                <p><span class="label">IC Number:</span> ${icNumber}</p>
                <p><span class="label">City:</span> ${city}</p>
                <p><span class="label">Postcode:</span> ${postcode}</p>
            </div>

            <!-- Confirm or Cancel registration -->
            <input type="submit" value="Confirm">
            <input type="button" value="Cancel" onclick="window.history.back()">
        </form>
    </div>
</body>
</html>
