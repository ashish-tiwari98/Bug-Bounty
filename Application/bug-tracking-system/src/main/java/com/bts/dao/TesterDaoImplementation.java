package com.bts.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bts.model.BugDetails;
import com.bts.model.Bugs;
import com.bts.model.Project;
import com.bts.model.ProjectDetails;

public class TesterDaoImplementation implements TesterDao {

	@Override
	public String[] displayTesterInformation(int userId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String testerSelectQuery = "select userName,usersEmail from users where userId=?";
		String[] ans = new String[2];
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(testerSelectQuery);
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
	public String displayAssignedProjectStatus(int userId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String testerStatusQuery = "select assignedProject from users where userId=?";
		String message = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(testerStatusQuery);
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
	public List<ProjectDetails> displayAllAssignedProjects(int userId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String displayTesterProjectQuery = "select projectId,projectName from project where projectId in(select projectId from teams where userId=?)";
		List<ProjectDetails> result = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(displayTesterProjectQuery);
			pstmt.setInt(1, userId);
			ResultSet rs= pstmt.executeQuery();
			
			
			while(rs.next()) {
				ProjectDetails p = new ProjectDetails();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				
				result.add(p);
				
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
	public List<BugDetails> displayAllBugs(int projectId, int userId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String displayTesterProjectQuery = "select bugId, bugName from bugs where projectId ? and createdBy = ?";
		List<BugDetails> result = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(displayTesterProjectQuery);
			pstmt.setInt(1, projectId);
			pstmt.setInt(2, userId);
			ResultSet rs= pstmt.executeQuery();
			
			
			while(rs.next()) {
				BugDetails b = new BugDetails();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				
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
	public String insertBugs(int userId, int projectId, String title, String description, String level) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String testerSelectQuery = "Select count(projectId) from project where status = 'inprogress' and projectId in (select projectId from teams where userId = ? and projectId = ?) ";
		String testerInsertQuery = "insert into bugs (projectId, title , description, level, createdBy, createdon) values ?,?,?,?,?,?";
		String message = null;

//		return message;
		
				
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bts","root","Gracy@15");
			pstmt1 = connect.prepareStatement(testerSelectQuery);
			pstmt1.setInt(1, userId);
			pstmt1.setInt(2, projectId);
			ResultSet rs= pstmt1.executeQuery();
			
		
			while(rs.next()) {
				int count = rs.getInt(1);
				if(count == 0) {
					message = "The user cannot add bug";
				}else {
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						connect = DriverManager.getConnection(url,"root","gracy25");
						pstmt = connect.prepareStatement(testerInsertQuery);
						pstmt.setInt(1, projectId);
						pstmt.setString(2, title);
						pstmt.setString(3, description);
						pstmt.setString(4, level);
						pstmt.setInt(5,userId);
						java.util.Date dt=new java.util.Date();
						java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String currentTime = sdf.format(dt);
						pstmt.setString(6,currentTime);
						int count1= pstmt.executeUpdate();
						
						if(count1==0) {
							message="Cannot add new bug";
						}
						else {
							message = "bug added successfully";
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		catch (SQLException e) {
						
			e.printStackTrace();
		}
		
		return message;
					
	}

}
