package com.board.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDTO;
import com.board.db.BoardDAO;

public class BoardModifyCommand implements BoardCommand {

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
		BoardDTO b_dto= new BoardDTO();
		boolean usercheck = false;
		boolean result = false;
		
		int num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		String pw=request.getParameter("BOARD_PASS");
		
		usercheck = b_dao.isBoardWriter(num, pw);
		if(usercheck){
			System.out.println("비밀번호 인증 성공");
		}else{
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다');");
			out.println("location.href='./BoardList.bo';");
			out.println("</script>");
			out.close();
		}
		
		b_dto.setB_num(num);
		b_dto.setB_subject(request.getParameter("BOARD_SUBJECT"));
		b_dto.setB_content(request.getParameter("BOARD_CONTENT"));
				
		result = b_dao.boardModify(b_dto);
		if(result){
			System.out.println("수정완료");
		}else{
			System.out.println("수정실패");
		}
	}

}
