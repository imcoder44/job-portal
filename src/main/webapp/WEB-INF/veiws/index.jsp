<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Job Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }
        .container {
            background: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 600px;
            text-align: center;
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        p {
            margin-bottom: 20px;
            color: #555;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #5cb85c;
            border: none;
            border-radius: 4px;
            color: white;
            font-size: 16px;
            text-decoration: none;
        }
        .button:hover {
            background-color: #4cae4c;
        }
        .footer {
            margin-top: 20px;
            color: #777;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to the Job Portal</h1>
    <p>Explore career opportunities, apply for jobs, and connect with employers.</p>

    <a href="/login" class="button">Login</a>
    <br><br>
    <a href="/register" class="button">Register</a>

    <div class="footer">
        <p>&copy; 2025 Job Portal. All Rights Reserved.</p>
    </div>
</div>
</body>
</html>
