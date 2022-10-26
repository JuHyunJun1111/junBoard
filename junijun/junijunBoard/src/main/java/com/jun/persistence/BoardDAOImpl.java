package com.jun.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jun.domain.BoardVO;


@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.jun.mappers.boardMapper";
	
	
	//조회
	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".read", bno);
	}
	
	//작성
	@Override
	public void write(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".write", vo);
	}
	
	//수정
	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".update", vo);
	}
	
	//삭제
	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".delete", bno);
	}
	
	//목록
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".list");
	}

}
