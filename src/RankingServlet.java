

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ranking.do")
public class RankingServlet extends HttpServlet{

	RankingDaoJdbc rankingDao = new RankingDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<RankingVo> rankingList = rankingDao.selectRanking();
		req.setAttribute("rankingList", rankingList);
		
		req.getRequestDispatcher("/WEB-INF/jsp/project/ranking.jsp").forward(req, resp);
	}
	
}
