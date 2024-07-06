package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

@SuppressWarnings("serial")
@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		StudentDao dao = new StudentDao();
		Student s = dao.findByemail(email);
		
		PrintWriter p = resp.getWriter();
		if(s!=null && s.getPassword().equals(pass)) {
			p.print("<h1>Login Successfull</h1>");
			HttpSession hs = req.getSession();
			hs.setAttribute("student", s);
			req.getRequestDispatcher("display.jsp").include(req, resp);
		}
		else {
			p.print("<h1>Wrong Credentials</h1>");
			req.getRequestDispatcher("login.jsp").include(req, resp);
		}
		
				
	}
}
