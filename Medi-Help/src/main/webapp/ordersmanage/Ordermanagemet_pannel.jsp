
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Management Panel</title>
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
        .filters {
            display: flex;
            gap: 15px;
            margin-bottom: 20px;
        }
        .filters select, .filters input {
            padding: 12px;
            border: 1px solid #4a90e2;
            border-radius: 6px;
            background: #fff;
            font-size: 16px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: #f9fcff;
            border: 1px solid #d1e7ff;
            border-radius: 6px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #d1e7ff;
        }
        th {
            background: linear-gradient(45deg, #4a90e2, #50c4b7);
            color: white;
            font-weight: 600;
        }
        tr:hover {
            background: #e6f0fa;
        }
        .btn {
            padding: 8px 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 14px;
        }
        .btn-edit {
            background: #f57c00;
            color: white;
        }
        .btn-delete {
            background: #d32f2f;
            color: white;
        }
        .btn:hover {
            opacity: 0.9;
            transform: translateY(-1px);
        }
        .bulk-actions {
            margin-top: 15px;
        }
        .bulk-actions .btn {
            background: #d32f2f;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="filters">
        <select>
            <option>All Status</option>
            <option>Pending</option>
            <option>Delivered</option>
            <option>Cancelled</option>
        </select>
        <input type="date" placeholder="Start Date">
        <input type="date" placeholder="End Date">
        <input type="text" placeholder="Customer Name">
    </div>
    <table>
        <tr>
            <th>Order ID</th>
            <th>Customer</th>
            <th>Total</th>
            <th>Status</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <tr>
            <td>12345</td>
            <td>John</td>
            <td>$55</td>
            <td>Pending</td>
            <td><button class="btn btn-edit">Edit</button></td>
            <td><button class="btn btn-delete">Delete</button></td>
        </tr>
        <tr>
            <td>12346</td>
            <td>Sarah</td>
            <td>$30</td>
            <td>Delivered</td>
            <td>-</td>
            <td><button class="btn btn-delete">Delete</button></td>
        </tr>
    </table>
    <div class="bulk-actions">
        <button class="btn">Delete All Cancelled Orders</button>
    </div>
</div>
</body>
</html>
