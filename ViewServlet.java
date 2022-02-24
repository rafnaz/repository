package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='Register.html'><h2>Add new Student</h2></a>");
		
		
		out.println("<h1 style='color:blue;' align='center' >Student's Data</h1>");
		
		List<Std_Details> list=StdDao.getAllStudents();
		out.print("<table border='1'  bordercolor='seablue;' bgcolor='grey'  style='color:black;' width='100%'>");
		out.print("<tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>DOB</th><th>Username</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
		
		
		for(Std_Details s:list)
		{
			out.print("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getEmail()+"</td><td>"+s.getNumber()+"</td><td>"+s.getDate()+"</td><td>"+s.getUsername()+"</td><td>"+s.getPassword()+"</td><td><a href='EditServlet?id="+s.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+s.getId()+"'>Delete</a></td></tr>");
			
		}
		out.print("</table>");
		out.println();
		out.println("<a href='index.html'><h2 style='color:red;' align='bottom'>HOME</h2></a>");
		
		
		out.close();
		
	
	}

}
