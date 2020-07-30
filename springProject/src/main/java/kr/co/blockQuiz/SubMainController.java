package kr.co.blockQuiz;

import java.util.ArrayList;
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

@Controller("/subMain.do")
public class SubMainController {

	@Resource(name = "mainService")
	private MainService mainService;

	// subMain
	@RequestMapping(value = "/subMain.do", method = RequestMethod.GET)
	public String print(HttpSession session) {
		
		session.setAttribute("countVo", null);
		CountVo countVo = new CountVo();
		session.setAttribute("countVo", countVo);
		
		return "project/subMain";
	}

	@RequestMapping(value = "/subMain.do", method = RequestMethod.POST)
	public String transport(HttpSession session) {
		
		session.setAttribute("countVo", null);
		session.setAttribute("numArr", null);

		ArrayList<Integer> numArr = new ArrayList<Integer>();
		CountVo countVo = new CountVo();
		

		session.setAttribute("countVo", countVo);
		session.setAttribute("numArr", numArr);
		
		
		session.setAttribute("timer", new AtomicInteger(31));
		long currentTimeMillis = System.currentTimeMillis();
		currentTimeMillis += 30 * 1000;
		session.setAttribute("cTimer", new AtomicLong(currentTimeMillis));
		
		session.setAttribute("RankingVo", null);
		
		return "redirect:/main.do";
	}
	
	
	// memAdd	//Spring은 매개변수에 이미 다 넣어준다.
	@RequestMapping(value = "/memAddajax.do")
	@ResponseBody
	public Map<String, Object> memAdd(MainVo vo) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int num = 0;

		if (!(vo.getMemId().equals("")) && !(vo.getMemPassword().equals("")) && !(vo.getMemNickname().equals(""))) {

			num = mainService.insertMember(vo);

			System.out.println(num + " 명 회원 추가");

			if (num <= 0)
				map.put("mainVo", null);
			else
				map.put("mainVo", vo);

		} else {
			map.put("mainVo", null);
		}

		return map;
	}
	
	@RequestMapping(value = "memAdd.do", method = RequestMethod.GET)
	public String addForm() {
		return "project/memAddForm";
	}
	
	// memEdit
	@RequestMapping(value = "/memEditajax.do")
	@ResponseBody
	public Map<String, Object> memEdit(HttpServletRequest req, HttpSession session) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		
		MainVo vo = new MainVo();

		MainVo memVo = (MainVo) session.getAttribute("loginVo");
		String memId = memVo.getMemId();
		String memPassword = req.getParameter("memPassword");
		String memNickname = req.getParameter("memNickname");
		int num = 0;
		
		if (!(memPassword.equals("")) && !(memNickname.equals(""))) {
			vo.setMemId(memId);
			vo.setMemPassword(memPassword);
			vo.setMemNickname(memNickname);

			num = mainService.updateMember(vo);
			System.out.println(num + " 명 회원 수정 완료");

			if (num <= 0)
				map.put("memVo", null);
			else {
				MainVo loginVo = mainService.selectLoginMember(vo);
				session.setAttribute("loginVo", loginVo);
				map.put("memVo", vo);
			}
		} else {
			map.put("memVo", null);
		}

		return map;
	}
	
	@RequestMapping(value = "/memEdit.do", method = RequestMethod.GET)
	public String editForm(HttpSession session, HttpServletRequest req) {

		session.setAttribute("RankingVo", null);
		RankingVo rankingVo = new RankingVo();
		session.setAttribute("RankingVo", rankingVo);
		
		String memId = (String) session.getAttribute("loginUser");
		MainVo vo = mainService.selectMember(memId);

		req.setAttribute("mainVo", vo);

		return "project/memEditForm";
	}

	// login
	@RequestMapping(value = "/loginajax.do")
	@ResponseBody
	public Map<String, Object> data(MainVo vo, HttpSession session) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		MainVo loginVo = mainService.selectLoginMember(vo);
		
		if (loginVo == null) {
			map.put("loginVo", null);
		} else {
			session.setAttribute("loginVo", loginVo);
			map.put("loginVo", loginVo);
		}

		return map;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginForm() {
		return "project/login";
	}

	// logout
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/login.do";
	}
}