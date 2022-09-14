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

// 로그아웃
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("LogoutServlet - get logout");
		
		// 로그인 세션 불러오기
		HttpSession session = request.getSession();
		session.invalidate();
		PrintWriter out = response.getWriter();
		out.println("<script language ='javascript'>alert('로그아웃 하였습니다.'); location.href='/all/main'; </script>");
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("LogoutServlet - post logout");
	}
}