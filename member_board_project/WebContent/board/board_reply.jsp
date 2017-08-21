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
<title>MVC 게시판</title>
<script type="text/javascript">
function replyboard(){
	boardform.submit();
}
</script>
</head>
<body>
<form action="./BoardReplyCommand.bo" method="post" name="boardform">
<input type="hidden" name="BOARD_NUM" value="<%=b_dto.getB_num()%>">
<input type="hidden" name="BOARD_GROUP" value="<%=b_dto.getB_group()%>">
<input type="hidden" name="BOARD_INDENT" value="<%=b_dto.getB_indent()%>">
<input type="hidden" name="BOARD_STEP" value="<%=b_dto.getB_step()%>">
	<table cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle">
			<td colspan="5">MVC 게시판</td>
		</tr>
		<tr>
			<td height="16">
				<div align="center">글쓴이</div> 
			</td>
			<td>
				<input type="text" name="BOARD_NAME" size="10" maxlength="10">
			</td>
		</tr>
		<tr>
			<td height="16">
				<div align="center">비밀번호</div> 
			</td>
			<td>
				<input type="password" name="BOARD_PASS" size="10" maxlength="10">
			</td>
		</tr>
		<tr>
			<td height="16">
				<div align="center">제 목</div> 
			</td>
			<td>
				<input type="text" name="BOARD_SUBJECT" value="Re : <%=b_dto.getB_subject() %>" size="50" maxlength="100">
			</td>
		</tr>
		<tr>
			<td>
				<div align="center">내용</div> 
			</td>
			<td>
				<textarea name="BOARD_CONTENT" rows="15" cols="70"></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" style="height:1px">
			</td>
		</tr>
		
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr align="center" valign="middle">
			<td colspan="5">
				<a href="javascript:replyboard()">[등록]</a>&nbsp;&nbsp;
				<a href="javascript:history.go(-1)">[뒤로]</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>