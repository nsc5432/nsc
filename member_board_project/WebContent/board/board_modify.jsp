<%@page import="com.board.db.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	BoardDTO b_dto = (BoardDTO)request.getAttribute("b_dto");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MVC �Խ���</title>
<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
</script>
</head>
<body>
<form action="./BoardModifyCommand.bo" method="post" name="modifyform">
<input type="hidden" name="BOARD_NUM" value=<%=b_dto.getB_num() %>>
	<table cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle">
			<td colspan="5">MVC �Խ���</td>
		</tr>
		<tr>
			<td height="16">
				<div align="center">����</div> 
			</td>
			<td>
				<input type="text" name="BOARD_SUBJECT" size="50" maxlength="100" value="<%=b_dto.getB_subject() %>">
			</td>
		</tr>
		<tr>
			<td>
				<div align="center">����</div> 
			</td>
			<td>
				<textarea name="BOARD_CONTENT" rows="15" cols="70"><%=b_dto.getB_content() %></textarea>
			</td>
		</tr>
		<% if(b_dto.getB_file()!=null){%>
			<tr>
			<td>
				<div align="center">����÷��</div> 
			</td>
			<td>
				&nbsp;&nbsp;<%=b_dto.getB_file() %>
			</td>
		<%} %>
		
		<tr>
			<td>
				<div align="center">��й�ȣ</div> 
			</td>
			<td>
				<input type="password" name="BOARD_PASS">
			</td>
		</tr>
		
		
		<tr>
			<td colspan="2" style="height:1px">
			</td>
		</tr>
		
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr align="center" valign="middle">
			<td colspan="5">
				<font size="2">
					<a href="javascript:modifyboard()">[����]</a>&nbsp;&nbsp;
					<a href="javascript:history.go(-1)">[�ڷ�]</a>&nbsp;&nbsp;
				</font>
			</td>
		</tr>
	</table>
</form>
</body>
</html>