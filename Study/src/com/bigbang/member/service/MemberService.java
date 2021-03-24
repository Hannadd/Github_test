package com.bigbang.member.service;

import java.util.ArrayList;

import com.bigbang.member.dao.MemberDAO;
import com.bigbang.member.vo.MemberVO;

public class MemberService {
//	1. 모든 회원 목록
	public ArrayList<MemberVO> selectAll(){
		ArrayList<MemberVO> members = null;
		MemberDAO mDAO = new MemberDAO();
		members = mDAO.selectAll();
		return members;
	}
	public MemberVO login(String id, String pw) {
		MemberVO member = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		member = mDAO.login(id, pw);
		return member;
	}
	public void insertMember(MemberVO member) {
		MemberDAO mDAO = new MemberDAO();
		mDAO.insertMember(member);
	}
	public MemberVO selectById(String id) {
		MemberVO member = null;
		MemberDAO mDAO = new MemberDAO();
		member = mDAO.selectById(id);
		return member;
	}
	public void updateMember(MemberVO mem) {
		MemberDAO mDAO = new MemberDAO();
		mDAO.updateMember(mem);
	}
}
