package com.jun.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jun.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.jun.mappers.replyMapper";
	
	//댓글 조회
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".readReply", bno);
	}
	
	//댓글 등록
	@Override
	public void writeReply(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".writeReply", replyVO);
		
	}
	
	//특정 댓글 조회
	@Override
	public ReplyVO readReplySelect(int rno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".readReplySelect", rno);
	}
	
	//댓글 수정
	@Override
	public void replyUpdate(ReplyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".updateReply");
	}

	@Override
	public void replyDelete(ReplyVO replyVO) throws Exception {
		System.out.println("댓글 삭제 진입");
		// TODO Auto-generated method stub
		sql.delete(namespace + ".deleteReply");
	}

}
