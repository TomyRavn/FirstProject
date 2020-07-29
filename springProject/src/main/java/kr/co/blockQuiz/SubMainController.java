package kr.co.blockQuiz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	public String print() {
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

		return "redirect:/main.do";
	}

	// memAdd
	@RequestMapping(value = "memAdd.do", method = RequestMethod.GET)
	public String addForm() {
		return "project/memAddForm";
	}

	@RequestMapping(value = "memAdd.do", method = RequestMethod.POST)
	public String add(HttpServletRequest req) {
		MainVo vo = new MainVo();

		String memId = req.getParameter("memId");
		String memPassword = req.getParameter("memPassword");
		String memNickname = req.getParameter("memNickname");
		int num = 0;

		
		if (!(memId.equals("")) && !(memPassword.equals("") && !(memNickname.equals("")))) {
			vo.setMemId(memId);
			vo.setMemPassword(memPassword);
			vo.setMemNickname(memNickname);

			num = mainService.insertMember(vo);
			
			System.out.println(num + " 명 회원 추가");

			if (num <= 0)
				return "redirect:/memAdd.do";
			else
				return "redirect:/login.do";

		} else {
			return "redirect:/memAdd.do";
		}
	}

	// memEdit
	@RequestMapping(value = "/memEdit.do", method = RequestMethod.GET)
	public String editForm(HttpSession session, HttpServletRequest req) {
		
		String memId = (String) session.getAttribute("loginUser");
		MainVo vo = mainService.selectMember(memId);

		req.setAttribute("mainVo", vo);

		return "project/memEditForm";
	}
	
	@RequestMapping(value = "/memEdit.do", method = RequestMethod.POST)
	public String edit(HttpSession session, HttpServletRequest req) {
		MainVo vo = new MainVo();

		String memId = (String) session.getAttribute("loginUser");
		String memPassword = req.getParameter("memPassword");
		String memNickname = req.getParameter("memNickname");
		int num = 0;
		
		if(!(memPassword.equals("") && !(memNickname.equals("")))) {
			vo.setMemId(memId);
			vo.setMemPassword(memPassword);
			vo.setMemNickname(memNickname);
			
			num = mainService.updateMember(vo);
			System.out.println(num + " 명 회원 추가");
			
			if(num <= 0) return "redirect:/memEdit.do"; 
			else {
				session.setAttribute("loginNickname", vo.getMemNickname());
				return "redirect:/subMain.do";
			}
		}else {
			return "redirect:/memEdit.do";			
		}
	}

	// login
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginForm() {
		return "project/login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(MainVo vo, HttpSession session) {

		MainVo loginVo = mainService.selectLoginMember(vo);

		if (loginVo == null) {
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return "redirect:/login.do";
		} else {
			session.setAttribute("loginVo", loginVo);
			return "redirect:/subMain.do";
		}
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Map<String, Object> data(MainVo vo) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		MainVo loginVo = mainService.selectLoginMember(vo);
		map.put("loginVo", loginVo);
		
		return map;
	}

	// logout
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/login.do";
	}
}