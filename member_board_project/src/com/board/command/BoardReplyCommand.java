package com.board.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDTO;
import com.board.db.BoardDAO;

public class BoardReplyCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		BoardDAO b_dao = new BoardDAO();
		BoardDTO b_dto = new BoardDTO();
		int result=0;
		
		b_dto.setB_num(Integer.parseInt(request.getParameter("BOARD_NUM")));
		b_dto.setB_name(request.getParameter("BOARD_NAME"));
		b_dto.setB_pass(request.getParameter("BOARD_PASS"));
		b_dto.setB_subject(request.getParameter("BOARD_SUBJECT"));
		b_dto.setB_content(request.getParameter("BOARD_CONTENT"));
		b_dto.setB_group(Integer.parseInt(request.getParameter("BOARD_GROUP")));
		b_dto.setB_indent(Integer.parseInt(request.getParameter("BOARD_INDENT")));
		b_dto.setB_step(Integer.parseInt(request.getParameter("BOARD_STEP")));
		
		
		result=b_dao.boardReply(b_dto);
		if(result==0){
			System.out.println("답장실패");
		}
	}
}
