import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/subMain.do")
public class SubMainServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/project/subMain.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		session.setAttribute("countVo", null);
		session.setAttribute("numArr", null);
		
		ArrayList<Integer> numArr = new ArrayList<Integer>();
		CountVo countVo = new CountVo();
		
		session.setAttribute("countVo", countVo);
		session.setAttribute("numArr", numArr);
		
		resp.sendRedirect(req.getContextPath() + "/main.do");
	}
}