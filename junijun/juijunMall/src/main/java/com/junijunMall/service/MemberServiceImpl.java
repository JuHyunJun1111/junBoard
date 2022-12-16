package com.junijunMall.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.junijunMall.domain.MemberVO;
import com.junijunMall.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO dao;
	
	//회원가입
	@Override
	public void memberSingup(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		dao.memberSingup(memberVO);
		
	}

	//로그인
	@Override
	public MemberVO memberSignin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberSignin(memberVO);
	}
	
	//로그아웃
	@Override
	public void memberSignout(HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		session.invalidate();
	}

}
