<%@page import="java.util.ArrayList"%>
<%@page import="com.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	ArrayList<MemberDTO> memberList = (ArrayList<MemberDTO>)request.getAttribute("memberList");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원관리 시스템 관리자모드</title>
</head>
<body>
<center>
	<table border="1" width="300">
		<tr align="center">
			<td colspan="2">회원목록</td>
		</tr>
		<%
			for(int i=0; i<memberList.size(); i++){
				MemberDTO m_dto = (MemberDTO)memberList.get(i); 
		%>
		<tr align="center">
			<td>
				<a href="MemberViewCommand.me?id=<%=m_dto.getM_id() %>"> <%=m_dto.getM_id() %> </a>
			</td>
			<td>
				<a href="MemberDeleteCommand.me?id=<%=m_dto.getM_id() %>">삭제</a>
			</td>
		</tr>
		<%} %>
		<tr align="center">
			<td colspan="2">
				<a href="./BoardList.bo">[게시판 이동]</a>
			</td>
		</tr>		
	</table>
</center>
</body>
</html>