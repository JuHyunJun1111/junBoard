package com.jun.service;

import com.jun.domain.MemberVO;

public interface MemberService {
	
	//회원가입 
	public void register(MemberVO memberVO) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO memberVO) throws Exception;
	
	//회원정보수정
	public void modify(MemberVO memberVO) throws Exception;
	
	//회원 탈퇴 
	public void delete(MemberVO memberVO) throws Exception;
	
	//아이디 중복 체크 
	public MemberVO idChk(String userId) throws Exception;

}
