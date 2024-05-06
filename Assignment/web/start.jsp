<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial;
}

.split {
  height: 100%;
  width: 50%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
  transition: background-color 0.3s;
}

.left {
  left: 0;
  background-color: #9C3587;
  cursor: pointer;
}

.right {
  right: 0;
  background-color: #653780;
  cursor: pointer;
}

.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
  color: black;
  transition: transform 0.3s; /* Adding transition for smooth movement */
}

.centered img {
  width: 150px;
  border-radius: 50%;
}

.split:hover .centered {
  transform: translate(-50%, -55%); /* Move text up slightly when hovered */
}

.split:hover {
  background-color: #4CAF50;
}
</style>
</head>
<body>

<a href="customer.html">
  <div class="split left">
    <div class="centered">
      <img src="customer.png" alt="Customer">
      <h2>Customer</h2>
      <p>Click here to select as Customer</p>
    </div>
  </div>
</a>

<a href="staff.html">
  <div class="split right">
    <div class="centered">
      <img src="staff.png" alt="Staff">
      <h2>Manager/Staff</h2>
      <p>Click here to select as Manager/Staff</p>
    </div>
  </div>
</a>
     
</body>
</html>
