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
 * @author 疯人院酋长专属机 E-mail: example@aliyun.com
 * @version 创建时间：2018年5月7日 上午12:08:57 tags
 */
@WebServlet("/ErrorPage")
public class ErrorPage extends HttpServlet {

	int count = 0;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext SC = getServletContext();
		Integer allcount = (Integer) SC.getAttribute("allcount");
		if (allcount == null) {
			SC.setAttribute("allcount", allcount);
			System.out.println("allcount在error中为空");
			allcount = 1;
		} else {
			allcount = allcount + 1;
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println("这是一个错误页面~");
		out.println(", using the GET method");
		out.println("<br />");
		out.println("<br />");
		out.println("<br />");
		out.println("当前页面的访问次数:" + (++count));
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