

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/add.do")
public class QuestionAddServlet extends HttpServlet{
	
	QuestionDaoJdbc questionDao = new QuestionDaoJdbc();
	HttpSession session;
	String id;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		session = req.getSession();
		id = (String) session.getAttribute("loginUser");
		
		List<QuestionVo> questionList = questionDao.selectRecentQuestionList(id);
		req.setAttribute("questionList", questionList);
		
		req.getRequestDispatcher("/WEB-INF/jsp/project/questionAddForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String questionWord = req.getParameter("questionWord");
		String questionExplain = req.getParameter("questionExplain");
		
		int num = 0;
		QuestionVo vo = new QuestionVo();
		
		session = req.getSession();
		id = (String) session.getAttribute("loginUser");
		
		if(!(questionWord.equals("")) && !(questionExplain.equals(""))) {
			vo.setQuestionWord(questionWord);
			vo.setQuestionExplain(questionExplain);
			vo.setQuestionWriter(id);
		
			num = questionDao.insertQustion(vo);
		}
		System.out.println(num + "개 문제 추가");
		resp.sendRedirect(req.getContextPath() + "/add.do");
		
	}
	
}