package com.lsj.app.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsj.app.action.Action;
import com.lsj.app.action.ActionForward;
import com.lsj.app.board.dao.BoardDAO;
import com.lsj.app.files.dao.FilesDAO;
import com.lsj.app.files.vo.FilesVO;

public class BoardDeleteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String saveFolder = "C:\\JSP2_LSJ\\workspace\\board_mvc_lsj\\WebContent\\app\\upload";
		FilesDAO fDao = new FilesDAO();
		BoardDAO bDao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		for(FilesVO file : fDao.getFiles(boardNum)) {
			File f = new File(saveFolder, file.getFileName());
			if(f.exists()) {
				f.delete();
			}
		}
		
		fDao.deleteFiles(boardNum);
		bDao.deleteBoard(boardNum);
		
		forward.setRedirect(false);
		forward.setPath("/board/BoardListOk.bo");
		
		return forward;
	}

}

