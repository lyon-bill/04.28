package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String url="jdbc:mysql://localhost:3306/mylogin";
	private static final String username="root";
	private static final String password="112367";
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("连接测试……");
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("DBUtil连接出错！");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBUtil捕获异常");
			e.printStackTrace();
		}
		return null;
	}

	public static void release(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("DBUtil释放资源出错!");
			e.printStackTrace();
		}
	}

}
