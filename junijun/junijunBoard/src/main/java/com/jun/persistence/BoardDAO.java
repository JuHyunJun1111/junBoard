package com.jun.persistence;

import com.jun.domain.BoardVO;

public interface BoardDAO {
	
	//조회 
	public BoardVO read(int bno) throws Exception;
	
	//작성 
	public void write(BoardVO vo) throws Exception;
	
	//수정 
	public void update(BoardVO vo) throws Exception; 
	
	//삭제
	public void delete(int bno) throws Exception;
	

}
