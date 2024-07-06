package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		String course = req.getParameter("course");
		String gender = req.getParameter("gender");
		String branch = req.getParameter("branch");
		Date dob = Date.valueOf(req.getParameter("dob"));
		String address = req.getParameter("address");
		long mob = Long.parseLong(req.getParameter("mob"));
		String relation = req.getParameter("relation");
		
		Student s = new Student();
		
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setCourse(course);
		s.setGender(gender);
		s.setBranch(branch);
		s.setDob(dob);
		s.setAddress(address);
		s.setMob(mob);
		s.setRelationshipStatus(relation);
		
		StudentDao dao = new StudentDao();
		dao.createStudent(s);
		
		PrintWriter p = resp.getWriter();
		p.print("<h1>Account Created Successfully</h1>");
		
		RequestDispatcher r = req.getRequestDispatcher("index.jsp");
		r.include(req, resp);
	}
}
