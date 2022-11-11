package com.jun.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jun.domain.MemberVO;
import com.jun.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	//회원가입
	@GetMapping("/member/register")
	public void getRegister() throws Exception {
		logger.info("get register");
	}
	
	@PostMapping("/member/register")
	public String postRegister(MemberVO memberVO) throws Exception {
		logger.info("post register");
		
		service.register(memberVO);
		
		return "redirect:/home";
	}
	
	//로그인 
	@PostMapping("/member/login")
	public String login(MemberVO memberVO, HttpServletRequest req,
								RedirectAttributes rttr) throws Exception{
		logger.info("login go");
		
		HttpSession session = req.getSession();
		
		MemberVO login = service.login(memberVO);
		
		System.out.println("login ::: " + memberVO.toString());
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", login);
		}
		
		
		return "redirect:/home";
		
	}
	
	//로그아웃 
	@GetMapping("/member/logout")
	public String logout(HttpSession session) throws Exception {
		
		logger.info("logout go");
		
		session.invalidate();
		
		return "redirect:/home";
		
	}
	
	

}
