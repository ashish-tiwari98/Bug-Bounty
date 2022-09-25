package com.bts.bo;

public interface TesterBO {
	public String[] displayTesterInformation(int userId);
	public String displayAssignedProjectStatus(int userId);
	public List<ProjectDetails> displayAllAssignedProjects(int userId);
	public List<BugDetails> displayAllBugs(int projectId,int userId);
	public String insertBugs(int userId, int projectId, String title, String description, String severityLevel) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
}
