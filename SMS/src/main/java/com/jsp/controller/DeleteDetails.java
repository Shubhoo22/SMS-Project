package com.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

@SuppressWarnings("serial")
@WebServlet("/deleteDetails")
public class DeleteDetails extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao();
		dao.deleteStudentById(id);
		List<Student> lOS = dao.findAllStudent();
		
		req.getSession().setAttribute("lOS", lOS);
		resp.getWriter().print("<h1>Data Deleted</h1>");
		req.getRequestDispatcher("dispall.jsp").include(req, resp);
	}
}
