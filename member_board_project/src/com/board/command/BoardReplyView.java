package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDTO;
import com.board.db.BoardDAO;

public class BoardReplyView implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		BoardDAO b_dao = new BoardDAO();
		BoardDTO b_dto = new BoardDTO();
		int num = Integer.parseInt(request.getParameter("num"));
		b_dto = b_dao.getDetail(num);
		if(b_dto!=null){
			System.out.println("�亯�� �������� �����͸� ������ϴ�");
		}else{
			System.out.println("�亯�� �������� �����͸� ���� ���߽��ϴ�");
		}
		request.setAttribute("b_dto", b_dto);
	}

}
