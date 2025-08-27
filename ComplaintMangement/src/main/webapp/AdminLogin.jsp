<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Admin Login</title></head>
<body>
<h2>Admin Login</h2>
<form action="adminlogin" method="post">
    <input type="hidden" name="role" value="admin">
    Email: <input type="email" name="email" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">

</form>
</body>
</html>