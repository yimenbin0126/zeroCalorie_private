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

@WebServlet("/service/allService")
public class AllServiceServlet extends HttpServlet  {

	// 페이지 뷰
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 데이터 불러오기 위한 선언
		MemberDTO m_dto = new MemberDTO();
		MemberDAO m_dao = new MemberDAO();
		
		// 로그인 세션 불러오기
		HttpSession session = request.getSession();
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/service/jsp/allService.jsp");
		dispatch.forward(request, response);
		System.out.println("get allService");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("post allService");
	}
}