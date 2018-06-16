package login.dao;

import java.util.List;

import login.Do.Books;
import login.Do.Comment;

public interface BooksDAO {
	
	//从数据库里获取所有的书
	public List<Books> getAll();
	
	//查询书籍从数据库里
	public Books find(int id);
	
	
	//添加评论
	public void addComment(String username,String itemid,String comment);
	
	public List<Comment> SearchComment(String itemid);
}
