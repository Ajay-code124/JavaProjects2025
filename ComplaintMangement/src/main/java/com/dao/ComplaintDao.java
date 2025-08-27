package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Utility.Constant;
import com.Utility.DbConnection;
import com.model.Complaint;

public class ComplaintDao {
    public void saveComplaint(Complaint c) {
        try (Connection con = DbConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(Constant.InsertComp);
            ps.setString(1, c.getUserEmail());
            ps.setString(2, c.getTitle());
            ps.setString(3, c.getDescription());
            ps.setString(4, c.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Complaint> getComplaintsByUser(String email) throws ClassNotFoundException, SQLException {
        List<Complaint> complaints = new ArrayList<>();

        Connection connection = DbConnection.getConnection();
          
            PreparedStatement stmt = connection.prepareStatement(Constant.getComplaint);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Complaint c = new Complaint(
                        rs.getString("user_email"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status")
                );
                complaints.add(c);
            
        } 
        return complaints;
    }

	public static  List<Complaint> getAllComplaints() throws ClassNotFoundException, SQLException {
		
		
		  List<Complaint> list = new ArrayList<>();

	        Connection connection = DbConnection.getConnection();
	          
	            PreparedStatement stmt = connection.prepareStatement(Constant.getAllComplaint);
	            
	            ResultSet rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                Complaint c = new Complaint();
	                		c.setId(rs.getInt("id"));
	                        c.setUserEmail(rs.getString("user_email"));
	                        c.setTitle(rs.getString("title"));
	                        c.setDescription(rs.getString("description"));
	                        c.setStatus(rs.getString("status"));
	                        
	                
	                list.add(c);
	               
	            
	}
	            return list;
	}

	public boolean updateStatus(int id, String status) throws ClassNotFoundException, SQLException {
		 boolean result = false;
	    Connection connection = DbConnection.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(Constant.updateComplaints);
        stmt.setString(1, status);
        stmt.setInt(2, id);
        
        int  rows = stmt.executeUpdate();

        if (rows>0) {
            result = true;
        }
     
    return result;
	}

	public void deleteComplaint(int id) throws ClassNotFoundException, SQLException {
Connection connection = DbConnection.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(Constant.deleteComplaints);
		stmt.setInt(1, id);
        stmt.executeUpdate();
	}
}
