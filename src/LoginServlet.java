
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

		if (loginVo == null) {
			resp.sendRedirect(req.getContextPath() + "/login.do");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("loginNickname", loginVo.getMemNickname());
			session.setAttribute("loginUser", loginVo.getMemId());

			resp.sendRedirect(req.getContextPath() + "/main.do");

		}

	}
}