package com.member.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberDTO;
import com.member.db.MemberDAO;

public class MemberViewCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		MemberDAO m_dao = new MemberDAO();
		MemberDTO m_dto = new MemberDTO();
		
		String viewId = request.getParameter("id");
		m_dto = m_dao.getDetailMember(viewId);
		
		if(m_dto == null){
			System.out.println("회원 정보 보기 실패");
		}
		request.setAttribute("m_dto", m_dto);
	}
}
