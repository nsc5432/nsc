<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
int num = Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MVC�Խ���</title>
</head>
<body>
<form name="deleteForm" action="./BoardDeleteCommand.bo?num=<%=num%>" method="post">
<table border="1">
	<tr>
		<td>�� ��й�ȣ : </td>
		<td><input name="BOARD_PASS" type="password"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<a href="javascript:deleteForm.submit()">����</a>
			&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">���ư���</a>
		</td> 
	</tr>
</table>
</form>
</body>
</html>