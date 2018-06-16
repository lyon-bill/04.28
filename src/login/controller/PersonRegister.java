package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Do.Person;
import login.Do.Student;
import login.dao.PersonDAOImpl;

/**
 * @author 疯人院酋长专属机  E-mail: example@aliyun.com
 * @version 创建时间：2018年5月20日  上午12:18:57
 * tags:新Person的注册用这个servlet
 */
@WebServlet("/NewRegister")
public class PersonRegister extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String currentname=((Student)request.getSession().getAttribute("student")).getName();
		
		String path="SuccessJUMP.jsp";
		
		int age= Integer.parseInt(request.getParameter("age"));
		String sex= request.getParameter("sex");
		String address= request.getParameter("address");
		int tel= Integer.parseInt(request.getParameter("tel"));
		String email= request.getParameter("email");
		String highedu=request.getParameter("highestEducation");
		String gradsch=request.getParameter("graduateSchool");
		String major  =request.getParameter("major");
		if(new PersonDAOImpl().UpdatePerson(new Person(age,sex,address,tel,email,gradsch,highedu,major),currentname)) {
			request.getRequestDispatcher(path).forward(request, response);
		}else {
			path="ErrorJUMP.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}