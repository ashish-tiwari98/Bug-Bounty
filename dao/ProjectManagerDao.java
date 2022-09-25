package com.bts.dao;

import java.util.List;

import com.bts.model.BugDetails;
import com.bts.model.Project;
import com.bts.model.ProjectDetails;

public interface ProjectManagerDao {
	
	public String[] displayManagerInformation(int userId);
	public List<ProjectDetails> displayAllAssignedProjects(int userId);
	public List<BugDetails> displayCriticalBugs(int projectId);
	public List<BugDetails> displayMajorBugs(int projectId);
	public List<BugDetails> displayMinorBugs(int projectId);
	public List<BugDetails> displayTrivialBugs(int projectId);
	public String closeBug(int userId,int bugId);
	public List<UserDetails> displayAllDeveloperForProject(int projectId);
	public String assignBugToDeveloper(int userId,int bugId);
	public List<Project> displayProjectDetails(int projectId);
	

}
