package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("Name");
		String email=request.getParameter("Email");
		String number=request.getParameter("phone");
		String date=request.getParameter("date");
		String user=request.getParameter("user");
		String pass=request.getParameter("pwd");
		Std_Details s1=new Std_Details();
		s1.setId(id);
		s1.setName(name);
		
		s1.setEmail(email);
		s1.setNumber(number);
		s1.setDate(date);
		s1.setUsername(user);
		s1.setPassword(pass);
		
		int status=StdDao.save(s1);
		
		if (status>0)
		{
			out.print("<p>Data Scored Successfully!</p>");
			request.getRequestDispatcher("Register.html").include(request, response);
		}
		else {
			out.println("Sorry! unable to save record");
		}
		
		
		
	
		
		
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
