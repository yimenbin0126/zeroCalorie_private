package eunbin.loginjoin;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {

	// 페이지 뷰
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher("views/join.jsp");
		dispatch.forward(req, resp);
		System.out.println("get join");
	}
	
	// 회원가입 성공
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("post join");
		
		// SQL 문을 수행할 dao, vo 추가
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		// 회원정보 불러오기
		String id = request.getParameter("e_id");
		String pw = request.getParameter("e_pw");
		String name = request.getParameter("e_name");
		String gender = request.getParameter("e_gender");
		Date birth = Date.valueOf((String)request.getParameter("e_birth"));
		String tel = request.getParameter("e_tel");
		String email = request.getParameter("e_email");
		
		// 회원정보 정의
        vo.setId(id);
        vo.setPw(pw);
        vo.setName(name);
        vo.setGender(gender);
        vo.setBirth(birth);
        vo.setTel(tel);
        vo.setEmail(email);
        
        // 회원정보 추가
		dao.addMember(vo); 
		
		request.setAttribute("vo", vo);
		RequestDispatcher dispatch = request.getRequestDispatcher("views/joincomplet.jsp");
		dispatch.forward(request, response);
	}
}