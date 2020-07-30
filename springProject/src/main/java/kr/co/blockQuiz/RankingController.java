package kr.co.blockQuiz;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/ranking.do")
public class RankingController {
	
	@Resource(name="rankingService")
	private RankingService rankingService;
	
	@RequestMapping(value = "/ranking.do", method = RequestMethod.GET)
	public String List(HttpServletRequest req, HttpSession session) {
		
		CountVo countVo = (CountVo) session.getAttribute("countVo");
		MainVo loginVo = (MainVo) session.getAttribute("loginVo");
		RankingVo ranking = (RankingVo) session.getAttribute("RankingVo");
		
		if(countVo != null && (countVo.getCorCount() != 0) && ranking==null) {
			RankingVo rankingVo = new RankingVo();
			int score = countVo.getCorCount();
			String memId = loginVo.getMemId();
			String memNickname = loginVo.getMemNickname();
			
			rankingVo.setuId(memId);
			rankingVo.setuNickname(memNickname);
			rankingVo.setuScore(score);
			
			rankingService.insertRanking(rankingVo);
			session.setAttribute("RankingVo", rankingVo);
		}
		
		List<RankingVo> rankingList = rankingService.selectRanking();
		req.setAttribute("rankingList", rankingList);
		
		return "project/ranking";
	}
	
}