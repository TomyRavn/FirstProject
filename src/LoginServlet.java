
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	MainDaoJdbc mainDao = new MainDaoJdbc();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/project/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		MainVo vo = new MainVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPassword(req.getParameter("memPassword"));

		MainVo loginVo = mainDao.selectLoginMember(vo);

		if (loginVo == null) { // 로그인 실패(입력한 ID/PW와 일치하는 회원이 없는 경우)
//				out.print("login fail");
			resp.sendRedirect(req.getContextPath() + "/login.do");
		} else { // 로그인 성공(입력한 ID/PW와 일치하는 회원이 있는 경우)
			// out.print("login success");
			HttpSession session = req.getSession(); // 현재 요청이 속한 세션 객체 가져오기
			session.setAttribute("loginNickname", loginVo.getMemNickname()); // 로그인 한 사람의 정보가 담긴 객체를 "loginUser"라는 이름으로 세션에 저장
			session.setAttribute("loginUser", loginVo.getMemId());

			resp.sendRedirect(req.getContextPath() + "/main.do");

		}

	}
}