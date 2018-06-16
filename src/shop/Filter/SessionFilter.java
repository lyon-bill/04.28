package shop.Filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter
 */
//@WebFilter(filterName = "sessionFilter", urlPatterns = "/*", initParams = {
//		@WebInitParam(name = "paths", value = "/LoginPro,/LoginPage.jsp") }, dispatcherTypes = {
//				DispatcherType.REQUEST })
public class SessionFilter implements javax.servlet.Filter {
//	UserDAO userDAO = new UserDAOImplConstance();
	HashSet<String> paths = new HashSet<String>();

	public SessionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("session执行过滤器");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponce = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		Object o = session.getAttribute("student");
		// System.out.println(httpRequest.getServletPath());
		// System.out.println(httpRequest.getServletContext().getContextPath()
		// +"/LoginPageView");
		if (o != null || paths.contains(httpRequest.getServletPath())) {
			chain.doFilter(request, response);
		} else {
			httpResponce.sendRedirect(httpRequest.getServletContext().getContextPath() + "/LoginPage.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String stringPath = fConfig.getInitParameter("paths");
		String[] pathArray = stringPath.split(",");
		paths = new HashSet<String>(Arrays.asList(pathArray));
		// System.out.println(paths);
	}

}
