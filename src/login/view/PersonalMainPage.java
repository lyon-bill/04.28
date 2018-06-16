package login.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Do.Student;

/**
 * 
 * 用来显示登录之后的 “个人主页 ” 其中提供 “返回上一页功能”（直接连接到SuccessPage）
 * 
 * @author 疯人院酋长专属机 E-mail: example@aliyun.com
 * @version 创建时间：2018年4月29日 下午2:17:24 tags
 */
@WebServlet("/PersonalMainPage")
public class PersonalMainPage extends HttpServlet {

	int count = 0;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext SC = getServletContext();
		Integer allcount = (Integer) SC.getAttribute("allcount");
		if (allcount == null) {
			SC.setAttribute("allcount", allcount);
			allcount = 1;
		} else {
			SC.setAttribute("allcount", allcount+1);
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		Cookie[] cookies = request.getCookies();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>个人主页</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    显示当前servlet全限定类名： ");
		out.print(this.getClass() + "<br />");
//		out.println("当前用户名（非utf-8）：" + CookieUtil.getCookies(cookies, "cookieusername") + "<br />");
//		out.println("当前用户密码（非utf-8）：" + CookieUtil.getCookies(cookies, "cookiepassword") + "<br />");
//		out.println("当前用户名（utf-8）："
//				+ URLEncoder.encode(CookieUtil.getCookies(cookies, "c_userna_utf").getValue(), "UTF-8") + "<br />");
//		out.println("当前用户密码（utf-8）："
//				+ URLEncoder.encode(CookieUtil.getCookies(cookies, "c_passwd_utf").getValue(), "UTF-8") + "<br />");
		out.println("session用户名:"+((Student)request.getSession().getAttribute("student")).getName());
		out.println("session用户密码:"+((Student)request.getSession().getAttribute("student")).getPassword());

		out.println("<a href='SuccessMainPage'>返回上一页</a> " + "<br />");
		out.println("<a href='SupplyPersonInfo1.jsp'>完善个人信息</a> " + "<br />");
		out.println("<a href='SeePersonInfo'>查看个人信息</a> " + "<br />");
		out.println("<a href='ListBookServlet'>查看SD</a> " + "<br />");
		out.println("<a href='listcart.jsp'>查看GWC</a> " + "<br />");
		out.println("<br />");
		out.println("<br />");
		out.println("<br />");
		out.println("当前页面访问次数：" + (++count));
		out.println("当前的工程的访问次数为：" + allcount);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}