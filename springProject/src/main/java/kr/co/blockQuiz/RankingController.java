package kr.co.blockQuiz;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/ranking.do")
public class RankingController {
	
	@Resource(name="rankingService")
	private RankingService rankingService;
	
	@RequestMapping(value = "/ranking.do", method = RequestMethod.GET)
	public String List(HttpServletRequest req) {
		
		List<RankingVo> rankingList = rankingService.selectRanking();
		req.setAttribute("rankingList", rankingList);
		
		return "project/ranking";
	}
	
}