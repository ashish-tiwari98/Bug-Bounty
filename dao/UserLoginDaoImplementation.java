package com.bts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class UserLoginDaoImplementation implements UserLoginDao{

	@Override
	public String userLogin(String userEmail, String userPass) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String loginQuery = "select count(userId),userId from users where usersEmail=? and userPass=?";
		String loginUpdate = "update users set loginStatus=? and lastLogin=? where userId = ? ";
		String message = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(loginQuery);
			pstmt.setString(1, userEmail);
			pstmt.setString(2, userPass);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				int userCount = rs.getInt(1);
				int usrId = rs.getInt(2);
				if(userCount==0) {
					message="Incorrect user Email or Password";
				}
				else {
					try {
						java.util.Date dt=new java.util.Date();
						java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String currentTime = sdf.format(dt);
						pstmt1 = connect.prepareStatement(loginUpdate);
						pstmt1.setString(1,"login");
						pstmt1.setString(2, currentTime);
						
						int count = pstmt1.executeUpdate();
						if(count == 1){
							message = "You are logged into system";
						}
						
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
	}
	
//	select count(userId,userId from users where usersEmail=? and userPass=?)
//	update users set loginStatus=? and lastLogin=? whwre userId =?

}
