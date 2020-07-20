import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/memadd.do")
public class MainAddServlet extends HttpServlet{

	MainDaoJdbc mainDao = new MainDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/jsp/project/memAddForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		MainVo vo = new MainVo();
		
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPassword(req.getParameter("memPassword"));
		vo.setMemNickname(req.getParameter("memNickname"));
		
		int num = mainDao.insertMember(vo); 
		
		System.out.println(num + " 명 회원 추가");
		resp.sendRedirect(req.getContextPath() + "/main.do");
	}
}
