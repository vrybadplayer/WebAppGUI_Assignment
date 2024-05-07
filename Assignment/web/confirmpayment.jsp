<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirm Payment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        .payment-details {
            margin-bottom: 20px;
        }

        .payment-details p {
            margin: 10px 0;
            font-size: 16px;
            color: #555;
        }

        .confirm-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .confirm-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Confirm Payment</h1>
    <div class="payment-details">
        <p>Total Amount: <%= request.getSession().getAttribute("totalAmount") %></p>
        <p>Discount: <%= request.getSession().getAttribute("discount") %></p>
        <p>Final Amount: <%= request.getSession().getAttribute("finalAmount") %></p>
        <p>Selected Payment Method: <%= request.getSession().getAttribute("paymethod") %></p>
    </div>
    <form action="confirmpayment" method="post">
        <input type="hidden" name="paymentMethod" value="<%= request.getSession().getAttribute("paymethod") %>">
        <input type="submit" class="confirm-btn" value="Confirm Payment">
    </form>
</div>
</body>
</html>
