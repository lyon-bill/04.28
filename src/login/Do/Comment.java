package login.Do;

public class Comment {

	private String c_username;
	private String c_comment;
	private String c_item;
	private String c_time;

	public Comment() {
		super();
	}

	public Comment(String c_username, String c_comment, String c_item, String c_time) {
		super();
		this.c_username = c_username;
		this.c_comment = c_comment;
		this.c_item = c_item;
		this.c_time = c_time;
	}

	public String getC_username() {
		return c_username;
	}

	public void setC_username(String c_username) {
		this.c_username = c_username;
	}

	public String getC_comment() {
		return c_comment;
	}

	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}

	public String getC_item() {
		return c_item;
	}

	public void setC_item(String c_item) {
		this.c_item = c_item;
	}

	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}

}
