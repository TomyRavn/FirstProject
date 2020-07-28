import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/memAdd.do")
public class MemAddServlet extends HttpServlet{

	MainDaoJdbc mainDao = new MainDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/jsp/project/memAddForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		MainVo vo = new MainVo();
		
		String memId = req.getParameter("memId");
		String memPassword = req.getParameter("memPassword");
		String memNickname = req.getParameter("memNickname");
		int num = 0;
		
		if(!(memId.equals("")) && !(memPassword.equals("") && !(memNickname.equals("")))) {
			vo.setMemId(memId);
			vo.setMemPassword(memPassword);
			vo.setMemNickname(memNickname);
		
			num = mainDao.insertMember(vo);
			
			if(num <= 0) resp.sendRedirect(req.getContextPath() + "/memAdd.do"); 
			else resp.sendRedirect(req.getContextPath() + "/login.do");
			
		}else {
			resp.sendRedirect(req.getContextPath() + "/memAdd.do");			
		}

		System.out.println(num + " 명 회원 추가");
	}
}
