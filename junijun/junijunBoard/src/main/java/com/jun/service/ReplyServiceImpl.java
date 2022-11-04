package com.jun.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.jun.domain.ReplyVO;
import com.jun.persistence.ReplyDAO;

@Repository
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;
	
	//댓글 조회 
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.readReply(bno);
	}

	//댓글 작성
	@Override
	public void writeReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		dao.writeReply(replyVO);
	}
	
	
	//특정 댓글 조회
	@Override
	public ReplyVO readReplySelect(int rno) throws Exception {
		// TODO Auto-generated method stub
		return dao.readReplySelect(rno);
	}
	
	//댓글 수정
	@Override
	public void replyUpdate(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		dao.replyUpdate(replyVO);
		
	}
	
	//댓글 삭제
	@Override
	public void replyDelete(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		dao.replyDelete(replyVO);
	}
	
	

}
