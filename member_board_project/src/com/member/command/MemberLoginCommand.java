package com.member.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberDTO;
import com.member.db.MemberDAO;

public class MemberLoginCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		MemberDAO m_dao = new MemberDAO();
		MemberDTO m_dto = new MemberDTO();
		
		int result = -1;
		
		m_dto.setM_id(request.getParameter("MEMBER_ID"));
		m_dto.setM_pw(request.getParameter("MEMBER_PW"));
		result = m_dao.isMember(m_dto);
		
		if(result==0){
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
		}else if(result==-1){
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
		}
		session.setAttribute("id", m_dto.getM_id());
	}
}
