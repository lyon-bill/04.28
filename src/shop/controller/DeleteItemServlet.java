package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Do.Cart;
import shop.service.BookService;

@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
	BookService service = new BookService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		service.deleteCartItem(sid, cart);
		request.getRequestDispatcher("listcart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
