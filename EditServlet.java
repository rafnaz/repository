package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1> Update Student </h1> ");
		String sid=request.getParameter("id");
		Std_Details s=StdDao.getStudentById(sid);
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td> <input type='hidden' name='id' value='"+s.getId()+"'/></td></tr>");
		out.print("<tr><td>Name: </td><td><input type='text' name='name' value='"+s.getName()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+s.getEmail()+"'/></td></tr>");
		
		out.print("<tr><td>Phone no:</td><td><input type='number' name='phone' value='"+s.getNumber()+"'/></td></tr>");
		out.print("<tr><td>DOB:</td><td><input type='text' name='DOB' value='"+s.getDate()+"'/></td></tr>");
		out.print("<tr><td>Usrename :</td><td><input type='text' name='username' value='"+s.getUsername()+"'/></td></tr>");
		out.print("<tr><td>Password :</td><td><input type='password' name='password' value='"+s.getPassword()+"'/></td></tr>");
		
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
		out.print("</table");
		out.print("</form>");
		out.close();
	}

	
	

}
