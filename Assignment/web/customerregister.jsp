<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title> Register for SmartLearn </title>
  <link rel="stylesheet" href="customerregister.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
  <div class="container">
    <div class="title">Registration</div>
    <form method="POST" action="CustomerRegister">
      <div class="user-details">
        <div class="input-box">
          <span class="details">Full Name</span>
          <input type="text" placeholder="Enter your name" name="fullName" required>
        </div>
        <div class="input-box">
          <span class="details">Date of Birth</span>
          <input type="date" placeholder="Enter your date of birth" name="dob" required>
        </div>
        <div class="input-box">
          <span class="details">Address</span>
          <input type="text" placeholder="Enter your address" name="address" required>
        </div>
        <div class="input-box">
          <span class="details">Email</span>
          <input type="email" placeholder="Enter your email" name="email" required>
        </div>
        <div class="input-box">
          <span class="details">Phone Number</span>
          <input type="tel" placeholder="Enter your phone number" name="phoneNumber" required>
        </div>
        <div class="input-box">
          <span class="details">Username</span>
          <input type="text" placeholder="Enter your username" name="username" required>
        </div>
        <div class="input-box">
          <span class="details">Password</span>
          <input type="password" placeholder="Enter your password" name="password" required>
        </div>
        <div class="input-box">
          <span class="details">Confirm Password</span>
          <input type="password" placeholder="Confirm password" name="confirmPassword" required>
        </div>
        <div class="input-box">
          <span class="details">IC Number</span>
          <input type="text" placeholder="Enter your IC number" name="icNumber" required>
        </div>
        <div class="input-box">
          <span class="details">City</span>
          <input type="text" placeholder="Enter your city" name="city" required>
        </div>
        <div class="input-box">
          <span class="details">Postcode</span>
          <input type="text" placeholder="Enter your postcode" name="postcode" required>
        </div>
      </div>
      <div class="button">
        <input type="submit" value="Register">
      </div>
    </form>
  </div>
</body>

</html>
