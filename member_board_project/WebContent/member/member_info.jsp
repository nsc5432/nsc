<%@page import="com.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	MemberDTO m_dto = (MemberDTO)request.getAttribute("m_dto");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������ �ý��� �����ڸ��(ȸ����������)</title>
</head>
<body>
<center>
	<table border="1" width="300">
		<tr align="center">
			<td> ���̵� </td>
			<td> <%=m_dto.getM_id() %> </td>
		</tr>
		<tr align="center">
			<td> ��й�ȣ </td>
			<td> <%=m_dto.getM_pw() %> </td>
		</tr>
		<tr align="center">
			<td> �̸� </td>
			<td> <%=m_dto.getM_name() %> </td>
		</tr>
		<tr align="center">
			<td> ���� </td>
			<td> <%=m_dto.getM_age() %> </td>
		</tr>
		<tr align="center">
			<td> ���� </td>
			<td> <%=m_dto.getM_gender() %> </td>
		</tr>
		<tr align="center">
			<td> �̸��� �ּ� </td>
			<td> <%=m_dto.getM_email() %> </td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<a href="MemberListCommand.me">����Ʈ�� ���ư���</a>
			</td>
		</tr>
	</table>
</center>
</body>
</html>