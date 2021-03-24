package com.bigbang.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.member.service.MemberService;
import com.bigbang.member.vo.MemberVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
//		왜 겟에서 하는가?: client가 페이지 요청을 할때 request를 하고 이때 Session ID를 담아서 Request를 보냄
//		client가 보낸 request내 담긴 session ID를 가지고 서버는 session을 생성함

//		1. 로그인 여부 확인
//		1.1 Session 확인 => 정상 로그인 시 이름, 아이디 저장
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String id 	= (String) session.getAttribute("id");
//		1.1 로그인을 하지 않은 사용자의 경우 => 로그인 창으로 보냄
		if(name == null || id == null) {
			response.sendRedirect("LoginServlet"); // 원래는 로그인서블릿을 타고 가야함.
		}else {
//		2. 정상 로그인 한 경우
//		2.1 main.jsp로 전달할 데이터 생성하여 request에 담아야 한다.
//		담아야 할 정보: 회원(MemberVO)목록(ArrayList)
			MemberService mService = new MemberService();
			ArrayList<MemberVO> members = new ArrayList<MemberVO>();
			members = mService.selectAll();
//		request에 members 말아 넣기
			request.setAttribute("members", members);
			
//		2.2 main.jsp로 포워딩 시키기
//		Dispatch => 보내다 즉 RequestDispatcher은 리퀘스트를 (파라미터 에게) 보내겠다는 것
			RequestDispatcher disp =
					request.getRequestDispatcher("main.jsp");
			disp.forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
