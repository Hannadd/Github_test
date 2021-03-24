package com.bigbang.member.controller;

import java.io.IOException;

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
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
//		1. session => id 추출
		HttpSession session = request.getSession();	
		String id = (String) session.getAttribute("id");
		if(id.equals("")) {
//		로그인 정보 없을 시, MainServlet 으로 보내기	
		response.sendRedirect("MainServlet");
		}else {
	//	2. 해당 id를 가지고 select
		MemberService mService = new MemberService();
		MemberVO member = mService.selectById(id);
	//	3. select 결과를 request에 담기
		request.setAttribute("member", member);
	//	4. modifyForm.jsp로 foward		
		RequestDispatcher disp = request.getRequestDispatcher("modifyForm.jsp");
		disp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		request => 사용자가 입력한 정보 추출
		String name = request.getParameter("name");
//		String id = request.getParameter("id"); => 얘는 못가져옴 modify에 input 없음
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
//		비밀번호 확인
		if(pw.equals("")) {
			doGet(request, response);
		}else {
			HttpSession session = request.getSession();
			MemberService mService = new MemberService();
//			id = session에서 가져옴 pw: 사용자가 입력한 비번
			MemberVO member = mService.selectById((String)session.getAttribute("id"));
			String id = (String) session.getAttribute("id");
			if(member.getPw().equals(pw)) {
//				비밀번호가 정상 입력된 경우
				MemberVO mem = new MemberVO();
				mem.setName(name);
				mem.setId(id);
				mem.setPhone1(phone1);
				mem.setPhone2(phone2);
				mem.setPhone3(phone3);
				mem.setGender(gender);
				mService.updateMember(mem);
				response.sendRedirect("MainServlet");
			}else {
//				비밀번호가 잘못 입력된 경우
				doGet(request,response);
			}
		}
//		OK인 경우
		
//		OK X인 경우
	}

}
