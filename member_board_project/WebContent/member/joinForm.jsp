<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������ ������</title>
</head>
<body>
<form name="joinform" action="./MemberJoinCommand.me" method="post">
	<center>
		<table border="1">
			<tr>
				<td colspan="2" align="center">
					<b><font size="5">ȸ������ ������</font></b>
				</td>
			</tr>
			<tr>
				<td>���̵� : </td>
				<td><input type="text" name="MEMBER_ID"/></td>
			</tr>
			<tr>
				<td>��й�ȣ : </td>
				<td><input type="password" name="MEMBER_PW"/></td>
			</tr>
			<tr>
				<td>�̸� : </td>
				<td><input type="text" name="MEMBER_NAME"/></td>
			</tr>
			<tr>
				<td>���� : </td>
				<td><input type="text" name="MEMBER_AGE" maxlength="2" size="5"/></td>
			</tr>
			<tr>
				<td>���� : </td>
				<td>
					<input type="radio" name="MEMBER_GENDER" value="��" checked/>����
					<input type="radio" name="MEMBER_GENDER" value="��"/>����
				</td>
			</tr>
			<tr>
				<td>�̸��� �ּ� : </td>
				<td><input type="text" name="MEMBER_EMAIL" size="30"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="javascript:joinform.submit()">ȸ������</a>&nbsp;&nbsp;
					<a href="javascript:joinform.reset()">�ٽ��ۼ�</a>
				</td>
			</tr>		
		</table>
	</center>
</form> 
</body>
</html>