package com.bts.bo;

import com.bts.dao.BugTrackingDAOImpl;
import com.bts.model.User;
import com.bts.dao.BugTrackingDAO;
public class BugTrackingBOImpl implements BugTrackingBO{

	@Override
	public String[] showLoginStatus(String email, String password) {
		BugTrackingDAO bdao= (BugTrackingDAO) new BugTrackingDAOImpl();
		bdao.showLoginStatus(email, password);
		return null;
	}

	@Override
	public void importUsers(User user) {
		BugTrackingDAO bdao = (BugTrackingDAO) new BugTrackingDAOImpl();
		bdao.importUsers(user);
	}

	@Override
	public String createPassword(String password) {
		BugTrackingDAO bdao = (BugTrackingDAO) new BugTrackingDAOImpl();
		String status =  bdao.createPassword(password);
		return status;
	}
}
