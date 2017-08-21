package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDTO;
import com.board.db.BoardDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardInsertCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		BoardDAO b_dao = new BoardDAO();
		BoardDTO b_dto = new BoardDTO();
		
		String realFolder="";
		String saveFolder="boardupload";
		int fileSize=5*1024*1024;
		
		realFolder=request.getSession().getServletContext().getRealPath(saveFolder);
		System.out.println("realFolder 위치  : " + realFolder);
		boolean result=false;
		
		try{
			MultipartRequest multi = null; 
			multi=new MultipartRequest(request,realFolder,fileSize,"euc-kr",new DefaultFileRenamePolicy());
			b_dto.setB_name(multi.getParameter("BOARD_NAME"));
			b_dto.setB_pass(multi.getParameter("BOARD_PASS"));
			b_dto.setB_subject(multi.getParameter("BOARD_SUBJECT"));
			b_dto.setB_content(multi.getParameter("BOARD_CONTENT"));
			b_dto.setB_file(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
			result=b_dao.boardInsert(b_dto);
			
			if(result==false){
				System.out.println("게시글 등록 실패");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
