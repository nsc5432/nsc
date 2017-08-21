package com.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDAO;
import com.board.db.BoardDTO;

public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		BoardDAO b_dao=new BoardDAO();
		ArrayList<BoardDTO> boardlist=new ArrayList<BoardDTO>();
		
		int page=1;
		int limit=10;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int listcount=b_dao.getListCount(); //�� ����Ʈ ���� �޾ƿ�
		boardlist = b_dao.getBoardList(page, limit); //����Ʈ�� �޾ƿ�
		
		//�������� ��(�ø�)
		int maxpage=(int)((double)listcount/limit +0.9);
		//���� �������� ������ ���� ������ �� (1,11,21 ...)
		int startpage= (((int)((double)page/10+0.9))-1)*10+1;
		//���� �������� ������ ������ ������ �� (10,20,30 ...)
		int endpage=maxpage;
		if(endpage>startpage+9) endpage=startpage+9;
		
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
	}
}
