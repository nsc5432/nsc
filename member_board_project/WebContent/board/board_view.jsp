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
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5" width="1000">MVC 게시판</td>
	</tr>
	<tr>
		<td height="15">
			<div align="center">제 목</div>
		</td>
		<td>
			<%=b_dto.getB_subject() %>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr>
		<td>
			<div align="center">내 용</div>
		</td>
		<td>
		<table border="1" width="490" height="250" style="table-layout: fixed;">
			<tr>
				<td>
				<%=b_dto.getB_content() %><br>
				</td>		
			</tr>
		</table>
		</td>		
	</tr>
	
	<tr>
		<td>
			<div align="center">첨부 파일</div>
		</td>
		<td>
		<%if(b_dto.getB_file()!=null){ %>
		<a href="./boardupload/<%=b_dto.getB_file() %>">
			<%=b_dto.getB_file() %>
		</a>
		<%} %>	
		</td>
	</tr>
	
	
	<tr>
		<td colspan="2" style="heigth:1px;"></td>
	</tr>
	
	<tr><td colspan="2">&nbsp;</td></tr>
	
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size="2">
				<a href="./BoardReply.bo?num=<%=b_dto.getB_num() %>">
				[답변]
				</a>&nbsp;&nbsp;
				<a href="./BoardModify.bo?num=<%=b_dto.getB_num() %>">
				[수정]
				</a>&nbsp;&nbsp;
				<a href="./BoardDelete.bo?num=<%=b_dto.getB_num() %>">
				[삭제]
				</a>&nbsp;&nbsp;
				<a href="./BoardList.bo">[목록]</a>&nbsp;&nbsp;			
			</font>
		</td>
	</tr>	
</table>
</body>
</html>