package com.lsj.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsj.app.action.Action;
import com.lsj.app.action.ActionForward;
import com.lsj.app.board.dao.BoardDAO;
import com.lsj.app.board.vo.BoardVO;
import com.lsj.app.files.dao.FilesDAO;
import com.lsj.app.files.vo.FilesVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String saveFolder = "C:\\JSP2_LSJ\\workspace\\board_mvc_lsj\\WebContent\\app\\upload";
		int fileSize = 1024 * 1024 * 5; // 5M
		
		BoardDAO bDao = new BoardDAO();
		FilesDAO fDao = new FilesDAO(); 
		BoardVO board = new BoardVO();
		
		ActionForward forward = new ActionForward();
		
		MultipartRequest multi = null;  //이제 req.getParmeter못씀 multi. 해야함
		multi = new MultipartRequest(req, saveFolder, fileSize,"UTF-8",new DefaultFileRenamePolicy());
									//requset ,경로,파일의 크기, 인코딩방식, 정책
		board.setBoardTitle(multi.getParameter("boardTitle"));
		board.setBoardContent(multi.getParameter("boardContent"));
		board.setBoardId(multi.getParameter("boardId"));
		
		bDao.insertBoard(board);
		fDao.insertFile(multi, bDao.getSeq());
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/board/BoardListOk.bo");
		
		return forward;
	}

}
