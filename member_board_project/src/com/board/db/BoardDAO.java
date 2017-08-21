package com.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs; 
	DataSource ds;
	
	public BoardDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/study");
		} catch (NamingException e) {
			System.out.println("Board_DB연결 실패!");
			e.printStackTrace();
			return;
		} 
	}
	
	//글의 개수 구하기
	public int getListCount(){
		int x =0;
		String query="select count(*) from board";
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			if(rs.next()){
				x=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}
	
	public boolean boardInsert(BoardDTO b_dto){
		String query="insert into board (b_name,b_pass,b_subject,b_content,b_file,b_group,b_indent,b_step,b_readcount,b_date) select ?,?,?,?,?,max(b_num)+1,0,0,0,now() from board";
		int result=0;
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, b_dto.getB_name());
			ps.setString(2, b_dto.getB_pass());
			ps.setString(3, b_dto.getB_subject());
			ps.setString(4, b_dto.getB_content());
			ps.setString(5, b_dto.getB_file());

			result=ps.executeUpdate();
			if(result==0){
				System.out.println("insert Fail");
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 		}
		return false;
	}
	
	
	//글목록보기
	public ArrayList<BoardDTO> getBoardList(int page, int limit){
		String query="select A.* from ( select @rownum:=@rownum+1 as rownum, b_num,b_name,b_subject,b_content,b_file,b_group,b_indent,b_step,b_readcount,b_date from board, (select @rownum := 0)R)A where A.rownum>=? and A.rownum<=? order by b_group desc,b_step asc";
		
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		int startrow=(page-1)*10+1 ; // 1,11,21,31...
		int endrow =  startrow+limit-1; //10,20,30,40...
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, startrow);
			ps.setInt(2, endrow);
			rs=ps.executeQuery();
			
			while(rs.next()){
				BoardDTO b_dto = new BoardDTO();
				b_dto.setB_num(rs.getInt("b_num"));
				b_dto.setB_name(rs.getString("b_name"));
				b_dto.setB_subject(rs.getString("b_subject"));
				b_dto.setB_content(rs.getString("b_content"));
				b_dto.setB_file(rs.getString("b_file"));
				b_dto.setB_group(rs.getInt("b_group"));
				b_dto.setB_indent(rs.getInt("b_indent"));
				b_dto.setB_step(rs.getInt("b_step"));
				b_dto.setB_readcount(rs.getInt("b_readcount"));
				b_dto.setB_date(rs.getTimestamp("b_date"));
				list.add(b_dto);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		return null;
	}

	public void setReadCountUpdate(int num) {
		String query = "update board set b_readcount = b_readcount+1 where b_num =?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("조회수 error");
		}finally{
			try {
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//글내용
	public BoardDTO getDetail(int num) {
		BoardDTO b_dto = new BoardDTO();
		String query="select * from board where b_num = ?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, num);
			rs=ps.executeQuery();
			
			if(rs.next()){
				b_dto.setB_num(rs.getInt("b_num"));
				b_dto.setB_name(rs.getString("b_name"));
				b_dto.setB_subject(rs.getString("b_subject"));
				b_dto.setB_content(rs.getString("b_content"));
				b_dto.setB_file(rs.getString("b_file"));
				b_dto.setB_group(rs.getInt("b_group"));
				b_dto.setB_indent(rs.getInt("b_indent"));
				b_dto.setB_step(rs.getInt("b_step"));
				b_dto.setB_readcount(rs.getInt("b_readcount"));
				b_dto.setB_date(rs.getTimestamp("b_date"));
			}
			return b_dto;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean isBoardWriter(int num, String pw) {
		String query="select * from board where b_num=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, num);
			rs=ps.executeQuery();
			rs.next();
			
			if(pw.equals(rs.getString("b_pass"))){
				System.out.println("비밀번호 확인 ok");
				return true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean boardDelete(int num) {
		String query="delete from board where b_num = ?";
		int result=0;
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, num);
			result=ps.executeUpdate();
			if(result==0){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean boardModify(BoardDTO data) {
		String query = "update board set b_subject=?, b_content=? where b_num=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, data.getB_subject());
			ps.setString(2, data.getB_content());
			ps.setInt(3, data.getB_num());
			int i = ps.executeUpdate();
			if(i==1){
				System.out.println("수정성공!");
				return true;
			}else{
				System.out.println("수정실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public int boardReply(BoardDTO b_dto) {
		String query = "select max(b_num) from board";
		int num=0;
		
		int b_group=b_dto.getB_group();
		int b_indent=b_dto.getB_indent();
		int b_step=b_dto.getB_step();

		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()) num = rs.getInt(1)+1;
			else num=1;
			
			query = "update board set b_step=b_step+1 where b_group=? and b_step>?";
			ps=con.prepareStatement(query);
			ps.setInt(1, b_group);
			ps.setInt(2, b_step);
			ps.executeUpdate();
			
			b_step+=1;
			b_indent+=1;
			
			query="insert into board (b_name,b_pass,b_subject,b_content,b_file,b_group,b_indent,b_step,b_readcount,b_date) values(?,?,?,?,?,?,?,?,0,now())";
			ps=con.prepareStatement(query);
			ps.setString(1, b_dto.getB_name());
			ps.setString(2, b_dto.getB_pass());
			ps.setString(3, b_dto.getB_subject());
			ps.setString(4, b_dto.getB_content());
			ps.setString(5, ""); //답변에서는 파일을 넣지 않는다
			ps.setInt(6, b_group);
			ps.setInt(7, b_indent);
			ps.setInt(8, b_step);
			ps.executeUpdate();
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
