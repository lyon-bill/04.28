package shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Do.Books;
import shop.service.BookService;

/**
 * @author 疯人院酋长专属机 E-mail: example@lu_an.com
 * @version 创建时间：2018年5月20日 下午2:14:48 tags
 */
@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "listbook.jsp";
		BookService service = new BookService();
		List<Books> booklist = service.getAllBook(); 
		request.setAttribute("books", booklist);
		request.getRequestDispatcher(path).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}