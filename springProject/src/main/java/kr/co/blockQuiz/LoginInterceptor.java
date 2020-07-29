package kr.co.blockQuiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor : preHandle!");
		
		HttpSession session = request.getSession();
		
		MainVo loginVo = (MainVo) session.getAttribute("loginVo");

		if (loginVo == null) {
			response.sendRedirect(request.getContextPath()+"/login.do");
			return false;
		} else {
			session.setAttribute("loginNickname", loginVo.getMemNickname());
			session.setAttribute("loginUser", loginVo.getMemId());
			return true;
		}
	}
}