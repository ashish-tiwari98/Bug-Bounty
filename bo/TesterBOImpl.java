package com.bts.bo;

public class TesterBOImpl implements TesterBO{

	@Override
	public String[] displayTesterInformation(int userId) {
		TesterDAO tdao = new TesterDAOImpl();
		String[] res = tdao.displayTesterInformation(userId);
		return res;
	}

	@Override
	public String displayAssignedProjectStatus(int userId) {
		TesterDAO tdao = new TesterDAOImpl();
		String ans = tdao.displayAssignedProjectStatus(userId);
		return ans;
	}

	@Override
	public List<ProjectDetails> displayAllAssignedProjects(int userId) {
		TesterDAO tdao = new TesterDAOImpl();
		List<ProjectDetails> projects = new ArrayList<>();
		projects = tdao.displayAllAssignedProjects(userId);
		return projects;
	}

	@Override
	public List<BugDetails> displayAllBugs(int projectId, int userId) {
		TesterDAO tdao = new TesterDAOImpl();
		List<BugDetails> bugs = new ArrayList<>();
		bugs = tdao.displayAllBugs();
		return bugs;
	}

	@Override
	public String insertBugs(int userId, int projectId, String title, String description, String severityLevel)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		TesterDAO tdao = new TesterDAOImpl();
		String res = tdao.insertBugs(userId,projectId,title,description,severityLevel);
		return res;
	}

}
