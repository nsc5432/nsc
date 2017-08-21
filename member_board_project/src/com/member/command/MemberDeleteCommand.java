package com.member.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberDAO;

public class MemberDeleteCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		MemberDAO m_dao = new MemberDAO();
		boolean result = false;
		
		String deleteId = request.getParameter("id");
		result = m_dao.deleteMember(deleteId); 
		
		if(result==false){
			System.out.println("회원 삭제 실패");
		}
	}
}
