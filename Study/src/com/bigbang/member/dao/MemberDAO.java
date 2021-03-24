package com.bigbang.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bigbang.member.vo.MemberVO;

public class MemberDAO {

//	Connection (공통 기능이라 메소드 따로 만든다 (과제 할땐 Class로 빼셈)
	
	
//	1. 모든 회원 목록
	public ArrayList<MemberVO> selectAll(){
		Connection con 				= null;
		PreparedStatement pstmt 	= null;
		ResultSet rs 				= null;
		DBConnection dbCon = null;
		ArrayList<MemberVO> members = new ArrayList<MemberVO>();
		String query = "Select * from member";
		
		try {
			dbCon = DBConnection.getInstance();
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setPhone1(rs.getString("phone1"));
				member.setPhone2(rs.getString("phone2"));
				member.setPhone3(rs.getString("phone3"));
				member.setGender(rs.getString("gender"));
				members.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, rs);
		}
		return members;
	}
//	2. 로그인 처리
	public MemberVO login(String id, String pw) {
		MemberVO member 		= new MemberVO();
		Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		StringBuilder query = new StringBuilder();
		query.append("select name, id	");
		query.append("  from member 	");
		query.append(" where id=? 		");
		query.append("   and pw=?		");
		DBConnection dbCon 		= DBConnection.getInstance();
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, rs);
		}
		
		return member;
	}
//	회원 추가
	public void insertMember(MemberVO member) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		String query = "insert into member values(?,?,?,?,?,?,?)";
		DBConnection dbCon = DBConnection.getInstance();
		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getPhone1());
			pstmt.setString(5, member.getPhone2());
			pstmt.setString(6, member.getPhone3());
			pstmt.setString(7, member.getGender());
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbCon.close(con, pstmt);
		}
		
	
	}
//	3. 이름으로 회원 검색
	public MemberVO selectById(String id) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		MemberVO member 		= null;
		String query = "select * from member where id=?";
		DBConnection dbCon = DBConnection.getInstance();

		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setPhone1(rs.getString("phone1"));
				member.setPhone2(rs.getString("phone2"));
				member.setPhone3(rs.getString("phone3"));
				member.setGender(rs.getString("gender"));				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbCon.close(con, pstmt, rs);
		}
		return member;
	}
	public void updateMember(MemberVO mem) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		DBConnection dbCon = DBConnection.getInstance();
		StringBuilder query = new StringBuilder();
		query.append("update member		");
		query.append("   set name = ?	");
		query.append("     , phone1 = ?	");
		query.append("	   , phone2 = ?	");
		query.append("     , phone3 = ?	");
		query.append(" where id = ?		");		 
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mem.getName());
			pstmt.setString(2, mem.getPhone1());
			pstmt.setString(3, mem.getPhone2());
			pstmt.setString(4, mem.getPhone3());
			pstmt.setString(5, mem.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbCon.close(con, pstmt);
		}
	}
	
		
	
//	4. 회원 추가
	
//	5. 회원 수정
	
//	6. 회원 삭제
}
