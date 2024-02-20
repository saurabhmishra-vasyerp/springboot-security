<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Registration Page </title>
</head>
<body>
      <div>
	 <h2>Registration</h2>
    <form action="/public/addUser" method="post">
     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <label>Role:</label>
        <input type="radio" id="roleUser" name="role" value="ROLE_USER" required>
        <label for="roleUser">User</label>

        <input type="radio" id="roleAdmin" name="role" value="ROLE_ADMIN" required>
        <label for="roleAdmin">Admin</label>

        <button type="submit">Sign Up</button>
    </form>
</div>
</body>
</html>