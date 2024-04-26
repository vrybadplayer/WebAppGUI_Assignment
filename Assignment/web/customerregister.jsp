<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Register for SmartLearn</title>
    <link rel="stylesheet" href="customerregister.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <div class="container">
        <div class="title">Registration</div>
        <form method="POST" action="CustomerRegister">
            <div class="user-details">
                <!-- Full Name -->
                <div class="input-box">
                    <span class="details">Full Name</span>
                    <input id="fullName" type="text" placeholder="Enter your name" name="fullName">
                </div>

                <!-- Date of Birth -->
                <div class="input-box">
                    <span class="details">Date of Birth</span>
                    <input id="dob" type="date" placeholder="Enter your date of birth" name="dob">
                </div>

                <!-- Address -->
                <div class="input-box">
                    <span class="details">Address</span>
                    <input id="address" type="text" placeholder="Enter your address" name="address">
                </div>

                <!-- Email -->
                <div class="input-box">
                    <span class="details">Email</span>
                    <input id="email" type="email" placeholder="Enter your email" name="email">
                </div>

                <!-- Phone Number -->
                <div class="input-box">
                    <span class="details">Phone Number</span>
                    <input id="phoneNumber" type="tel" placeholder="Enter your phone number" name="phoneNumber">
                </div>

                <!-- Username -->
                <div class="input-box">
                    <span class="details">Username</span>
                    <input id="username" type="text" placeholder="Enter your username" name="username">
                </div>

                <!-- Password -->
                <div class="input-box">
                    <span class="details">Password</span>
                    <input id="password" type="password" placeholder="Enter your password" name="password">
                </div>

                <!-- Confirm Password -->
                <div class="input-box">
                    <span class="details">Confirm Password</span>
                    <input id="confirmPassword" type="password" placeholder="Confirm password" name="confirmPassword">
                </div>

                <!-- IC Number -->
                <div class="input-box">
                    <span class="details">IC Number</span>
                    <input id="icNumber" type="text" placeholder="Enter your IC number" name="icNumber">
                </div>

                <!-- City -->
                <div class="input-box">
                    <span class="details">City</span>
                    <input id="city" type="text" placeholder="Enter your city" name="city">
                </div>

                <!-- Postcode -->
                <div class="input-box">
                    <span class="details">Postcode</span>
                    <input id="postcode" type="text" placeholder="Enter your postcode" name="postcode">
                </div>
            </div>
            <div class="button">
                <input type="submit" value="Register">
            </div>
        </form>
    </div>
</body>

</html>
