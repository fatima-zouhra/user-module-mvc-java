<%@ include file="checkLogin.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #eef2f5;
            margin: 0;
            padding: 20px;
        }
        .dashboard-container {
            max-width: 800px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .info-group {
            margin-bottom: 20px;
        }
        .info-label {
            font-weight: bold;
            color: #555;
        }
        .info-value {
            margin-left: 10px;
            color: #222;
        }
        .action-links {
            margin-top: 30px;
            text-align: center;
        }
        .action-links a {
            text-decoration: none;
            color: #007bff;
            margin: 0 10px;
        }
        .action-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h1>Welcome, <%= user.getFirstName() %>!</h1>
        
        <div class="info-group"><span class="info-label">Full Name:</span><span class="info-value"><%= user.getFirstName() + " " + user.getLastName() %></span></div>
        <div class="info-group"><span class="info-label">Email:</span><span class="info-value"><%= user.getEmail() %></span></div>
        <div class="info-group"><span class="info-label">Country:</span><span class="info-value"><%= user.getCountry() %></span></div>
        <div class="info-group"><span class="info-label">Job Title:</span><span class="info-value"><%= user.getJobTitle() %></span></div>
        <div class="info-group"><span class="info-label">Work Phone:</span><span class="info-value"><%= user.getWorkPhone() %></span></div>
        <div class="info-group"><span class="info-label">Company:</span><span class="info-value"><%= user.getCompanyName() %></span></div>
        <div class="info-group"><span class="info-label">Address:</span><span class="info-value"><%= user.getAddress() %></span></div>
        <div class="info-group"><span class="info-label">City:</span><span class="info-value"><%= user.getCity() %></span></div>
        <div class="info-group"><span class="info-label">ZIP Code:</span><span class="info-value"><%= user.getZip() %></span></div>

        <div class="action-links">
            <a href="profile.jsp">Edit Profile</a>
            |
            <a href="logout.jsp">Log out</a>
        </div>
    </div>
</body>
</html>
