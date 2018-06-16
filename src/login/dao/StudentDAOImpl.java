package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.Do.Student;
import util.DBUtil;

public class StudentDAOImpl {

	//// 实现学生的注册
	public boolean addStudent(Student stu) {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO student (u_id,u_name,u_password,u_subject,u_sex,u_age,u_logintime) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getID());
			ps.setString(2, stu.getName());
			ps.setString(3, stu.getPassword());
			ps.setString(4, stu.getSubject());
			ps.setString(5, stu.getSex());
			ps.setString(6, stu.getAge());
			ps.setString(7, stu.getLoginTime());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("StudentDAOImpl插入数据时出错~");
			e.printStackTrace();
		}
		return false;
	}

	public boolean DeleteStudnet(Student stuID) {
		return false;

	}

	public boolean UpdateStudent(Student stu) {
		return false;
	}

	public Student GetStudentByID(String ID) {
		return null;
	}

}
