package com.member.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberDAO;
import com.member.db.MemberDTO;

public class MemberListCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		MemberDAO m_dao = new MemberDAO();
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		memberList = m_dao.getMemberList(); 
		if(memberList == null){
			System.out.println("회원 목록 읽기 실패");
		}
		request.setAttribute("memberList", memberList);
	}
}
