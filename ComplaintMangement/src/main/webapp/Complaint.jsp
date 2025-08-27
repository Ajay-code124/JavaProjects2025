<%@ page import="com.model.User" %>
<%
    // Check session
    String userEmail = (String) session.getAttribute("email");
    if (userEmail == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Raise Complaint</title>
</head>
<body>
    <h2>Welcome, <%= userEmail %></h2>

    <h3>Raise Complaint</h3>
    <form action="complaint" method="post">
        Title: <input type="text" name="title" required><br><br>
        Description: <textarea name="description"></textarea><br><br>
        <button type="submit">Submit</button>
    </form>

    <br>
    <a href="home.jsp">Home Page</a><br><br>
  <p>BackToLogin <a href="index.html">Loginpage</a>
</body>
</html>