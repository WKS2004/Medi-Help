<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Order History</title>
  <style>
    body {
      font-family: 'Segoe UI', Arial, sans-serif;
      background: url('https://www.transparenttextures.com/patterns/white-wall.png') #e6f0fa;
      margin: 0;
      padding: 20px;
      color: #333;
    }
    .container {
      max-width: 1200px;
      margin: auto;
      background: rgba(255, 255, 255, 0.95);
      padding: 20px;
      border-radius: 12px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }
    .filter {
      margin-bottom: 20px;
    }
    .filter select {
      padding: 12px;
      border: 1px solid #4a90e2;
      border-radius: 6px;
      background: #fff;
      font-size: 16px;
      width: 200px;
    }
    .order-list {
      display: flex;
      flex-direction: column;
      gap: 10px;
    }
    .order-item {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 15px;
      background: #f9fcff;
      border: 1px solid #d1e7ff;
      border-radius: 6px;
      transition: all 0.2s;
    }
    .order-item:hover {
      background: #e6f0fa;
    }
    .order-item::before {
      content: url('https://img.icons8.com/color/24/000000/order-history.png');
      margin-right: 10px;
    }
    .btn {
      background: linear-gradient(45deg, #4a90e2, #50c4b7);
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      font-size: 14px;
    }
    .btn:hover {
      background: linear-gradient(45deg, #357abd, #3a9b8e);
    }
    .status-delivered { color: #2e7d32; font-weight: bold; }
    .status-pending { color: #f57c00; font-weight: bold; }
    .status-cancelled { color: #d32f2f; font-weight: bold; }
  </style>
</head>
<body>
<div class="container">
  <div class="filter">
    <select>
      <option>All</option>
      <option>Delivered</option>
      <option>Pending</option>
      <option>Cancelled</option>
    </select>
  </div>
  <div class="order-list">
    <div class="order-item">
      <span>Order #12345</span>
      <span>2025-05-01</span>
      <span>$55</span>
      <span class="status-delivered">Delivered</span>
      <button class="btn">View Details</button>
    </div>
    <div class="order-item">
      <span>Order #12346</span>
      <span>2025-05-02</span>
      <span>$30</span>
      <span class="status-pending">Pending</span>
      <button class="btn">View Details</button>
    </div>
  </div>
</div>
</body>
</html>