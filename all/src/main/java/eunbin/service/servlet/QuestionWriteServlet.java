package eunbin.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

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

@WebServlet("/service/question-write")
public class QuestionWriteServlet extends HttpServlet  {

	// 페이지 뷰
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("QuestionWriteServlet - get question");
		
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
			// 게시물 쓰기 뷰
			RequestDispatcher dispatch = request.getRequestDispatcher("/service/jsp/question-write.jsp");
			dispatch.forward(request, response);
		}
	}
	
	// 글쓰기
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("QuestionWriteServlet - post question");
		
		// 데이터 불러오기 위한 선언
		MemberDTO m_dto = new MemberDTO();
		MemberDAO m_dao = new MemberDAO();
		ServiceDTO s_dto = new ServiceDTO();
		ServiceDAO s_dao = new ServiceDAO();
		
		// 로그인한 회원 정보 불러오기
		HttpSession session = request.getSession();
		m_dto = (MemberDTO)session.getAttribute("user");
				
		// 게시물 쓰기 실행
		// 선택타입, 제목, 내용
		String sv_type = request.getParameter("e_choice_val");
		String title = request.getParameter("e_ti_detail_input");
		String description = request.getParameter("e_cont_detail_input");
		
		// 데이터 저장
		s_dao.board_write(m_dto, sv_type, title,description);
		
		// 게시판 메인 홈페이지로 돌아가기
		RequestDispatcher dispatch = request.getRequestDispatcher("/service/jsp/question.jsp");
		dispatch.forward(request, response);
	}

}