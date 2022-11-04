package com.jun.service;

import java.util.List;

import com.jun.domain.ReplyVO;

public interface ReplyService {
	
	//댓글 조회 
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	//댓글 등록
	public void writeReply(ReplyVO replyVO) throws Exception;
	
	//특정 댓글 조회 
	public ReplyVO readReplySelect(int rno) throws Exception;
		
	//댓글 수정 
	public void replyUpdate(ReplyVO replyVO) throws Exception;
	
	//댓글 삭제
	public void replyDelete(ReplyVO replyVO) throws Exception;

}
