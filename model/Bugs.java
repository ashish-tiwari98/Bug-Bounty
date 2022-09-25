package com.bts.model;

public class Bugs {
	private int bugId;
	private String title;
	private String description;
	private int projectId;
	private int createdBy;
	private String openDate;
	private int assignedTo;
	private String markedForClosing;
	private int closedBy;
	private String status;
	private String level;
	public int getBugId() {
		return bugId;
	}
	public void setBugId(int bugId) {
		this.bugId = bugId;
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
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getMarkedForClosing() {
		return markedForClosing;
	}
	public void setMarkedForClosing(String markedForClosing) {
		this.markedForClosing = markedForClosing;
	}
	public int getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(int closedBy) {
		this.closedBy = closedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Bugs [bugId=" + bugId + ", title=" + title + ", description=" + description + ", projectId=" + projectId
				+ ", createdBy=" + createdBy + ", openDate=" + openDate + ", assignedTo=" + assignedTo
				+ ", markedForClosing=" + markedForClosing + ", closedBy=" + closedBy + ", status=" + status
				+ ", level=" + level + "]";
	}
	
	

}
