


<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f6f8;
	margin: 0;
	padding: 20px;
}

.dashboard {
	max-width: 600px;
	margin: auto;
	background: white;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0px 0px 12px rgba(0, 0, 0, 0.1);
}

h2 {
	margin-top: 0;
	color: #333;
}

.info {
	margin-bottom: 15px;
}

.info label {
	font-weight: bold;
	display: block;
	margin-bottom: 5px;
}

.info input {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.notice {
	background-color: #e0ffe0;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #90ee90;
	border-radius: 5px;
	color: #2d7a2d;
}

.links {
	margin-top: 20px;
}

.links a {
	margin-right: 15px;
	text-decoration: none;
	color: #0077cc;
}

.links a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="dashboard">
		<h2>Welcome Guest</h2>
		<p>Please log in or register to continue.</p>
		<div class="links">
			<a href="login.jsp">Login</a> <a href="register.jsp">Register</a>
		</div>

		<%
    String message = (String) request.getAttribute("message");
    if (message == null) {
        HttpSession sess = request.getSession(false);
        if (sess != null) {
            message = (String) sess.getAttribute("message");
            if (message != null) {
                request.setAttribute("message", message);
                sess.removeAttribute("message");
            }
        }
    }

    String error = (String) request.getAttribute("error");
%>

		<% if (message != null) { %>
		<div
			style="background-color: #d4edda; color: #155724; padding: 15px; margin-bottom: 20px; border-left: 5px solid #28a745; border-radius: 5px;">
			<%= message %>
		</div>
		<% } else if (error != null) { %>
		<div
			style="background-color: #f8d7da; color: #721c24; padding: 15px; margin-bottom: 20px; border-left: 5px solid #dc3545; border-radius: 5px;">
			<%= error %>
		</div>
		<% } %>

	</div>
</body>
</html>
