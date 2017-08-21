<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
int num = Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MVC게시판</title>
</head>
<body>
<form name="deleteForm" action="./BoardDeleteCommand.bo?num=<%=num%>" method="post">
<table border="1">
	<tr>
		<td>글 비밀번호 : </td>
		<td><input name="BOARD_PASS" type="password"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<a href="javascript:deleteForm.submit()">삭제</a>
			&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">돌아가기</a>
		</td> 
	</tr>
</table>
</form>
</body>
</html>