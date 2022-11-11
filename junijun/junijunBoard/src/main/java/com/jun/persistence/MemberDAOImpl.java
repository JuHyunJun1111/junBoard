package com.jun.persistence;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jun.domain.MemberVO;


@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namesapce = "com.jun.mappers.memberMapper";
	
	//회원가입
	@Override
	public void register(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namesapce + ".register", memberVO);
		
	}
	
	
	//로그인
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namesapce + ".login", memberVO);
	}

	
	//회원정보수정
	@Override
	public void modify(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namesapce + ".modify", memberVO);
		
	}

}
