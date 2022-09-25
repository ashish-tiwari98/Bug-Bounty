package com.bts.dao;

public interface UserRegistrationDao {
	
	public String userRegister(String userName, String userRole, String password) throws ClassNotFoundException;

}
