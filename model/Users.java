package com.bts.model;

public class Users {
	private int userId;
	private String userName;
	private String userEmail;
	private String userRole;
	private String userPass;
	private String loginStatus;
	private String lastLogin;
	private int assignedProject;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public int getAssignedProject() {
		return assignedProject;
	}
	public void setAssignedProject(int assignedProject) {
		this.assignedProject = assignedProject;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userRole="
				+ userRole + ", userPass=" + userPass + ", loginStatus=" + loginStatus + ", lastLogin=" + lastLogin
				+ ", assignedProject=" + assignedProject + "]";
	}

	
}
