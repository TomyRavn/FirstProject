

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add.do")
public class QuestionAddServlet extends HttpServlet{
	
	QuestionDaoJdbc questionDao = new QuestionDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<QuestionVo> questionList = questionDao.selectQuestionList();
		req.setAttribute("questionList", questionList);
		
		req.getRequestDispatcher("/WEB-INF/jsp/project/questionAddForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String questionWord = req.getParameter("questionWord");
		String questionExplain = req.getParameter("questionExplain");
//		String questionWriter = req.getParameter("questionWriter");
		
		int num = 0;
		
		if(!(questionWord.equals("")) && !(questionExplain.equals(""))) {
			QuestionVo vo = new QuestionVo();
			vo.setQuestionWord(questionWord);
			vo.setQuestionExplain(questionExplain);
		
//		vo.setQuestionWriter(questionWriter);
		
			num = questionDao.insertQustion(vo);
	
		}
		System.out.println(num + "개 문제 추가");
		resp.sendRedirect(req.getContextPath() + "/add.do");
		
	}
	
}