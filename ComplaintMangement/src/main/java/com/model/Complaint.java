package com.model;

public class Complaint {
    private int id;
    private String userEmail;
    private String title;
    private String description;
    private String status;
	public Complaint(String userEmail, String title, String description) {
		super();
		this.userEmail = userEmail;
		this.title = title;
		this.description = description;
		this.status = "pending";
	}
	
	
	
	





	public Complaint(String userEmail, String title, String description, String status) {
		super();
		this.userEmail = userEmail;
		this.title = title;
		this.description = description;
		this.status = "pending";
	}



	public Complaint(int id, String userEmail, String title, String description, String status) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.title = title;
		this.description = description;
		this.status = status;
	}


	









	public Complaint() {
		// TODO Auto-generated constructor stub
	}









	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Complaint [id=" + id + ", userEmail=" + userEmail + ", title=" + title + ", description=" + description
				+ ", status=" + status + "]";
	}

    
    
}