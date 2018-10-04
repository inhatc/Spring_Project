package com.mymac.myapp;

import java.net.PasswordAuthentication;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mymac.service.BoardService;
import com.mymac.DAO.memberDAO;
import com.mymac.VO.memberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private memberDAO dao;
	@Inject
	private BoardService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeGET(Model model ) {
		
		return "home";
	}
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String homePOST(memberVO vo, Model model,RedirectAttributes rttr, HttpSession session ) throws Exception {
		if(!checkEmail(vo.getId())) {
			rttr.addFlashAttribute("msg", "notEmail");
			return "redirect:/login";
		}
		if(dao.readMember(vo.getId())==null) {
			String confirmCode = "";
			confirmCode = randomNum();
			vo.setConfirmCode(confirmCode);
			dao.insertMember(vo);
			session.setAttribute("login", vo);
			model.addAttribute("vo", vo);
			
			return "home";
		}else {
			if(dao.readWithPW(vo.getId(), vo.getPw())==null) {
				rttr.addFlashAttribute("msg", "success");
				return "redirect:/login";
			}else {
				session.setAttribute("login", vo);
				model.addAttribute("vo", vo);
				return "redirect:/login";
			}
		}
		//model.addAttribute("id", vo.getId());
		//model.addAttribute("pw", vo.getPw());
	}
	
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model, HttpSession session) throws Exception {
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		/*
		if(session.getAttribute("login")==null) {
			return "login";
		}else {
			model.addAttribute("vo", session.getAttribute("login"));
			return "home";
		}
		*/
		return checkSession("login","home",session, model);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, RedirectAttributes rttr) {
		if(session.getAttribute("login")==null) {
			return "login";
		}else {
			session.removeAttribute("login");
			return "login";
		}
	}
	
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPageGET(HttpSession session, RedirectAttributes rttr, Model model) throws Exception {
		
			memberVO vo = (memberVO)session.getAttribute("login");
			session.removeAttribute("login");
			vo = dao.readMember(vo.getId());
			session.setAttribute("login", vo);
			model.addAttribute("vo", vo);
			return "myPage";
		
	}
	
	@RequestMapping(value = "/myPage", method = RequestMethod.POST)
	public String myPagePOST(@RequestParam("inputConfirm") String requestConfirm, HttpSession session, RedirectAttributes rttr, Model model) throws Exception {
			
			memberVO vo = (memberVO)session.getAttribute("login");
			
			if(requestConfirm.equals(vo.getConfirmCode())) {
				dao.updateMember(vo.getId());
				model.addAttribute("msg","success");
			}else {
				model.addAttribute("msg","fail");
			}
			
			vo = dao.readMember(vo.getId());
			session.setAttribute("login", vo);
			model.addAttribute("vo", vo);
			return "myPage";
		
	}
	
	@RequestMapping(value = "/emailAuth", method = RequestMethod.POST)
	public String emailAuth(memberVO vo, HttpSession session, Model model) throws Exception {
		
		vo = (memberVO)session.getAttribute("login"); 
		String email = "";
		String auth = "";
		
		email = vo.getId();
		
		sendMail mail = new sendMail();
	
		if(vo.getConfirm()==0) {
			auth = vo.getConfirmCode();
			mail.sendEmail(email.toString(), auth);
		}
		model.addAttribute("auth", auth);
		model.addAttribute("vo", session.getAttribute("login"));
			
		return "myPage";
	}
	
	public String checkSession(String sessionId, String page, HttpSession se, Model mo) {
		HttpSession session = se;
		Model model = mo;
		if(session.getAttribute(sessionId)==null) {
			return "login";
		}else {
			model.addAttribute("vo", session.getAttribute("login"));
			return "redirect:/home";
		}
	}
	
	public String randomNum() {
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<7; i++) {
			int n = (int)(Math.random() * 10);
			buffer.append(n);
		}
		return buffer.toString();
	}
	
	public boolean checkEmail(String email){
		  String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		  Pattern p = Pattern.compile(regex);
		  Matcher m = p.matcher(email);
		  boolean isNormal = m.matches();
		  return isNormal;
	}
}
