package com.board.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDAO;

public class BoardDeleteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		BoardDAO b_dao = new BoardDAO();
		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		boolean usercheck =false;
		boolean result=false;
		
		int num = Integer.parseInt(request.getParameter("num"));
		usercheck = b_dao.isBoardWriter(num, request.getParameter("BOARD_PASS"));
		if(usercheck==false){
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
		result = b_dao.boardDelete(num);
		if(result==false){
			System.out.println("게시판 삭제 실패");
		}
	}
}
