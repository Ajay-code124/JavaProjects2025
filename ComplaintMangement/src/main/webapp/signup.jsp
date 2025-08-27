<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>SignUp</h3>
<form action="signup" method="post">
 <label for="email">Email :</label>
<input type="email" name="email" placeholder="Enter your email"> <br> <br>
<label for="password">Password :</label>
<input type="password" name="password" placeholder="Enter your password"> <br> <br>
<label for="confirm-password">Confirm Password :</label>
<input type="password" name="confirm-password" placeholder="Re-Enter the password"> <br> <br>
<input type="submit" value="Signup">
</form>
   <p class="text-center mt-3">
      Already have an account? 
      <a href="index.html" class="text-decoration-none fw-bold">Login</a>
    </p>
</body>
</html>