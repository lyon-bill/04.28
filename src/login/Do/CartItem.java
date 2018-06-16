package login.Do;

public class CartItem {
	
	private int id;
	private Books book;
	private int num;
	private double price;

	public CartItem() {
		super();
	}

	public CartItem(int id,Books book, int num, double price) {
		super();
		this.id=id;
		this.book = book;
		this.num = num;
		this.price = price;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}