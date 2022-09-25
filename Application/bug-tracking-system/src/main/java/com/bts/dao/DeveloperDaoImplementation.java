package com.bts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bts.model.Bugs;

public class DeveloperDaoImplementation implements DeveloperDao{

	@Override
	public String[] displayDeveloperInformation(int userId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String developerSelectQuery = "select userName,usersEmail from users where userId=?";
		String[] ans = new String[2];
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(developerSelectQuery);
			pstmt.setInt(1, userId);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				ans[0]=rs.getString(1);
				ans[1]=rs.getString(2);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public String displayAssignedProjectStatusDeveloper(int userId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String developerStatusQuery = "select assignedProject from users where userId=?";
		String message = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(developerStatusQuery);
			pstmt.setInt(1, userId);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				int count = rs.getInt(1);
				
				if(count==0) {
					message="Oops! You are not assigned any project yet";
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}



	@Override
	public List<Bugs> displayAllBugsAssigned(int userId) {
		List<Bugs> result = new ArrayList<Bugs>();
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String developerStatusQuery = "select * from bugs where assignedTo=?";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(developerStatusQuery);
			pstmt.setInt(1, userId);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Bugs b= new Bugs();
				b.setBugId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setDescription(rs.getString(3));
				b.setProjectId(rs.getInt(4));
				b.setCreatedBy(rs.getInt(5));
				b.setOpenDate(rs.getString(6));
				b.setAssignedTo(rs.getInt(7));
				b.setMarkedForClosing(rs.getString(8));
				b.setClosedBy(rs.getInt(9));
				b.setStatus(rs.getString(10));
				b.setLevel(rs.getString(11));
				
				
				result.add(b);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String closeBug(int userId, int bugId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String developerStatusQuery = "update bugs set status='closed' where assignedTo=? and bugId=?";
		String message = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(developerStatusQuery);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, bugId);
			int count= pstmt.executeUpdate();
			
			if(count==0) {
				message="Cannot close the bug";
			}
			else {
				message="Bug closed successfully";
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
