package com.bts.dao;

import java.util.List;

import com.bts.model.BugDetails;
import com.bts.model.Bugs;

public interface DeveloperDao {

	public String[] displayDeveloperInformation(int userId);
	public String displayAssignedProjectStatusDeveloper(int userId);
	public List<Bugs> displayAllBugsAssigned(int userId);
	public String closeBug(int userId, int bugId);
}
