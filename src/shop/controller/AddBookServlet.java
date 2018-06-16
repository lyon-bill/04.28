package shop.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Do.Books;
import login.Do.Cart;
import login.Do.Student;
import shop.service.BookService;

/**
 * @author 疯人院酋长专属机 E-mail: example@lu_an.com
 * @version 创建时间：2018年5月20日 下午3:08:53 tags
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student stu = (Student) request.getSession().getAttribute("student");
		if (stu!=null) {
			System.out.println(stu + stu.toString() + stu.getName());
			int id = Integer.parseInt(request.getParameter("id"));
			BookService service = new BookService();
			Books book = service.findBook(id);
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
				request.getSession().setAttribute("cart", cart);
			}
			cart = cart.add(book);
			cart.getMap();
			request.getSession().setAttribute("cartmap", cart.getMap());
			// request.getSession().setAttribute("allprice", cart.getPrice());

			request.getRequestDispatcher("listcart.jsp").forward(request, response);
		} else {
			System.out.println("session过期,stu已经为空");
			response.sendRedirect("LoginPage.jsp?Err_remind=" + URLEncoder.encode("您的账号信息已经过期，请重新登录~！", "UTF-8"));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}