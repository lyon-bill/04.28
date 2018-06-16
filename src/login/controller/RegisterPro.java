package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Do.Student;
import login.dao.StudentDAOImpl;

public class RegisterPro extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dateformat = "yyyy年MM月dd日 HH:mm:ss E";
		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		String username2 = req.getParameter("username2");
		String password2 = req.getParameter("password2");
		String ID2 = req.getParameter("ID2");
		String sex2 = req.getParameter("sex2");
		String select2 = req.getParameter("subject2");
		String age2 = req.getParameter("age2");
		String LoginTime = sdf.format(new Date()).toString();
		new StudentDAOImpl().addStudent(new Student(ID2, username2, sex2, password2, select2, age2, LoginTime));
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
