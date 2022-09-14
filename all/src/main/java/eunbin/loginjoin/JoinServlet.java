package eunbin.loginjoin;

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

// 회원가입
@WebServlet("/join")
public class JoinServlet extends HttpServlet  {

	// 페이지 뷰
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("JoinServlet - get join");
		
		// 세션 생성
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			// 로그인 안했을 때 - 정상 접근
			RequestDispatcher dispatch = request.getRequestDispatcher("/join/jsp/join.jsp");
			dispatch.forward(request, response);
		} else {
			// 로그인 되있을 때 - 잘못된 접근
			// 뒤로가기
			PrintWriter out = response.getWriter();
			out.println("<script language ='javascript'>window.history.back();</script>");
			out.flush();
		}
	}
	
	// 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("JoinServlet - post join");

		// SQL 문을 수행할 dao, dto 추가
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();

		if(request.getParameter("e_idcheck_click") != null
				&& request.getParameter("e_idcheck_click").equals("Y")) {
			// 아이디 중복 체크 - 값 다시 전달
			String id = request.getParameter("e_input_id");
			PrintWriter out = response.getWriter();
			out.print(dao.idCheck(id));
		} else if (request.getParameter("e_nickCheck_click") != null
				&& request.getParameter("e_nickCheck_click").equals("Y")){
			// 닉네임 중복 체크 - 값 다시 전달
			String nickname = request.getParameter("e_input_nick");
			PrintWriter out = response.getWriter();
			out.print(dao.nickCheck(nickname));
		} else if(request.getParameter("e_sub_btn_YN") != null
				&& ((String)request.getParameter("e_sub_btn_YN")).equals("Y")) {
			System.out.println("회원가입 실행");
			// 회원가입
			// 회원정보 불러오기
			String id = request.getParameter("e_id");
			String pw = request.getParameter("e_pw");
			String name = request.getParameter("e_name");
			String nickname = request.getParameter("e_nickname");
			String gender = request.getParameter("e_gender");
			Date birth = Date.valueOf((String) request.getParameter("e_birth"));
			String tel = request.getParameter("e_tel");
			String email = request.getParameter("e_email");
			int height = Integer.valueOf((String) request.getParameter("e_height"));
			// 프로필 이미지 생략
			//String pro_img = request.getParameter("e_pro_img");
			String pro_img = "none";

			// 회원정보 정의
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setNickname(nickname);
			dto.setGender(gender);
			dto.setBirth(birth);
			dto.setTel(tel);
			dto.setEmail(email);
			dto.setHeight(height);
			dto.setPro_img(pro_img);

			// 회원정보 추가
			dao.addMember(dto);
			System.out.println("회원가입 성공");
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/login/jsp/login.jsp");
			dispatch.forward(request, response);
		}
	}

	
	
	

}