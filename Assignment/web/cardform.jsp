<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enter Payment Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Enter Payment Details - Debit/Credit Card</h2>
        <form action="cardServlet" method="post">
            <label for="cardType">Card Type:</label>
            <select name="cardType" id="cardType">
                <option value="visaD">Visa Debit Card</option>
                <option value="visaC">Visa Credit Card</option>
                <option value="masterD">Mastercard Debit Card</option>
                <option value="masterC">Mastercard Credit Card</option>
            </select><br><br>
            <label for="cardNumber">Card Number:</label>
            <input type="text" id="cardNumber" name="cardNumber"><br><br>
            <label for="expirationDate">Expiration Date:</label>
            <input type="text" id="expirationDate" name="expirationDate" placeholder="MM/YY"><br><br>
            <label for="cvv">CVV/Security Code:</label>
            <input type="text" id="cvv" name="cvv"><br><br>
            <label for="cardholderName">Cardholder Name:</label>
            <input type="text" id="cardholderName" name="cardholderName"><br><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
