import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memEdit.do")
public class MemEditServlet extends HttpServlet{

	MainDaoJdbc mainDao = new MainDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String memId = (String) session.getAttribute("loginUser");
		MainVo vo = mainDao.selectMember(memId);

		req.setAttribute("mainVo", vo);
		req.getRequestDispatcher("/WEB-INF/jsp/project/memEditForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		MainVo vo = new MainVo();
		
		String memId = (String) session.getAttribute("loginUser");
		String memPassword = req.getParameter("memPassword");
		String memNickname = req.getParameter("memNickname");
		int num = 0;
		
		if(!(memPassword.equals("") && !(memNickname.equals("")))) {
			vo.setMemId(memId);
			vo.setMemPassword(memPassword);
			vo.setMemNickname(memNickname);
			
			num = mainDao.updateMember(vo);
			
			if(num <= 0) resp.sendRedirect(req.getContextPath() + "/memEdit.do"); 
			else {
				session.setAttribute("loginNickname", vo.getMemNickname());
				resp.sendRedirect(req.getContextPath() + "/subMain.do");
			}
		}else {
			resp.sendRedirect(req.getContextPath() + "/memEdit.do");			
		}

		System.out.println(num + " 명 회원 추가");
	   	
	}
	
}
