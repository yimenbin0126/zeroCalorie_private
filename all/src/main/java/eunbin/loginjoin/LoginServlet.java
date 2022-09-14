package eunbin.loginjoin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그인
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("LoginServlet - get login");
		
		// 세션 생성
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			// 로그인 안했을 때 - 정상 접근
			RequestDispatcher dispatch = request.getRequestDispatcher("/login/jsp/login.jsp");
			dispatch.forward(request, response);
		} else {
			// 로그인 되있을 때 - 잘못된 접근
			// 뒤로가기
			PrintWriter out = response.getWriter();
			out.println("<script language ='javascript'>window.history.back();</script>");
			out.flush();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("LoginServlet - post login");

		// SQL 문을 수행할 dao, dto 추가
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();

		// 아이디, 비밀번호
		String id = request.getParameter("e_id");
		String pw = request.getParameter("e_pw");
		System.out.println(dao.loginMember(id, pw));
		
		// 세션 생성
		HttpSession session = request.getSession();
		
		// 아이디, 비밀번호 체크
		if (dao.loginMember(id, pw) == 1) {
			dto = dao.load_login(id);
			// 세션에 회원정보 등록
			session.setAttribute("user", dto);
			System.out.println("로그인 완료");
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/main/main.jsp");
			dispatch.forward(request, response);
		} else {
			System.out.println("로그인 실패");
			// 로그인 실패 시 경고창
			PrintWriter out = response.getWriter();
			out.println("<script language ='javascript'>alert('아이디 혹은 비밀번호가 맞지 않습니다. \\n다시 로그인 해주세요.'); location.href='/all/login';</script>");
			out.flush();
		}
	}

}