package com.member.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberDTO;
import com.member.db.MemberDAO;

public class MemberJoinCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDAO m_dao = new MemberDAO();
		MemberDTO m_dto = new MemberDTO();

		boolean result = false;
		
		m_dto.setM_id(request.getParameter("MEMBER_ID"));
		m_dto.setM_pw(request.getParameter("MEMBER_PW"));
		m_dto.setM_name(request.getParameter("MEMBER_NAME"));
		m_dto.setM_age(Integer.parseInt(request.getParameter("MEMBER_AGE")));
		m_dto.setM_gender(request.getParameter("MEMBER_GENDER"));
		m_dto.setM_email(request.getParameter("MEMBER_EMAIL"));
		result = m_dao.joinMember(m_dto);
		
		if(result==false){
			System.out.println("회원가입 실패");
		}
	}
}
