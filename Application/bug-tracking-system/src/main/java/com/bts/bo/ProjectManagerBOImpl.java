package com.bts.bo;

import java.util.List;

import com.bts.model.ProjectDetails;

public class ProjectManagerBOImpl implements ProjectManagerBO{

	@Override
	public String[] displayManagerInformation(int userId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		String[] res =pmdao.displayManagerInformation(userId);
		return res;
	}

	@Override
	public List<ProjectDetails> displayAllAssignedProjects(int userId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		List<ProjectDetails> pd = new ArrayList<>();
		pd=pmdao.displayAllAssignedProjects(userId);
		
		return pd;
	}

	@Override
	public List<BugDetails> displayCriticalBugs(int projectId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		List<BugDetails> bd = new ArrayList<>();
		bd=pmdao.displayCriticalBugs(projectId);
		return bd;
	}

	@Override
	public List<BugDetails> displayMajorBugs(int projectId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		List<BugDetails> majorBugs = new ArrayList<>();
		majorBugs = pmdao.displayMajorBugs(projectId);
		return majorBugs;
	}

	@Override
	public List<BugDetails> displayMinorBugs(int projectId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		List<BugDetails> minorBugs = new ArrayList<>();
		minorBugs=pmdao.displayMinorBugs(projectId);
		return minorBugs;
	}

	@Override
	public List<BugDetails> displayTrivialBugs(int projectId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		List<BugDetails> trivialBugs = new ArrayList<>();
		trivialBugs = pmdao.displayTrivialBugs(projectId);
		return trivialBugs;
	}

	@Override
	public String closeBug(int userId, int bugId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		String response = pmdao.closeBug(userId,bugId);
		return response;
	}

	@Override
	public List<UserDetails> displayAllDeveloperForProject(int projectId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		List<UserDetails> ud = new ArrayList<>();
		ud=pmdao.displayAllDeveloperForProject(projectId);
		return ud;
	}

	@Override
	public String assignBugToDeveloper(int userId, int bugId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		String res = pmdao.assignBugToDeveloper(userId,bugId);
		return res;
	}

	@Override
	public List<Project> displayProjectDetails(int projectId) {
		ProjectManagerDAO pmdao = new ProjectManagerDAOImpl();
		List<Project> pdetails = new ArrayList<>();
		pdetails = pmdao.displayProjectDetails(projectId);
		return pdetails;
	}

}
