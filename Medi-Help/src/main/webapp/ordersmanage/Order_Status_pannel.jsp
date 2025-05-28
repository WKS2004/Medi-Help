
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Status Update</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: url('https://www.transparenttextures.com/patterns/white-wall.png') #e6f0fa;
            margin: 0;
            padding: 20px;
            color: #333;
        }
        .container {
            max-width: 800px;
            margin: auto;
            background: rgba(255, 255, 255, 0.95);
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
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
        .order-details {
            margin-bottom: 20px;
            padding: 15px;
            background: #f9fcff;
            border: 1px solid #d1e7ff;
            border-radius: 6px;
        }
        .order-details h3 {
            color: #2c6ca6;
            margin-top: 0;
        }
        .order-details p {
            margin: 8px 0;
        }
        .status-form select {
            padding: 12px;
            width: 100%;
            border: 1px solid #4a90e2;
            border-radius: 6px;
            background: #fff;
            font-size: 16px;
            margin-bottom: 15px;
        }
        .btn {
            background: linear-gradient(45deg, #4a90e2, #50c4b7);
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn:hover {
            background: linear-gradient(45deg, #357abd, #3a9b8e);
        }
    </style>
</head>
<body>
<div class="container">
    <input type="text" class="search-bar" placeholder="Search by Order ID or Customer Name">
    <div class="order-details">
        <h3>Order #12345</h3>
        <p>Customer: John Doe</p>
        <p>Items: Paracetamol x 2, Ibuprofen x 1</p>
        <p>Total: $15</p>
    </div>
    <div class="status-form">
        <select>
            <option>Pending</option>
            <option>Dispatched</option>
            <option>Delivered</option>
            <option>Cancelled</option>
        </select>
        <button class="btn">Update Status</button>
    </div>
</div>
</body>
</html>
