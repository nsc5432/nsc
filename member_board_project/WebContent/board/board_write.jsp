<%@page import="com.board.db.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>MVC �Խ���</title>
<script language="javascript">
	function addboard(){
		boardform.submit();
	}
</script>
</head>
<body>
<form action="./BoardInsertCommand.bo" method="post" enctype="multipart/form-data" name="boardform">
	<table cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle">
			<td colspan="5">MVC �Խ���</td>
		</tr>
		<tr>
			<td height="15">
				<div align="center">�۾���</div> 
			</td>
			<td>
				<input type="text" name="BOARD_NAME" size="10" maxlength="10">
			</td>
		</tr>
		<tr>
			<td height="15">
				<div align="center">��й�ȣ</div> 
			</td>
			<td>
				<input type="password" name="BOARD_PASS" size="10" maxlength="10">
			</td>
		</tr>
		<tr>
			<td height="15">
				<div align="center">�� ��</div> 
			</td>
			<td>
				<input type="text" name="BOARD_SUBJECT" size="50" maxlength="100">
			</td>
		</tr>
		<tr>
			<td>
				<div align="center">����</div> 
			</td>
			<td>
				<textarea name="BOARD_CONTENT" cols="67" rows="15"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<div align="center">����÷��</div> 
			</td>
			<td>
				<input type="file" name="BOARD_FILE">
			</td>
		</tr>
		<tr>
			<td colspan="2" style="height:1px">
			</td>
		</tr>
		
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr align="center" valign="middle">
			<td colspan="5">
				<a href="javascript:addboard()">[���]</a>&nbsp;&nbsp;
				<a href="javascript:history.go(-1)">[�ڷ�]</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>