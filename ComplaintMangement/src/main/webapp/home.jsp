<%
    String email = (String) session.getAttribute("email");
    if (email == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Home</title>
</head>
<body>
    <h2>Welcome, <%= email %></h2>

   <a href="Complaint.jsp">Raise Complaint</a><br><br>
    <a href="myComplaints">View My Complaints</a><br><br>
   <p>BackToLogin <a href="index.html">Logout</a>
</body>
</html>