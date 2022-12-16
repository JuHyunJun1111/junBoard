package com.junijunMall.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.junijunMall.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sql;

	
	//회원가입
	@Override
	public void memberSingup(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		sql.insert("com.junijunMall.mappers.memberMapper.memberSignup", memberVO);
		
	}


	//로그인
	@Override
	public MemberVO memberSignin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("com.junijunMall.mappers.memberMapper.memberSignin", memberVO);
	}

}
