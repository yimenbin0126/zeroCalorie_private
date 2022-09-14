package eunbin.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eunbin.loginjoin.MemberDAO;
import eunbin.loginjoin.MemberDTO;
import eunbin.service.DAO.ServiceDAO;
import eunbin.service.DTO.ServiceDTO;

@WebServlet("/service/question-detail")
public class QuestionDetailServlet extends HttpServlet  {

	// 페이지 뷰
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("QuestionDetailServlet - get question");
		
		// 세션 생성
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			// 로그인 안했을 때 - 잘못된 접근
			// 뒤로가기
			PrintWriter out = response.getWriter();
			out.println("<script language ='javascript'>window.history.back();</script>");
			out.flush();
		} else {
			// 로그인 되있을 때 - 정상 접근
			// 데이터 불러오기 위한 선언
			MemberDTO m_dto = new MemberDTO();
			MemberDAO m_dao = new MemberDAO();
			ServiceDTO s_dto = new ServiceDTO();
			ServiceDAO s_dao = new ServiceDAO();
			
			// 게시물 타입, 게시물 대표번호로 페이지 뷰 가져오기
			String sv_type = request.getParameter("sv_type");
			int group_origin = Integer.valueOf((String)request.getParameter("group_origin"));
			s_dto = s_dao.board_one(sv_type, group_origin);
			
			// 로그인 회원정보 데이터 보내기
			int member_no = m_dto.getMember_no();
			if(s_dao.board_admin_type(member_no) == "Y"){
				request.setAttribute("admin_type", "Y");
			} else {
				request.setAttribute("admin_type", "N");
			}
			request.setAttribute("s_dto", s_dto);
			RequestDispatcher dispatch = request.getRequestDispatcher("/service/jsp/question-detail.jsp");
			dispatch.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("QuestionDetailServlet - post question");
		
		// 데이터 불러오기 위한 선언
		ServiceDTO s_dto = new ServiceDTO();
		ServiceDAO s_dao = new ServiceDAO();
		
		// 값 불러오기
		String btn = request.getParameter("e_btn");
		String sv_type = request.getParameter("e_sv_type");
		int group_origin = Integer.valueOf((String)request.getParameter("e_group_origin"));
		s_dto = s_dao.board_one(sv_type, group_origin);
		
		if(btn == "fix") {
			// 게시물 수정 버튼 누를시
			request.setAttribute("s_dto", s_dto);
			
			// 수정 페이지로 이동
			RequestDispatcher dispatch = request.getRequestDispatcher("/service/jsp/question-fix.jsp");
			dispatch.forward(request, response);
			
		} else if (btn == "delete") {
			// 게시물 삭제 버튼 누를시
			s_dao.board_delete(s_dto.getBno());
			
			// 게시판 메인 화면으로 이동
			RequestDispatcher dispatch = request.getRequestDispatcher("/service/jsp/question.jsp");
			dispatch.forward(request, response);
		}
	}
}