package com.junijunMall.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junijunMall.domain.MemberVO;
import com.junijunMall.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	//암호화
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	//회원가입 
	@GetMapping("/member/memberSignup")
	public void getMemberSingup() throws Exception {
		logger.info(":::::::회원가입 창 이동:::::::");
	}
	
	@PostMapping("/member/memberSignup")
	public String getMemberSingup(MemberVO memberVO) throws Exception {
		logger.info(":::::::회원가입 시작:::::::");
		
		//암호화 
		String inputPwd = memberVO.getUserPass();
		String pwd = passEncoder.encode(inputPwd);
		
		//암호화 셋팅
		memberVO.setUserPass(pwd);
		
		memberService.memberSingup(memberVO);
		
		return "redirect:/home";
	}
	
	//로그인 
	@GetMapping("/member/memberSignin")
	public void getMemberSignin() throws Exception{
		logger.info(":::::::로그인 이동:::::::");
	}
	
	@PostMapping("/member/memberSignin")
	public String postMemberSignin(MemberVO memberVO, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		logger.info(":::::::로그인 시작:::::::");
		
		//로그인 데이터
		MemberVO login = memberService.memberSignin(memberVO);
		
		System.out.println("login ::: " + login);
		
		if(login == null) {
			rttr.addFlashAttribute("msg", true);
			return "redirect:/member/memberSignin";
		}
		
		//로그인 세션
		HttpSession session = request.getSession();
		
		boolean pwdMatch = passEncoder.matches(memberVO.getUserPass(), login.getUserPass()); //true or false 
		System.out.println("pwdMatch ::: " + pwdMatch);
		
		if(login != null && pwdMatch) {
			session.setAttribute("member", login);
		}else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			
			return "redirect:/member/memberSignin";
		}
		
		return "redirect:/home";
	}
	
	//로그아웃 
	@GetMapping("/member/memberSignout")
	public String memberSignout(HttpSession session) throws Exception {
		logger.info(":::::::로그아웃:::::::");
		
		memberService.memberSignout(session);
		
		return "redirect:/home";
	}

}
