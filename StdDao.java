package com.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StdDao {
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/plm","root","Rafnaz#1996");
			 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
		
		
		
	}
	public static int save(Std_Details s1)
	{
		int status=0;
		try
		{
			Connection con=StdDao.getConnection();
			String sql="insert into student values(?,?,?,?,?,?,?)";
			PreparedStatement pst1=con.prepareStatement(sql);
			pst1.setString(1, s1.getId());
			pst1.setString(2, s1.getName());
			pst1.setString(3, s1.getEmail());
			pst1.setString(4, s1.getNumber());
		    pst1.setString(5, s1.getDate());
			pst1.setString(6, s1.getUsername());
			pst1.setString(7, s1.getPassword());
			status=pst1.executeUpdate();
			con.close();


	}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;

}
	public static int update(Std_Details s1)
	{
		int status=0;
		try
		{
			Connection con=StdDao.getConnection();
			
			PreparedStatement pst1=con.prepareStatement("update student set name=?,email=?,phone=?,DOB=?,username=?,password=? where id=?");
			
			pst1.setString(1, s1.getName());
			pst1.setString(2, s1.getEmail());
			pst1.setString(3, s1.getNumber());
			pst1.setString(4, s1.getDate());
			pst1.setString(5, s1.getUsername());
			pst1.setString(6, s1.getPassword());
			
			
			
			
			
		
			
		    
			
			
			pst1.setString(7, s1.getId());
			status=pst1.executeUpdate();
			con.close();

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	public static int delete(String id)
	{
		int status=0;
		try
		{
			Connection con=StdDao.getConnection();
			PreparedStatement pst1=con.prepareStatement("delete from student where id=?");
			pst1.setString(1, id);
			status=pst1.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public static Std_Details getStudentById(String id)
	{
		Std_Details s=new Std_Details();
		try
		{
			Connection con=StdDao.getConnection();
			PreparedStatement pst1=con.prepareStatement("select * from student where id=?");
			pst1.setString(1,id);
			ResultSet rs=pst1.executeQuery();
			if(rs.next())
			{
				s.setId(rs.getString(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setNumber(rs.getString(4));
				s.setDate(rs.getString(5));
				s.setUsername(rs.getString(6));
				s.setPassword(rs.getString(7));
			}
			con.close();
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return s;
		
	}
	public static List<Std_Details> getAllStudents()
	{
		List<Std_Details> list=new ArrayList<Std_Details>();
		try
		{
			Connection con=StdDao.getConnection();
			PreparedStatement pst1=con.prepareStatement("select * from student");
			ResultSet rs=pst1.executeQuery();
			while(rs.next())
			{
				Std_Details s=new Std_Details();
				s.setId(rs.getString(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setNumber(rs.getString(4));
				s.setDate(rs.getString(5));
				s.setUsername(rs.getString(6));
				s.setPassword(rs.getString(7));
				list.add(s);
			}
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
	
	
}
