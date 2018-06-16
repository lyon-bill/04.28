package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import login.Do.Books;
import login.Do.Comment;
import util.DBUtil;

public class BooksDAOImpl implements BooksDAO {

	public List<Books> getAll() {
		List<Books> list = new ArrayList<Books>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from books";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Books b = new Books();
				b.setId(rs.getInt("b_id"));
				b.setName(rs.getString("b_name"));
				b.setPrice(rs.getDouble("b_price"));
				b.setDescription(rs.getString("b_descrip"));
				list.add(b);
			}
			rs.close();
			ps.close();
			conn.close();
			return list;
		} catch (SQLException e) {
			System.out.println("获取全部的书失败");
			e.printStackTrace();
		}
		return null;
	}

	public Books find(int id) {
		Books b = new Books();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from books where b_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b.setId(rs.getInt("b_id"));
				b.setName(rs.getString("b_name"));
				b.setPrice(rs.getDouble("b_price"));
				b.setDescription(rs.getString("b_descrip"));
			}
			rs.close();
			ps.close();
			conn.close();
			return b;
		} catch (SQLException e) {
			System.out.println("查找书失败");
			e.printStackTrace();
		}
		return null;
	}
	public void addComment(String username,String itemid,String comment) {
		DateFormat df=DateFormat.getDateTimeInstance();
		String date=df.format(new Date()).toString();
		Connection conn = DBUtil.getConnection();
		String sql="insert into comment(c_username,c_comment,c_item,c_time) values ('"+username+"','"+comment+"','"+itemid+"','"+date+"');";
		System.out.println(sql);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int rs = ps.executeUpdate();
			System.out.println("xiugaihang:"+rs);
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("评论添加失败");
			e.printStackTrace();
		}
	}

	@Override
	public List<Comment> SearchComment(String itemid) {
		List<Comment> coms=new ArrayList<Comment>();
		Connection conn = DBUtil.getConnection();
		String sql="SELECT  * FROM comment WHERE c_item="+itemid;
		System.out.println("评论查询行:"+sql);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment=new Comment();
				comment.setC_item(rs.getString("c_username"));
				comment.setC_comment(rs.getString("c_comment"));
				comment.setC_time(rs.getString("c_time"));
				comment.setC_username(rs.getString("c_username"));
				coms.add(comment);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("查找添加失败");
			e.printStackTrace();
		}
		return coms;
	}

}
