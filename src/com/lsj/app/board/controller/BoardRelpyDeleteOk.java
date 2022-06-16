package com.lsj.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsj.app.action.Action;
import com.lsj.app.action.ActionForward;
import com.lsj.app.board.dao.BoardReplyDAO;

public class BoardRelpyDeleteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		BoardReplyDAO dao = new BoardReplyDAO();
		int replyNum = Integer.parseInt(req.getParameter("replyNum"));
		
		dao.delteReply(replyNum);
		return null;
	}

}
