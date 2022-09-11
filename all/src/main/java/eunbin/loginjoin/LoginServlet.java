package eunbin.loginjoin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher("views/login.jsp");
		dispatch.forward(req, resp);
		System.out.println("get login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// SQL 문을 수행할 dao, dto 추가
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();

		// 아이디, 비밀번호
		String id = request.getParameter("e_id");
		String pw = request.getParameter("e_pw");

		// 아이디, 비밀번호 체크
		if (dao.loginMember(id, pw) == 1) {
			request.setAttribute("_id", id);
			RequestDispatcher dispatch = request.getRequestDispatcher("views/logincomplet.jsp");
			dispatch.forward(request, response);
			System.out.println("로그인 완료");
		} else {
			System.out.println("로그인 실패");
		}
		System.out.println("post login");
	}

}