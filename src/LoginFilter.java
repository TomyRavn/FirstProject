
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter{

	private ArrayList<String> whiteList = new ArrayList<String>();

	@Override
	public void init(FilterConfig filterconfig) throws ServletException{

		System.out.println("LoginFilter의 init 실행!");

				whiteList.add("/login.do");
		//		whiteList.add();
		//		whiteList.add();
		//		whiteList.add();

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("LoginFilter의 doFilter 실행!");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		System.out.println(req.getRequestURI());

		String reqPath = req.getRequestURI().substring(req.getContextPath().length());

		whiteList.contains(req.getRequestURI());

		if(whiteList.contains(reqPath) == false) {

			HttpSession session = req.getSession();
			String loginId = (String)session.getAttribute("loginUser");

			if(loginId == null) {
				resp.sendRedirect(req.getContextPath() + "/login.do");
				return;
			}
		}
		chain.doFilter(request, response);
	}

}

