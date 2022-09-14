package eunbin.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/service/question")
public class QuestionServlet extends HttpServlet  {

	// 페이지 뷰
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("QuestionServlet - get question");
		
		// 데이터 불러오기 위한 선언
		ServiceDTO s_dto = new ServiceDTO();
		ServiceDAO s_dao = new ServiceDAO();
		List<ServiceDTO> s_dto_list = new ArrayList<ServiceDTO>();
		
		// 첫 화면 - 회원정보 관리
		// 관리자 회원번호로 게시물들 불러오기
		s_dto_list = s_dao.board_All("question_member");
		request.setAttribute("s_dto_list", s_dto_list);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/service/jsp/question.jsp");
		dispatch.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("QuestionServlet - post question");
		
		// 데이터 불러오기 위한 선언
		MemberDTO m_dto = new MemberDTO();
		MemberDAO m_dao = new MemberDAO();
		ServiceDTO s_dto = new ServiceDTO();
		ServiceDAO s_dao = new ServiceDAO();
		List<ServiceDTO> s_dto_list = new ArrayList<ServiceDTO>();
		
		// 카데고리마다 다른 페이지 - 회원정보관리/사이트이용가이드
		if(request.getParameter("e_hd_choice_LR")=="L") {
			// 회원 정보 관리
			s_dto_list = s_dao.board_All("question_member");
		} else if (request.getParameter("e_hd_choice_LR")=="R") {
			// 사이트 이용 가이드
			s_dto_list = s_dao.board_All("question_member");
		}
		
		request.setAttribute("s_dto_list", s_dto_list);
		RequestDispatcher dispatch = request.getRequestDispatcher("/service/jsp/question.jsp");
		dispatch.forward(request, response);
		

	}

}