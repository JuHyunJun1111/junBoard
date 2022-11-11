package com.jun.service;

import com.jun.domain.MemberVO;

public interface MemberService {
	
	//회원가입 
	public void register(MemberVO memberVO) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO memberVO) throws Exception;
	
	//회원정보수정
	public void modify(MemberVO memberVO) throws Exception;

}
