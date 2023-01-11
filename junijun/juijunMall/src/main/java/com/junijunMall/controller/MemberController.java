package com.junijunMall.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
	@GetMapping("/memberSignup.do")
	public void getMemberSingup() throws Exception {
		logger.info(":::::::회원가입 창 이동:::::::");
	}
	
	@PostMapping("/memberSignup.do")
	public String getMemberSingup(MemberVO memberVO) throws Exception {
		logger.info(":::::::회원가입 시작:::::::");
		
		//암호화 
		String inputPwd = memberVO.getUserPass();
		String pwd = passEncoder.encode(inputPwd);
		
		//암호화 셋팅
		memberVO.setUserPass(pwd);
		
		memberService.memberSingup(memberVO);
		
		return "redirect:/home.do";
	}
	
	//로그인 
	@GetMapping("/memberSignin.do")
	public String getMemberSignin() throws Exception{
		//model.addAttribute("msg", true);
		logger.info(":::::::로그인 이동:::::::");
		return "/member/memberSignin";
	}
	
	@PostMapping("/memberSignin.do")
	public String postMemberSignin(MemberVO memberVO, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		logger.info(":::::::로그인 시작:::::::");
		
		
		//로그인 데이터
		MemberVO login = memberService.memberSignin(memberVO);
		
		if(login == null) {
			System.out.println("에러메시지1");
			rttr.addFlashAttribute("msg", true);
			return "redirect:/memberSignin.do";
		}	
		
		//로그인 세션
		HttpSession session = request.getSession();
		
		boolean pwdMatch = passEncoder.matches(memberVO.getUserPass(), login.getUserPass()); //true or false 
		System.out.println("pwdMatch ::: " + pwdMatch);
		
		
		
		System.out.println("memberVO ::: " + memberVO);
		System.out.println("login ::: " + login);
		
	
		
		
		if(login != null && pwdMatch) {
			session.setAttribute("member", login);
		}else {
			session.setAttribute("member", null);
			System.out.println("에러메시지2");
			rttr.addFlashAttribute("msg", false);
			//JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return "redirect:/memberSignin.do";
		}
		
		return "redirect:/home.do";
	}
	
	//로그아웃 
	@GetMapping("/memberSignout.do")
	public String memberSignout(HttpSession session) throws Exception {
		logger.info(":::::::로그아웃:::::::");
		
		memberService.memberSignout(session);
		
		return "redirect:/home.do";
	}

}
