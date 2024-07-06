package com.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

@SuppressWarnings("serial")
@WebServlet("/dispall")
public class DispAll extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao = new StudentDao();
		List<Student> lOS = dao.findAllStudent();
		
		HttpSession hs = req.getSession();
		hs.setAttribute("lOS", lOS);
		
		RequestDispatcher r = req.getRequestDispatcher("dispall.jsp");
		r.include(req, resp);
	}
}
