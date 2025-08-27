<%@ page import="java.util.List" %>
<%@ page import="com.model.Complaint" %>

<!DOCTYPE html>
<html>
<head>
    <title>My Complaints</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #333;
            padding: 8px;
            text-align: center;
        }
        th {
            background: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2 style="text-align:center;">My Complaints</h2>

    <table>
        <tr>
             <th>Email</th>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
        </tr>
        <%
            List<Complaint> complaints = (List<Complaint>) request.getAttribute("complaints");
            if (complaints != null && !complaints.isEmpty()) {
                for (Complaint c : complaints) {
        %>
        <tr>
            <td><%=c.getUserEmail() %>
            <td><%= c.getTitle() %></td>
            <td><%= c.getDescription() %></td>
            <td><%= c.getStatus() %></td>
            
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No complaints found</td>
        </tr>
        <% } %>
    </table>
    <p>BackToLogin <a href="index.html">Loginpage</a>
    <p>BackToHomePage <a href="home.jsp">Homepage</a>
</body>
</html>
