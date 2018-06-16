package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil2 {
	private static String DB_Driver;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	
	static{
		Properties p = new Properties();
		InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
		try {
			p.load(is);
			DB_Driver=p.getProperty("driver");
			URL=p.getProperty("url");
			USERNAME=p.getProperty("username");
			PASSWORD=p.getProperty("password");
		} catch (IOException e) {
			System.out.println("DBUtil_properties加载出错");
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("DB_Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DBUtil2加载驱动出错");
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("DBUtil2获取连接出错");
			e.printStackTrace();
		}
		return conn;
		
	}

}
