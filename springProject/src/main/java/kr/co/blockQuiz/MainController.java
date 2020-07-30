package kr.co.blockQuiz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/main.do")
public class MainController {

	@Resource(name = "mainService")
	private MainService mainService;

	@Resource(name = "questionService")
	private QuestionService questionService;

	int num;
	int no;
	MainVo mainVo = new MainVo();
	boolean isDuplicate;

	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String list(HttpSession session) {

		num = questionService.maxQuestionNumber();
		no = (int) (Math.random() * num + 1);

		QuestionVo questionVo = questionService.extractQuestion(no);
		isDuplicate = false;

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
				questionVo = questionService.extractQuestion(no);

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

//		AtomicLong num = (AtomicLong) session.getAttribute("cTimer");

//		if (num == null || (num != null && num.get() < System.currentTimeMillis())) {
//			session.setAttribute("timer", new AtomicInteger(31));
//			long currentTimeMillis = System.currentTimeMillis();
//			currentTimeMillis += 30 * 1000;
//			session.setAttribute("cTimer", new AtomicLong(currentTimeMillis));
//		}

		return "project/main";
	}

	@RequestMapping(value = "/main.do", method = RequestMethod.POST)
	public String printCount(HttpSession session, HttpServletRequest req) {

		String myAns = req.getParameter("myAns");

		CountVo countVo = (CountVo) session.getAttribute("countVo");
		QuestionVo questionVo = (QuestionVo) session.getAttribute("questionVo");
		String ans = questionVo.getQuestionWord();

		if (myAns.equals(ans)) {
			countVo.setCorCount(countVo.getCorCount() + 1);
			countVo.setTotCount(countVo.getTotCount() + 1);
		} else {
			countVo.setErrCount(countVo.getErrCount() + 1);
			countVo.setTotCount(countVo.getTotCount() + 1);
		}

		session.setAttribute("countVo", countVo);

		return "redirect:/main.do";
	}

	@RequestMapping("/data.do")
	@ResponseBody
	public Map<String, Object> data(HttpSession session) {

		AtomicInteger n = (AtomicInteger) session.getAttribute("timer");
		AtomicLong num = (AtomicLong) session.getAttribute("cTimer");

		long l = (num.get() - System.currentTimeMillis()) / 1000;
		int decr = n.decrementAndGet();

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", decr);
		map.put("l", l);

		return map;
	}
}
