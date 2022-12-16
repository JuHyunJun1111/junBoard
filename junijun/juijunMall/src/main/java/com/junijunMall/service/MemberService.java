package com.junijunMall.service;

import javax.servlet.http.HttpSession;

import com.junijunMall.domain.MemberVO;

public interface MemberService {
	
	//회원가입
	public void memberSingup(MemberVO memberVO) throws Exception;
	
	//로그인
	public MemberVO memberSignin(MemberVO memberVO) throws Exception;
	
	//로그아웃
	public void memberSignout(HttpSession session) throws Exception;

}
