package com.bts.dao;

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

public class ProjectManagerDaoImplementation implements ProjectManagerDao{

	@Override
	public String[] displayManagerInformation(int userId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String pmQuery = "select userName,usersRole,loginStatus,lastLogin from users where userId=?";
		String[] ans = new String[4];
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(pmQuery);
			pstmt.setInt(1, userId);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				ans[0]=rs.getString(1);
				ans[1]=rs.getString(2);
				ans[2]=rs.getString(3);
				ans[3]=rs.getString(4);
				
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
	public List<ProjectDetails> displayAllAssignedProjects(int userId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String displayAssignedQuery = "select projectId,projectName from project where projectId in(select projectId from teams where userId=?)";
		List<ProjectDetails> result = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(displayAssignedQuery);
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
	public List<BugDetails> displayCriticalBugs(int projectId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String displayTesterProjectQuery = "select bugId, bugName from bugs where projectId ? and level = 'critical'";
		List<BugDetails> result = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(displayTesterProjectQuery);
			pstmt.setInt(1, projectId);
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
	public List<BugDetails> displayMajorBugs(int projectId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String displayTesterProjectQuery = "select bugId, bugName from bugs where projectId ? and level = 'major'";
		List<BugDetails> result = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(displayTesterProjectQuery);
			pstmt.setInt(1, projectId);
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
	public List<BugDetails> displayMinorBugs(int projectId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String displayTesterProjectQuery = "select bugId, bugName from bugs where projectId ? and level = 'minor'";
		List<BugDetails> result = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(displayTesterProjectQuery);
			pstmt.setInt(1, projectId);
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
	public List<BugDetails> displayTrivialBugs(int projectId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String displayTesterProjectQuery = "select bugId, bugName from bugs where projectId ? and level = 'trivial'";
		List<BugDetails> result = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(displayTesterProjectQuery);
			pstmt.setInt(1, projectId);
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
	public String closeBug(int userId, int bugId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String developerStatusQuery = "update bugs set closedBy=? and closedOn=? bugId=?";
		String message = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(developerStatusQuery);
			pstmt.setInt(1, userId);
			java.util.Date dt=new java.util.Date();
			java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			pstmt.setString(2, currentTime);
			pstmt.setInt(3, bugId);
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

	@Override
	public List<UserDetails> displayAllDeveloperForProject(int projectId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String displayTesterProjectQuery = "select usersId, usersName from users where usersId in (select usersId from teams where projectId=?)";
		List<UserDetails> result = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(displayTesterProjectQuery);
			pstmt.setInt(1, projectId);
			ResultSet rs= pstmt.executeQuery();
			
			
			while(rs.next()) {
				UserDetails u = new UserDetails();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				
				result.add(u);
				
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
	public String assignBugToDeveloper(int userId, int bugId) {
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null;
		String developerStatusQuery = "update bugs set assignedTo=? where bugId=?";
		String message = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(developerStatusQuery);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, bugId);
			int count= pstmt.executeUpdate();
			
			if(count==0) {
				message="Cannot assign the  bug";
			}
			else {
				message="Bug assigned successfully";
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
	public List<Project> displayProjectDetails(int projectId) {
		List<Project> result = new ArrayList<Project>();
		String url="jdbc:mysql:C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\bts";
		Connection connect=null;
		PreparedStatement pstmt=null, pstmt1 = null;
		String query = "select * from project where projectId=?";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","gracy25");
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, projectId);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Project p= new Project();
				p.setProjectId(rs.getInt(1));
				p.setProjectName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setStartDate(rs.getString(4));
				p.setStatus(rs.getString(5));
				
				
				
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
	

}
