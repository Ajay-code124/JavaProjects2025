<%@ page import="java.util.List, com.model.Complaint" %>

<%
    List<Complaint> complaints = (List<Complaint>) request.getAttribute("complaints");
%>

<table border="1">
<tr>
   <th>ID</th><th>User Email</th><th>Title</th><th>Description</th><th>Status</th><th>Action</th>
</tr>

<% if (complaints != null && !complaints.isEmpty()) { 
       for (Complaint c : complaints) { %>
    <tr>
       <td><%= c.getId() %></td>
       <td><%= c.getUserEmail() %></td>
       <td><%= c.getTitle() %></td>
       <td><%= c.getDescription() %></td>
       <td><%= c.getStatus() %></td>
       <td>
          <form action="updateStatus" method="post">
              <input type="hidden" name="id" value="<%= c.getId() %>">
              <select name="status">
                 <option <%= "Pending".equals(c.getStatus()) ? "selected" : "" %>>Pending</option>
                 <option <%= "In Progress".equals(c.getStatus()) ? "selected" : "" %>>In Progress</option>
                 <option <%= "Resolved".equals(c.getStatus()) ? "selected" : "" %>>Resolved</option>
              </select>
              <button type="submit">Update</button>
          </form>
          
          <!-- Delete Complaint -->
          <form action="deleteComplaint" method="get" style="display:inline;" 
                onsubmit="return confirm('Are you sure you want to delete this complaint?');">
              <input type="hidden" name="id" value="<%= c.getId() %>">
              <button type="submit">Delete</button>
          </form>
       </td>
    </tr>
<% } } else { %>
    <tr><td colspan="6">No complaints found</td></tr>
<% } %>
</table>

<p>To go back <a href="AdminLogin.jsp">Login Page</a>