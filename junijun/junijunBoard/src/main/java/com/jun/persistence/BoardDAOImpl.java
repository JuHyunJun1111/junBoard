package com.jun.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jun.domain.BoardVO;
import com.jun.domain.Criteria;
import com.jun.domain.SearchCriteria;


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
	
	//목록 + 페이징
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".listPage", cri);
	}
	
	//총 갯수
	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".listCount");
	}
	
	//목록 + 페이징 + 검색
	@Override
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".listSearch", scri);
	}
	
	//검색 결과 갯수
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".countSearch", scri);
	}

}
