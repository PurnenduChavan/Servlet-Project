package com.todolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class JdbcOperations {
	public static int insert(GetSet g)
	{
		int status=0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","shank","Onepiece96@");
			
			String s="insert into tasks value(?,?,?,?)";
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(s);
			
			ps.setInt(1, g.getId());
			ps.setString(2, g.getTask());
			ps.setString(3,  g.getDuedate());
			ps.setString(4, g.getStatus());
			
			 status=ps.executeUpdate();
			
			System.out.println(status+" record inserted");
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;

	}
	
	
	
	public static List<GetSet> status(){
		
		
		List<GetSet> li=new ArrayList<GetSet>();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","shank","Onepiece96@");
			
			String s="select * from tasks";
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(s);
			
			ResultSet rs=(ResultSet) ps.executeQuery();
			
			while(rs.next()) {
				GetSet g=new GetSet();
				g.setId(rs.getInt(1));
				g.setTask(rs.getString(2));
				g.setDuedate(rs.getString(3));
				g.setStatus(rs.getString(4));
				li.add(g);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return li;
		
	}
	
	
	public static GetSet getProductById(int id){
		GetSet gs=new GetSet();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","shank","Onepiece96@");
				
			String s="select * from tasks where id=?";
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(s);
			ps.setInt(1,id);
			
			ResultSet rs=(ResultSet) ps.executeQuery();
			
			while(rs.next()){
				
				gs.setId(rs.getInt(1));
				gs.setTask(rs.getString(2));
				gs.setDuedate(rs.getString(3));;
				gs.setStatus(rs.getString(4));
			
			}
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return gs;
	}
	
	
	public static int update(GetSet s){
		int status=0;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","shank","Onepiece96@");
			
			String s1="update tasks set task=?,duedate=? ,status=? where id=?";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(s1);
		
			ps.setString(1, s.getTask());
			ps.setString(2, s.getDuedate());
			ps.setString(3, s.getStatus());
			ps.setInt(4, s.getId());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
public static int delete(int id){
		
		int status=0;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","shank","Onepiece96@");
			
			String s1="delete from tasks where id=?";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(s1);
			ps.setInt(1, id);
			
			status=ps.executeUpdate();
			
			con.close();
		}
		catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
}
