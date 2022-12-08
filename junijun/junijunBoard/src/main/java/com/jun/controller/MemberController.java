package com.jun.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jun.domain.MemberVO;
import com.jun.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	//암호화
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	//회원가입
	@GetMapping("/member/register")
	public void getRegister() throws Exception {
		logger.info("get register");
	}
	
	@PostMapping("/member/register")
	public String postRegister(MemberVO memberVO) throws Exception {
		logger.info("post register");
		
		//암호화
		String inputPass = memberVO.getUserPass();
		String pass = passEncoder.encode(inputPass);
		memberVO.setUserPass(pass);
		
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
		
		//암호화
		boolean passMatch = passEncoder.matches(memberVO.getUserPass(), login.getUserPass());
		
		if(login != null && passMatch) {
			session.setAttribute("member", login);
		}else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}
		
//		if(login == null) {
//			session.setAttribute("member", null);
//			rttr.addFlashAttribute("msg", false);
//		} else {
//			session.setAttribute("member", login);
//		}
		
		
		return "redirect:/home";
		
	}
	
	//로그아웃 
	@GetMapping("/member/logout")
	public String logout(HttpSession session) throws Exception {
		
		logger.info("logout go");
		
		session.invalidate();
		
		return "redirect:/home";
		
	}
	
	//회원정보수정 get
	@GetMapping("/member/modify")
	public void getModify() throws Exception {
		logger.info("get modify");
		
	}
	
	@PostMapping("/member/modify")
	public String postModify(HttpSession session, MemberVO memberVO) throws Exception {
		logger.info("post modify");
		
		//암호화
		String inputPass = memberVO.getUserPass();
		String pass = passEncoder.encode(inputPass);
		memberVO.setUserPass(pass);
		
		service.modify(memberVO);
		session.invalidate();
		
		
		System.out.println("login modify ::: " + memberVO.toString());
		
		return "redirect:/home";
	}
	
	
	//회원탈퇴 
	@GetMapping("/member/delete")
	public void delete(HttpSession session, MemberVO memberVO) throws Exception {
		logger.info("member delete");

	}
	
	@PostMapping("/member/delete")
	public String postDelete(HttpSession session, MemberVO memberVO, RedirectAttributes rttr ) throws Exception {
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		System.out.println("member ::: " + member);
		
		//암호화
		String inputPass = memberVO.getUserPass();
		String pass = passEncoder.encode(inputPass);
		memberVO.setUserPass(pass);
		
		String oldPass = member.getUserPass();
		String newPass = memberVO.getUserPass();
		
		System.out.println("oldPass ::: " + oldPass);
		System.out.println("newPass ::: " + newPass);
		
		if(!(oldPass.equals(newPass))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/delete";
		}
		
		service.delete(memberVO);
		
		session.invalidate();
		
		return "redirect:/home";
	}
	
	//아이디 중복 체크 aJax
	@ResponseBody
	@PostMapping("/member/idChk")
	public int postIdChk(HttpServletRequest param) throws Exception {
		logger.info("아이디 중복 체크");
		
		String userId = param.getParameter("userId");
		MemberVO idChk = service.idChk(userId);
		
		System.out.println("idChk ::: " + idChk);
		
		int result = 0;
		
		if(idChk != null) {
			result = 1;
		}
		return result;
		
	}

	
	

}
