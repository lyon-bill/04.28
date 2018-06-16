package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import login.Do.Person;
import util.DBUtil;

public class PersonDAOImpl implements PersonDAO {

	public boolean addPerson(Person per) {

		return false;
	}

	public boolean DeletePerson(Person pername) {
		return false;
	}

	public boolean UpdatePerson(Person per, String currentname) {

		Connection conn = DBUtil.getConnection();
		String sql = "update user set u_age=? ,u_sex=? ,u_address=? ,u_tel=?, u_email=? ,u_highedu=? ,u_gradsch=? ,u_major=? where u_name="
				+ currentname;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, per.getAge());
			ps.setString(2, per.getSex());
			ps.setString(3, per.getAddress());
			ps.setInt(4, per.getTel());
			ps.setString(5, per.getEmail());
			ps.setString(6, per.getHighestEducation());
			ps.setString(7, per.getHighestEducation());
			ps.setString(8, per.getMajor());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("PersonDAOImpl更新数据时出错~");
			e.printStackTrace();
		}
		return false;
	}

	public Person GetPersonByname(Person id) {
		return null;
	}

}
