package com.bigbang.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.member.service.MemberService;
import com.bigbang.member.vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	super();
    }

	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
//	로그인 화면으로 이동
		response.sendRedirect("loginForm.jsp");
	}

	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
//	select: 입력한 아이디와 비밀번호가 데이터베이스 내 존재하는지 확인
		request.setCharacterEncoding("utf-8");	
		MemberService mService = new MemberService();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO member = mService.login(id, pw);
		if(member.getId() != null) {
	//		로그인 성공
	//		1. 세션에 추가
			HttpSession session = request.getSession();
			session.setAttribute("name", member.getName());
			session.setAttribute("id", member.getId());
	//		2. MainServlet 으로 보내기
	//		request필요 없음 세션에 담아놨기 때문에 requestdispatcher 안해도 됨
			response.sendRedirect("MainServlet");
		}else {
	//		로그인 실패
			response.sendRedirect("loginForm.jsp");
		}
	  }

}
