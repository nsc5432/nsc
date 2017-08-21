package com.board.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDTO;
import com.board.db.BoardDAO;

public class BoardModifyView implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BoardDAO b_dao = new BoardDAO();
		BoardDTO b_dto = new BoardDTO();
		int num = Integer.parseInt(request.getParameter("num"));
		
		
		b_dto = b_dao.getDetail(num);
		if(b_dto==null){
			System.out.println("내용을 얻지 못했습니다");
		}else{
			request.setAttribute("b_dto", b_dto);
		}
	}
}
