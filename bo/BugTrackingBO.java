package com.bts.bo;

import com.bts.model.User;

public interface BugTrackingBO {
	
	public String[] showLoginStatus(String email,String password);
	public void importUsers(User user);
	public String createPassword(String password);
}
