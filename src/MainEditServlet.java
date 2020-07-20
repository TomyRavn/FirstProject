import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memedit.do")
public class MainEditServlet extends HttpServlet{

	MainDaoJdbc mainDao = new MainDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("memId");
//		MainVo vo = MainDaoJdbc.selectMember
		
//		req.setAttribute("MainVo", vo);
		req.getRequestDispatcher("/WEB-INF/jsp/project/mainEditForm.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		req.setCharacterEncoding("UTF-8");
		
		MainVo vo = new MainVo();
		   vo.setMemId(req.getParameter("memId"));
	       vo.setMemPassword(req.getParameter("memPassword"));
	       vo.setMemNickname(req.getParameter("memNickname"));
	       
	       int num = mainDao.updateMember(vo);
	       resp.sendRedirect(req.getContextPath() + "/main.do");
	   	
	}
	
}
