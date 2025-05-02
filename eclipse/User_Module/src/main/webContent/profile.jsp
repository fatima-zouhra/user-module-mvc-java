<%@ include file="checkLogin.jspf"%>

<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>User Profile</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f9fa;
	margin: 0;
	padding: 20px;
}

.profile-container {
	max-width: 800px;
	margin: auto;
	background: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #333;
}

.success-message, .error-message {
	padding: 10px;
	margin-bottom: 20px;
	border-radius: 5px;
}

.success-message {
	background-color: #d4edda;
	color: #155724;
	border-left: 5px solid #28a745;
}

.error-message {
	background-color: #f8d7da;
	color: #721c24;
	border-left: 5px solid #dc3545;
}

form div {
	margin-bottom: 15px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

input[type="text"], input[type="email"], input[type="tel"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 16px;
}

button {
	background-color: #007bff;
	color: white;
	padding: 10px 16px;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	font-size: 16px;
	width: 100%;
}

button:hover {
	background-color: #0056b3;
}

.action-links {
	margin-top: 20px;
	text-align: center;
}

.action-links a {
	color: #007bff;
	text-decoration: none;
}

.action-links a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="profile-container">
		<h1>User Profile</h1>

		<% if (request.getAttribute("message") != null) { %>
		<div class="success-message">
			<%= request.getAttribute("message") %>
		</div>
		<% } %>

		<% if (request.getAttribute("error") != null) { %>
		<div class="error-message">
			<%= request.getAttribute("error") %>
		</div>
		<% } %>

		<form action="profile" method="post">
			<div>
				<label>First Name:</label> <input type="text" name="firstName"
					value="<%= user.getFirstName() %>" required>
			</div>

			<div>
				<label>Last Name:</label> <input type="text" name="lastName"
					value="<%= user.getLastName() %>" required>
			</div>

			<div>
				<label>Email:</label> <input type="email" name="email"
					value="<%= user.getEmail() %>" readonly>
			</div>

			<div>
				<label>Country:</label> <input type="text" name="country"
					value="<%= user.getCountry() %>">
			</div>

			<div>
				<label>Job Title:</label> <input type="text" name="jobTitle"
					value="<%= user.getJobTitle() %>">
			</div>

			<div>
				<label>Work Phone:</label> <input type="tel" name="workPhone"
					value="<%= user.getWorkPhone() %>">
			</div>

			<div>
				<label>Company Name:</label> <input type="text" name="companyName"
					value="<%= user.getCompanyName() %>">
			</div>

			<div>
				<label>Address:</label> <input type="text" name="address"
					value="<%= user.getAddress() %>">
			</div>

			<div>
				<label>City:</label> <input type="text" name="city"
					value="<%= user.getCity() %>">
			</div>

			<div>
				<label>ZIP Code:</label> <input type="text" name="zip"
					value="<%= user.getZip() %>">
			</div>

			<div>
				<button type="submit">Update Profile</button>
			</div>
		</form>

		<div class="action-links">
			<p>
				<a href="dashboard.jsp">Dashboard</a>
			</p>
			<p>
				<a href="logout.jsp">Log out</a>
			</p>
		</div>
		<form action="deleteUser" method="post"
			onsubmit="return confirm('Are you sure you want to delete your account? This action cannot be undone.');">
			<button type="submit" style="background-color: #dc3545; color: red;">Delete
				Account</button>
		</form>

	</div>
</body>
</html>
