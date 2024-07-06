package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

@SuppressWarnings("serial")
@WebServlet("/fetchForUpdate")
public class FetchForUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao dao = new StudentDao();
		Student s = dao.findById(id); 
		
		HttpSession hs = req.getSession();
		hs.setAttribute("student", s);
		req.getRequestDispatcher("updateDetails.jsp").include(req, resp);
	}
}
