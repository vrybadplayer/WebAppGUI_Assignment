<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Enter E-Wallet Details</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }

            .container {
                width: 50%;
                margin: 50px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            h2 {
                text-align: center;
                color: #6064b6;
            }

            form {
                max-width: 400px;
                margin: 0 auto;
            }

            label {
                display: block;
                margin-bottom: 8px;
                color: #333;
            }

            input[type="text"],
            input[type="password"],
            input[type="email"],
            input[type="tel"],
            select {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            input[type="submit"] {
                background-color: #6064b6;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s;
            }

            input[type="submit"]:hover {
                background-color: #4c5099;
            }

            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }

            .container {
                width: 50%;
                margin: 50px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            .title {
                text-align: center;
            }

            .ewallet-types {
                display: flex;
                justify-content: space-around;
                margin-bottom: 20px;
            }

            .ewallet-type img {
                width: 100px;
                height: 100px;
                margin-bottom: 10px;
                display: block;
                margin: 0 auto;
            }

            hr {
                border: 0;
                border-top: 2px solid #6064b6;
                margin: 20px auto;
            }

            h2 {
                text-align: center;
                color: #6064b6;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <div class="title">
                <h2>Accepted E-Wallet Types: </h2>
            </div>
            <div class="ewallet-types">
                <div class="ewallet-type">
                    <img src="tng.png" alt="TNG eWallet">
                </div>
                <div class="ewallet-type">
                    <img src="sPay.png" alt="Shopee Pay">
                </div>
                <div class="ewallet-type">
                    <img src="lazadawallet.png" alt="Lazada Wallet">
                </div>
                <div class="ewallet-type">
                    <img src="grabpay.png" alt="GrabPay">
                </div>
            </div>
            <hr>
            <div class="container">
                <h2>Enter E-Wallet Details</h2>
                <form action="ewalletServlet" method="post">
                    <label for="ewalletType">Select E-Wallet Type:</label>
                    <select name="ewalletType" id="ewalletType">
                        <option value="TNG eWallet">TNG eWallet</option>
                        <option value="Shopee Pay">Shopee Pay</option>
                        <option value="Lazada Wallet">Lazada Wallet</option>
                        <option value="GrabPay">GrabPay</option>
                    </select><br><br>
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username"><br><br>
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email"><br><br>
                    <label for="phoneNumber">Phone Number:</label>
                    <input type="tel" id="phoneNumber" name="phoneNumber"><br><br>
                    <input type="submit" value="Submit">
                </form>
            </div>
    </body>
</html>
