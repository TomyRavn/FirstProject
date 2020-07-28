

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {

	MainDaoJdbc mainDao = new MainDaoJdbc();
	QuestionDaoJdbc questionDao = new QuestionDaoJdbc();
	
	MainVo mainVo = new MainVo();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int num = questionDao.maxQuestionNumber();

		int no = (int) (Math.random() * num + 1);
		QuestionVo questionVo = questionDao.extractQuestion(no);
		boolean isDuplicate = false;

		
		HttpSession session = req.getSession();
		ArrayList<Integer> numArr = (ArrayList<Integer>) session.getAttribute("numArr");
		
		for (int i = 0; i < numArr.size(); i++) {
			if (no == numArr.get(i)) {
				isDuplicate = true;
			}
		}
		
		if (questionVo == null || isDuplicate) {
			boolean isEmpty = true;

			while (isEmpty || isDuplicate) {

				no = (int) (Math.random() * num + 1);
				questionVo = questionDao.extractQuestion(no);

				isEmpty = false;				
				isDuplicate = false;

				if (questionVo == null) {
					isEmpty = true;
				}

				for (int i = 0; i < numArr.size(); i++) {
					if (no == numArr.get(i)) {
						isDuplicate = true;
					}
				}
			}
			
		}

		numArr.add(no);

		session.setAttribute("questionVo", questionVo);
		session.setAttribute("numArr", numArr);
		
		req.getRequestDispatcher("/WEB-INF/jsp/project/main.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String myAns = req.getParameter("myAns");
		HttpSession session = req.getSession();
		
		CountVo countVo = (CountVo) session.getAttribute("countVo");
		QuestionVo questionVo = (QuestionVo) session.getAttribute("questionVo");
		String ans = questionVo.getQuestionWord();
		
		if(myAns.equals(ans)) {
			countVo.setCorCount(countVo.getCorCount()+1);
			countVo.setTotCount(countVo.getTotCount()+1);
		}else {
			countVo.setErrCount(countVo.getErrCount()+1);
			countVo.setTotCount(countVo.getTotCount()+1);
		}
		
		session.setAttribute("countVo", countVo);
		
		resp.sendRedirect(req.getContextPath() + "/main.do");
	}
	
}

