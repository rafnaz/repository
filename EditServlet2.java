package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String DOB=request.getParameter("DOB");
		
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		Std_Details s=new Std_Details();
		s.setId(sid);
		s.setName(name);
		s.setEmail(email);
		s.setDate(DOB);
		s.setNumber(phone);
        s.setUsername(user);
        s.setPassword(pass);
        int status=StdDao.update(s);
        if(status>0)
        {
        	response.sendRedirect("ViewServlet");
        }
        else
        {
        	out.print("Sorry!unable to update the record");
        }
        out.close();
        
	}

}
