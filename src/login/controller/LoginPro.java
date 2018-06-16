package login.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Do.Student;

/**
 * 对登录行为进行控制 如果成功跳转页面 不成功则跳转至当前页面
 * 
 * @author 疯人院酋长专属机 E-mail: example@aliyun.com
 * @version 创建时间：2018年4月28日 下午1:12:38 tags
 */
@WebServlet("/LoginPro")
public class LoginPro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setCharacterEncoding("UTF-8");
		String path = "LoginPage.jsp";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nologin =null;
		nologin = request.getParameter("nologin");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
//		Cookie cookieusername = new Cookie("cookieusername", username);
//		Cookie cookiepassword = new Cookie("cookiepassword", password);
//		Cookie c_userna_utf = new Cookie("c_userna_utf", URLEncoder.encode(username, "utf-8"));
//		Cookie c_passwd_utf = new Cookie("c_passwd_utf", URLEncoder.encode(password, "utf-8"));

		//设置cookie生命周期
		if (!nologin.equals("null") || nologin != null) {
			request.getSession().setMaxInactiveInterval(400);
//			cookieusername.setMaxAge(20);
//			cookiepassword.setMaxAge(20);
//			c_passwd_utf.setMaxAge(20);
//			c_userna_utf.setMaxAge(20); 
		}
		//测试输出
//		System.out.println(URLEncoder.encode(username, "utf-8"));
//		System.out.println(URLEncoder.encode(password, "utf-8"));
//		System.out.println(username);
//		System.out.println(password);
		
		//向浏览器返回Cookie
//		response.addCookie(cookiepassword);
//		response.addCookie(cookieusername);
//		response.addCookie(c_userna_utf);
//		response.addCookie(c_passwd_utf);
		
		//session方法
		Student student = new Student(username, password, new Date().toString());
		request.getSession().setAttribute("student",student);
		
		if (LoginJudgePro.JudgeInDB(username, password)) {
			path = "LoginSuccessMainPage.jsp";
			
//			request.setAttribute("Succ_remind", "登录成功~！");
//			request.getRequestDispatcher(path).forward(request, response);
			
			response.sendRedirect(path+"?Succ_remind="+URLEncoder.encode("登录成功123~~","UTF-8"));
		} else {
//			request.setAttribute("Err_remind", "用户名或者密码错误~！");
			response.sendRedirect(path+"?Err_remind="+URLEncoder.encode("用户名或者密码错误~！","UTF-8"));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}