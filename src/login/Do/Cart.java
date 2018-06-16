package login.Do;

import java.util.LinkedHashMap;
import java.util.Map;

import login.dao.BooksDAO;
import login.dao.BooksDAOImpl;

public class Cart {

	private Map<String, CartItem> cartmap = new LinkedHashMap<String, CartItem>();

	private double allprice;
	
	public Cart add(Books book) {
		Cart cart2=new Cart();
		CartItem item = cartmap.get(String.valueOf(book.getId()));
		if (item == null) {
			item = new CartItem();
			item.setBook(book);
			item.setNum(1);
//			System.out.println("cart为空");
			cartmap.put(String.valueOf(book.getId()),item);
		} else {
//			System.out.println(item.getNum()+"cart测试前");
			item.setNum(item.getNum()+1);
//			System.out.println(item.getNum()+"cart测试后");
		}
		return this;
	}

	public void setMap(Map<String, CartItem> cartmap) {
		this.cartmap = cartmap;
	}
	public Map<String, CartItem> getMap() {
		return cartmap;
	}

	public double getPrice() {
		double totalprice = 0;
		BooksDAO bookdo=new BooksDAOImpl();
		for (Map.Entry<String, CartItem> entry : cartmap.entrySet()) {
			CartItem item = entry.getValue();
//			System.out.println("item.getPrice():"+item.getPrice());
			totalprice+=bookdo.find(item.getId()).getPrice()*item.getNum();
//			System.out.println(totalprice);
			totalprice += item.getPrice()*item.getNum();
//			System.out.println("zongjia:"+totalprice);
		}
		this.allprice = totalprice;
		return allprice;
	}

}
