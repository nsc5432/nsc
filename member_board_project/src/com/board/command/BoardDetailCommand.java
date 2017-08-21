package com.board.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDTO;
import com.board.db.BoardDAO;

public class BoardDetailCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		BoardDAO b_dao = new BoardDAO();
		BoardDTO b_dto = new BoardDTO();
		int num =Integer.parseInt(request.getParameter("num"));
		b_dao.setReadCountUpdate(num);
		b_dto = b_dao.getDetail(num);
		
		if(b_dto==null){ 
			System.out.println("상세보기 실패");
		}else{
			request.setAttribute("b_dto", b_dto);
		}
	}
}
