

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/project/main.do")
public class MainServlet extends HttpServlet{
	
	MainDaoJdbc mainDao = new MainDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		MainVo vo = new MainVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPassword(req.getParameter("memPassword"));
		String nickname = mainDao.selectLoginMember(vo);
		
		req.setAttribute("nickname", nickname);
		
		req.getRequestDispatcher("/WEB-INF/jsp/project/main.jsp").forward(req, resp);
		
		//int n = (int) Math.random() * 99 + 1;
		
	}
}
