package com.jun.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.jun.domain.BoardVO;
import com.jun.persistence.BoardDAO;

@Repository
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	private static String namespace = "com.jun.mappers.boardMapper";
	
	//조회
	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}
	
	//작성
	@Override
	public void write(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.write(vo);
	}
	
	//수정
	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}
	
	//삭제
	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}
	
	//목록
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

}
