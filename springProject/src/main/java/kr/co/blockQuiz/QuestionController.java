package kr.co.blockQuiz;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/add.do")
public class QuestionController {

	@Resource(name="questionService")
	private QuestionService questionService;

	String id;
	
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String recentList(HttpSession session, HttpServletRequest req) {
		
		session.setAttribute("countVo", null);
		CountVo countVo = new CountVo();
		session.setAttribute("countVo", countVo);
		
		id = (String) session.getAttribute("loginUser");
		
		List<QuestionVo> questionList = questionService.selectRecentQuestionList(id);
		req.setAttribute("questionList", questionList);
	
		return "project/questionAddForm";
	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String input(HttpServletRequest req, HttpSession session) {
		String questionWord = req.getParameter("questionWord");
		String questionExplain = req.getParameter("questionExplain");
	
		int num = 0;
		QuestionVo vo = new QuestionVo();
		
		id = (String) session.getAttribute("loginUser");
		
		if (!(questionWord.equals("")) && !(questionExplain.equals(""))) {
			vo.setQuestionWord(questionWord);
			vo.setQuestionExplain(questionExplain);
			vo.setQuestionWriter(id);

			num = questionService.insertQustion(vo);
		}
	
		System.out.println(num + "개 문제 추가");
		
		return "redirect:/add.do";
	}
}