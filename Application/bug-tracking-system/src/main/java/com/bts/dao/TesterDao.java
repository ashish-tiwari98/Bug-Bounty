package com.bts.dao;

import java.util.List;

import com.bts.model.BugDetails;
import com.bts.model.Bugs;
import com.bts.model.Project;
import com.bts.model.ProjectDetails;

public interface TesterDao {
	public String[] displayTesterInformation(int userId);
	public String displayAssignedProjectStatus(int userId);
	public List<ProjectDetails> displayAllAssignedProjects(int userId);
	public List<BugDetails> displayAllBugs(int projectId,int userId);
	public String insertBugs(int userId, int projectId, String title, String description, String severityLevel) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
}
