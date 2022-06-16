package com.lsj.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.lsj.app.board.vo.BoardReplyVO;
import com.lsj.app.mybatis.config.MyBatisConfig;

public class BoardReplyDAO {
	SqlSessionFactory sessionFactory = MyBatisConfig.getSqlsession_f();
	SqlSession sqlSession;
	
	public BoardReplyDAO() {
		sqlSession = sessionFactory.openSession(true);
	}
	
	//댓글 목록
	public List<BoardReplyVO> getReplyList(int boardNum) {
		return sqlSession.selectList("Board.getReplyList", boardNum);
	}
	
	//댓글 추가
	public void insertReply(BoardReplyVO reply) {
		sqlSession.insert("Board.insertReply",reply);
	}
	
	//댓글 수정
	public void updateReply(BoardReplyVO reply) {
		sqlSession.update("Board.updateReply", reply);
	}
	
	//댓글 삭제
	public void delteReply(int replyNum) {
		sqlSession.delete("Board.deleteReply", replyNum);
	}
}
