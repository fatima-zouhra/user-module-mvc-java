<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }
        .form-container {
            max-width: 600px;
            margin: auto;
            background: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 0px 15px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .error-message {
            color: #b00020;
            background-color: #ffe5e5;
            padding: 10px;
            border-left: 5px solid #b00020;
            margin-bottom: 20px;
            border-radius: 5px;
        }
        form div {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 6px;
            font-weight: 600;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="tel"] {
            width: 100%;
            padding: 8px 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        button {
            background-color: #0066cc;
            color: white;
            padding: 10px 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #004d99;
        }
        .login-link {
            margin-top: 20px;
            text-align: center;
        }
        .login-link a {
            color: #0066cc;
            text-decoration: none;
        }
        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Create Your Account</h1>

        <% if (request.getAttribute("error") != null) { %>
            <div class="error-message">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

        <form action="register" method="post">
            <div>
                <label>Email Address</label>
                <input type="email" name="email" required>
            </div>

            <div>
                <label>Create Password</label>
                <input type="password" name="password" required>
            </div>

            <div>
                <label>Confirm Password</label>
                <input type="password" name="retypePassword" required>
            </div>

            <div>
                <label>First Name</label>
                <input type="text" name="firstName" required>
            </div>

            <div>
                <label>Last Name</label>
                <input type="text" name="lastName" required>
            </div>

            <div>
                <label>Country</label>
                <input type="text" name="country" required>
            </div>

            <div>
                <label>Job Title</label>
                <input type="text" name="jobTitle" required>
            </div>

            <div>
                <label>Work Phone</label>
                <input type="tel" name="workPhone" required>
            </div>

            <div>
                <label>Company</label>
                <input type="text" name="companyName" required>
            </div>

            <div>
                <label>Street Address</label>
                <input type="text" name="address" required>
            </div>

            <div>
                <label>City</label>
                <input type="text" name="city" required>
            </div>

            <div>
                <label>ZIP Code</label>
                <input type="text" name="zip" required>
            </div>

            <div style="text-align: center;">
                <button type="submit">Register</button>
            </div>
        </form>

        <div class="login-link">
            <p>Already have an account? <a href="login.jsp">Login here</a></p>
        </div>
    </div>
</body>
</html>
