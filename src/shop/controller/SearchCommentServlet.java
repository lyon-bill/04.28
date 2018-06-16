package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Do.Comment;
import login.dao.BooksDAO;
import login.dao.BooksDAOImpl;

/**
 * @author 疯人院酋长专属机  E-mail: example@lu_an.com
 * @version 创建时间：2018年6月12日  下午9:45:28
 * tags
 */
@WebServlet("/SearchCommentServlet")
public class SearchCommentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemname=(String)request.getParameter("itemname");
		System.out.println(itemname);
		
		BooksDAO bk=new BooksDAOImpl();
		List<Comment> coms = bk.SearchComment(itemname);
		request.setAttribute("coms", coms);
		request.getRequestDispatcher("ListComment.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}