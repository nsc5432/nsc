package com.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	DataSource ds;
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			ds=(DataSource) init.lookup("java:comp/env/jdbc/study");
		} catch (NamingException e) {
			System.out.println("Memeber_DB연결 실패!");
			e.printStackTrace();
			return;
		}
	}
	
	
	public int isMember(MemberDTO m_dto){
		String query = "select m_pw from member where m_id=?";
		int result=-1;
		
		try {
			con=ds.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, m_dto.getM_id());
			rs=ps.executeQuery();
			
			if(rs.next()){
				if(rs.getString("m_pw").equals(m_dto.getM_pw())){
					result = 1 ; //일치
				}else{
					result = 0 ; //불일치
				}
			}else{
				result = -1; //아이디 존재x
			}	
		} catch (SQLException e) {
			System.out.println("isMember()에러");
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
		return result;
	}
	
	
	public boolean joinMember(MemberDTO m_dto){
		String query = "insert into member values (?,?,?,?,?,?)";
		int result=0;
		
		try {
			con = ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, m_dto.getM_id());
			ps.setString(2, m_dto.getM_pw());
			ps.setString(3, m_dto.getM_name());
			ps.setInt(4, m_dto.getM_age());
			ps.setString(5, m_dto.getM_gender());
			ps.setString(6, m_dto.getM_email());
			result=ps.executeUpdate();
			
			if(result!=0){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("joinMember 에러");
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


	public ArrayList<MemberDTO> getMemberList() {
		String query="select * from member";
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()){
				MemberDTO m_dto = new MemberDTO();
				m_dto.setM_id(rs.getString("m_id"));
				m_dto.setM_pw(rs.getString("m_pw"));
				m_dto.setM_name(rs.getString("m_name"));
				m_dto.setM_age(rs.getInt("m_age"));
				m_dto.setM_gender(rs.getString("m_gender"));
				m_dto.setM_email(rs.getString("m_email"));
				memberList.add(m_dto);
			}
			return memberList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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


	public MemberDTO getDetailMember(String viewId) {
		String query = "select * from member where m_id=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, viewId);
			rs=ps.executeQuery();
			rs.next();
			
			MemberDTO m_dto = new MemberDTO();
			m_dto.setM_id(rs.getString("m_id"));
			m_dto.setM_pw(rs.getString("m_pw"));
			m_dto.setM_name(rs.getString("m_name"));
			m_dto.setM_age(rs.getInt("m_age"));
			m_dto.setM_gender(rs.getString("m_gender"));
			m_dto.setM_email(rs.getString("m_email"));
			
			return m_dto;
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


	public boolean deleteMember(String deleteId) {
		String query = "delete from member where m_id=?";
		int result = 0;
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, deleteId);
			result = ps.executeUpdate();
			
			if(result!=0){
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
}
