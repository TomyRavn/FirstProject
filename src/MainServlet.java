

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main.do")
public class MainServlet extends HttpServlet{
	
	MainDaoJdbc mainDao = new MainDaoJdbc();
	QuestionDaoJdbc questionDao = new QuestionDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num = questionDao.maxQuestionNumber();

		int no = (int) (Math.random() * num + 1);
		QuestionVo questionVo = questionDao.extractQuestion(no);
//		boolean isDuplicate = false;

//		for (int i = 0; i < numArr.size(); i++) {
//			if (no == numArr.get(i)) {
//				isDuplicate = true;
//			}
//		}
		
		if (questionVo == null /*|| isDuplicate*/) {
			boolean isEmpty = true;

			while (isEmpty /*|| isDuplicate*/) {

				no = (int) (Math.random() * num + 1);
				questionVo = questionDao.extractQuestion(no);

				isEmpty = false;
//				isDuplicate = false;

				if (questionVo == null) {
					isEmpty = true;
				}

//				for (int i = 0; i < numArr.size(); i++) {
//					if (no == numArr.get(i)) {
//						isDuplicate = true;
//					}
//				}
			}
			
		}

//		numArr.add(no);

		req.setAttribute("questionVo", questionVo);

		req.getRequestDispatcher("/WEB-INF/jsp/project/main.jsp").forward(req, resp);
	}
}

