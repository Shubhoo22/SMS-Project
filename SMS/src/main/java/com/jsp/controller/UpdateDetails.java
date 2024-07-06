package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

@SuppressWarnings("serial")
@WebServlet("/updateDetails")
public class UpdateDetails extends HttpServlet{
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
		
		StudentDao dao = new StudentDao();
		Student s = (Student) req.getSession().getAttribute("student");
		
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
		
		
		dao.updateStudent(s);
		
		PrintWriter p = resp.getWriter();
		p.print("<h1>"+s.getName()+" data updated</h1>");
		
		HttpSession hs = req.getSession();
		hs.setAttribute("student", s);
		req.getRequestDispatcher("display.jsp").include(req, resp);
	}
}
