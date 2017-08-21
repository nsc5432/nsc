<%@page import="java.util.ArrayList"%>
<%@page import="com.board.db.BoardDTO"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String id = null;
	if(session.getAttribute("id")!=null){
		id=(String)session.getAttribute("id");
	}
	ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>)request.getAttribute("boardlist");
	int listcount = ((Integer)request.getAttribute("listcount")).intValue();
	int nowpage = ((Integer)request.getAttribute("page")).intValue();
	int maxpage = ((Integer)request.getAttribute("maxpage")).intValue();
	int startpage = ((Integer)request.getAttribute("startpage")).intValue();
	int endpage = ((Integer)request.getAttribute("endpage")).intValue();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>mvc �Խ���</title>
</head>
<body>
<table width=50% border="0" cellpadding="0" cellspacing="0">
	<tr align ="center" valign="middle">
		<td colspan="4"> MVC �Խ���</td>
		<td align="right">
			<font size=2>�� ���� : ${listcount}</font>
		</td>
	</tr>
	
	<tr align="center">
		<td width="10%" height="26">
			<div align="center">��ȣ</div>
		</td>
		<td width="50%">
			<div align="center">����</div>
		</td>
		<td width="15%">
			<div align="center">�ۼ���</div>
		</td>
		<td width="15%">
			<div align="center">��¥</div>
		</td>
		<td width="10%">
			<div align="center">��ȸ��</div>
		</td>
	</tr>
	<%
		for(int i=0; i<boardList.size(); i++){
			BoardDTO b_dto = (BoardDTO)boardList.get(i); 
	%>
	<tr align="center" valign="middle">
		<td height="20">
			<%= b_dto.getB_num() %>
		</td>
		<td>
			<div align="left">
				<% 	if(b_dto.getB_indent()!=0){
						for(int a=0; a<=b_dto.getB_indent()*2; a++){%>
							&nbsp;
				<%	} %>
				��
				<%}else{ %>	
				��
				<%} %>
				<a href="./BoardDetailCommand.bo?num=<%= b_dto.getB_num()%>">
					<%=b_dto.getB_subject() %>
				</a>
			</div>
		</td>	
		<td>
			<div align="center"><%=b_dto.getB_name() %></div>
		</td>
		<td>
			<div align="center"><%=b_dto.getB_date() %></div>
		</td>
		<td>
			<div align="center"><%=b_dto.getB_readcount() %></div>
		</td>
	</tr>
	<%}%>
	<tr align="center" height="20">
		<td colspan="7">
			<% if(nowpage<=1){ %>
			[����]&nbsp;
			<%}else{ %>
			<a href="./BoardList.bo?page=<%=nowpage-1 %>">[����]</a>&nbsp;
			<%} %>
			
			<% for(int a=startpage; a<=endpage; a++){ //���� 11~20������ �����̶��..
					if(a==nowpage){ //������������ ��ũ�� ���ϰ� �ϰ� %> 
					[<%=a%>]
			<%		}else{ //������ ���������� ��ũ�� �ɾ��ش� %>
					<a href="./BoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp; 
			<%		}
			}
			
			if(nowpage>=maxpage){%>
			[����]
			<%}else{ %>
			<a href="./BoardList.bo?page=<%=nowpage+1 %>">[����]</a>
			<%} %>
		</td>
	</tr>
	<tr align="right">
		<td colspan="5">
			<%if(id!=null && id.equals("admin")){%>
				<a href="./MemberListCommand.me">[ȸ������]</a>
			<%}  %>
			<a href="./BoardWrite.bo">[�۾���]</a>
		</td>
	</tr>		
</table>
</body>
</html>