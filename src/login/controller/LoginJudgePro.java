package login.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.Cookie;
import util.DBUtil;

/**
 * 
 * 主要是用来判断账号密码对不对 （在数据库后端）
 * 
 * @author 疯人院酋长专属机 E-mail: example@aliyun.com
 * @version 创建时间：2018年4月28日 下午1:24:28 tags
 */
public class LoginJudgePro {

	public static boolean JudgeInDB(String username, String password) {

		Connection conn = DBUtil.getConnection();
		String sql = "select * from student where u_name=? and u_password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
