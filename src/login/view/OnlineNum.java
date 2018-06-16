package login.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 疯人院酋长专属机  E-mail: example@aliyun.com
 * @version 创建时间：2018年5月7日  下午5:35:35
 * tags
 */
@WebServlet("/OnlineNum")
public class OnlineNum extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext SC = getServletContext();
		Integer onlinecount = (Integer) SC.getAttribute("onlinecount");
		if (onlinecount == null) {
			SC.setAttribute("onlinecount", onlinecount);
			System.out.println("onlinecount在OnlieNum中为空");
			onlinecount = 1;
		} else {
			onlinecount = onlinecount + 1;
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("");
		out.println("");
		out.println("当前在线人数为："+onlinecount);
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