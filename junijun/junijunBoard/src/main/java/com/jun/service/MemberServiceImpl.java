package com.jun.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jun.domain.MemberVO;
import com.jun.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;	 
	
	//회원가입
	@Override
	public void register(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		dao.register(memberVO);
		
	}
	
	//로그인
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(memberVO);
	}
	
	
	//회원정보수정
	@Override
	public void modify(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		dao.modify(memberVO);
	}

	//회원 탈퇴
	@Override
	public void delete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(memberVO);
		
	}

	//아이디 중복 체크
	@Override
	public MemberVO idChk(String userId) throws Exception {
		// TODO Auto-generated method stub
		return dao.idChk(userId);
	}

}
