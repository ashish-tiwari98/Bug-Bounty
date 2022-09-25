package com.bts.bo;

import java.util.List;

public class DeveloperBOImpl implements DeveloperBO{

	@Override
	public String[] displayDeveloperInformation(int userId) {
		DeveloperDAO ddao = new DeveloperDAOImpl();
		String[] res = ddao.displayDeveloperInformation(userId);
		return res;
	}

	@Override
	public String displayAssignedProjectStatusDeveloper(int userId) {
		DeveloperDAO ddao = new DeveloperDAOImpl();
		String res = ddao.displayAssignedProjectStatusDeveloper(userId);
		return res;
	}

	@Override
	public List<Bugs> displayAllBugsAssigned(int userId) {
		DeveloperDAO ddao = new DeveloperDAOImpl();
		List<Bugs> bugs = new ArrayList<>();
		bugs=ddao.displayAllBugsAssigned(userId);
		return bugs;
	}

	@Override
	public String closeBug(int userId, int bugId) {
		DeveloperDAO ddao = new DeveloperDAOImpl();
		String res=ddao.closeBug(userId,bugId);
		return res;
	}

}
