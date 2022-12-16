package com.junijunMall.persistence;

import com.junijunMall.domain.MemberVO;

public interface MemberDAO {
	
	//회원가입
	public void memberSingup(MemberVO memberVO) throws Exception;
	
	//로그인
	public MemberVO memberSignin(MemberVO memberVO) throws Exception;

}
