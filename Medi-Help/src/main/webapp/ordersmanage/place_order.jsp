
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Place Order</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: url('https://www.transparenttextures.com/patterns/white-wall.png') #e6f0fa;
            margin: 0;
            padding: 20px;
            color: #333;
        }
        .container {
            display: flex;
            gap: 20px;
            max-width: 1200px;
            margin: auto;
            background: rgba(255, 255, 255, 0.95);
            border-radius: 12px;
            padding: 20px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        .left-panel, .right-panel {
            padding: 20px;
            border-radius: 8px;
            background: #ffffff;
            border: 1px solid #d1e7ff;
        }
        .left-panel {
            flex: 2;
            background: url('https://www.transparenttextures.com/patterns/stardust.png') #f5faff;
        }
        .right-panel {
            flex: 1;
            background: url('https://www.transparenttextures.com/patterns/stardust.png') #f5faff;
        }
        .search-bar {
            width: 100%;
            padding: 12px;
            margin-bottom: 15px;
            border: 1px solid #4a90e2;
            border-radius: 6px;
            background: #fff url('https://img.icons8.com/ios-filled/24/4a90e2/search.png') no-repeat 10px center;
            padding-left: 40px;
            font-size: 16px;
        }
        .medicine-list {
            max-height: 300px;
            overflow-y: auto;
            border: 1px solid #d1e7ff;
            border-radius: 6px;
            padding: 10px;
        }
        .medicine-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 12px;
            border-bottom: 1px solid #e6f0fa;
            background: #f9fcff;
            border-radius: 4px;
            margin-bottom: 5px;
        }
        .medicine-item::before {
            content: url('https://img.icons8.com/color/24/000000/pill.png');
            margin-right: 10px;
        }
        .cart-summary {
            margin-top: 20px;
            padding: 15px;
            background: #e6f0fa;
            border-radius: 6px;
        }
        .address-form, .payment-method {
            margin-top: 20px;
        }
        .address-form input, .payment-method select {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            border: 1px solid #4a90e2;
            border-radius: 6px;
            background: #fff;
            font-size: 16px;
        }
        .btn {
            background: linear-gradient(45deg, #4a90e2, #50c4b7);
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
            transition: all 0.3s;
        }
        .btn:hover {
            background: linear-gradient(45deg, #357abd, #3a9b8e);
            transform: translateY(-1px);
        }
        .total {
            font-size: 1.3em;
            font-weight: bold;
            color: #2c6ca6;
            margin-top: 15px;
        }
        .error, .success {
            padding: 12px;
            margin: 10px 0;
            border-radius: 6px;
            font-size: 14px;
        }
        .error {
            background: #ffe6e6;
            color: #d32f2f;
            border: 1px solid #d32f2f;
        }
        .success {
            background: #e6ffed;
            color: #2e7d32;
            border: 1px solid #2e7d32;
        }
        h3 {
            color: #2c6ca6;
            font-size: 1.5em;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="left-panel">
        <input type="text" class="search-bar" placeholder="Search Medicines...">
        <div class="medicine-list">
            <div class="medicine-item">
                <span>Paracetamol</span>
                <input type="number" min="1" value="1" style="width: 60px; padding: 8px; border-radius: 4px;">
                <button class="btn">Add to Cart</button>
            </div>
            <div class="medicine-item">
                <span>Ibuprofen</span>
                <input type="number" min="1" value="1" style="width: 60px; padding: 8px; border-radius: 4px;">
                <button class="btn">Add to Cart</button>
            </div>
        </div>
        <div class="address-form">
            <input type="text" placeholder="Customer Name">
            <input type="text" placeholder="Contact Number">
            <input type="email" placeholder="Email">
            <input type="text" placeholder="Delivery Address">
        </div>
        <div class="payment-method">
            <select>
                <option>Card</option>
                <option>Cash on Delivery</option>
            </select>
        </div>
    </div>
    <div class="right-panel">
        <div class="cart-summary">
            <h3>Cart Summary</h3>
            <p>Paracetamol x 2 - $10</p>
            <p>Ibuprofen x 1 - $5</p>
            <div class="total">Total: $15</div>
            <button class="btn">Place Order</button>
        </div>
        <div class="success" style="display: none;">Order placed successfully!</div>
        <div class="error" style="display: none;">Please fill all fields.</div>
    </div>
</div>
</body>
</html>
