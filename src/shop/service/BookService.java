package shop.service;

import java.util.List;

import login.Do.Books;
import login.Do.Cart;
import login.dao.BooksDAO;
import login.dao.BooksDAOImpl;

public class BookService {
	private BooksDAO dao = new BooksDAOImpl();

	public List<Books> getAllBook() {
		return dao.getAll();
	}

	public void deleteCartItem(String sid, Cart cart) {
		cart.getMap().remove(sid);
	}

	public Books findBook(int id) {
		return dao.find(id);
	}
	public void clearCart(Cart cart) {
		cart.getMap().clear();
	}
}
