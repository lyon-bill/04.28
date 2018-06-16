package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Do.Student;
import login.dao.BooksDAO;
import login.dao.BooksDAOImpl;

/**
 * @author 疯人院酋长专属机  E-mail: example@lu_an.com
 * @version 创建时间：2018年6月11日  下午5:10:08
 * tags
 */
@WebServlet("/CommentHandleServlet")
public class CommentHandleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemname=request.getParameter("id");
		String stuname=((Student)request.getSession().getAttribute("student")).getName();
		String comment=request.getParameter("content");
		
		BooksDAO bk=new BooksDAOImpl();
		
		bk.addComment(stuname, itemname,comment);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}