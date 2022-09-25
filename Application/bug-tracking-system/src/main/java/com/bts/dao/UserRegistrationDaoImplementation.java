package com.bts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegistrationDaoImplementation implements UserRegistrationDao{

	@Override
	public String userRegister(String userEmail, String userRole, String password) throws ClassNotFoundException {
		//connect to db fire select query get resultset 
		//connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bts","root","gracy25");
				
				String url="jdbc:mysql:C:/ProgramData/MySQL/MySQL Server 8.0/Data/bts";
				Connection connect=null;
				PreparedStatement pstmt=null, pstmt1 = null, pstmt2=null;
				String selectQuery = "Select count(userId), userId from users where usersEmail=? and usersRole = ?";
				String selectPassQuery="select userPass from users where userId=?";
				String passQuery="update users set userPass=? where userId=?";
				String message = null;
				
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					connect = DriverManager.getConnection(url,"root","gracy25");
					pstmt = connect.prepareStatement(selectQuery);
					pstmt.setString(1, userEmail);
					pstmt.setString(2, userRole);
					ResultSet rs= pstmt.executeQuery();
					
				
					while(rs.next()) {
						int userCount = rs.getInt(1);
						int usrId = rs.getInt(2);
						if(userCount == 0) {
							message = "The user does not exist";
						}else {
							try {
								pstmt1 = connect.prepareStatement(selectPassQuery);
								pstmt1.setInt(1, usrId);
								ResultSet rs1= pstmt.executeQuery();
								
								while(rs.next()) {
									String pass = rs.getString(1);
									if(pass==null) {
										message="User already registered";
									}
									else {
										try {
											pstmt2 = connect.prepareStatement(passQuery);
											pstmt2.setString(1, password);
											pstmt2.setInt(2, usrId);
											int res= pstmt2.executeUpdate();
											if(res==0) {
												message="Registration failed";
											}
											else {
												message="Registration successful";
											}
										}catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}
							}
							catch (SQLException e) {
								// TODO Auto-generated catch block
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
				}
				return message;
		
	}

}
