package com.jun.persistence;

import com.jun.domain.MemberVO;

public interface MemberDAO {
	
	//회원가입 
	public void register(MemberVO memberVO) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO memberVO) throws Exception;
	
	//회원정보 수정
	public void modify(MemberVO memberVO) throws Exception;

}
