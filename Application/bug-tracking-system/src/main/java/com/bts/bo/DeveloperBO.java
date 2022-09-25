package com.bts.bo;

public interface DeveloperBO {
	public String[] displayDeveloperInformation(int userId);
	public String displayAssignedProjectStatusDeveloper(int userId);
	public List<Bugs> displayAllBugsAssigned(int userId);
	public String closeBug(int userId, int bugId);
}
