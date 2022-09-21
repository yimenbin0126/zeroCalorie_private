<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="eunbin.loginjoin.MemberDAO, eunbin.loginjoin.MemberDTO,
	eunbin.service.DAO.ServiceDAO, eunbin.service.DTO.ServiceDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/question-fix.css">
<script src="./js/question-fix.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>

<body>

	<!-- 헤더 시작 -->
    <div id="j_hi">
        <!-- <img src="./img/logo.png" id="j_logo"> -->
        
        <%
           // 데이터 불러오기 위한 선언
           MemberDTO m_dto = new MemberDTO();
           MemberDAO m_dao = new MemberDAO();
           
           // 로그인 유무
           if((MemberDTO)session.getAttribute("user") !=null){
              m_dto = (MemberDTO)session.getAttribute("user");
        %>
        <ul id="j_list">
            <li class="j_menu1 j_menu" onclick="location.href='/all/cal/<%=m_dto.getId()%>'">캘린더</li>
            <li class="j_menu2 j_menu">커뮤니티</li>
            <li class="j_menu3 j_menu">공지사항</li>
            <li class="j_menu4 j_menu">운동</li>
            <li class="j_menu5 j_menu" onclick="location.href='/all/service/allService'">고객센터</li>
        </ul>
        <div id = e_nav>
        	<div id="e_welcome">
        		<%=m_dto.getNickname()%>님 환영합니다.
        	</div>
        	<form name="e_nav_btn">
	        	<input type ="hidden" name="e_logout" value="Y">                   
        	</form>
        	<!-- null 오류 방지용 시작 -->
        	<input type ='hidden' class = "j_btn1 j_btn" onclick="location.href='/all/login'" value="로그인">
            <input type ='hidden' class = "j_btn2 j_btn" onclick="location.href='/all/join'" value="회원가입">
            <!-- null 오류 방지용 끝 -->
            <!-- 나타나는 부분 시작 -->
            <input type ='button' class = "e_btn e_btn" onclick="location.href='/all/logout'" value="로그아웃">
            <input type ='button' class = "e_btn2 e_btn" onclick="location.href='../mypage/mypage.html'" value="마이페이지">
            <!-- 나타나는 부분 끝 -->
        </div>
        <%
        	} else {
        %>
        <div id = j_nav>
        	<!-- null 오류 방지용 시작 -->
            <input type ='hidden' class = "e_btn e_btn" onclick="location.href='/all/logout'" value="로그아웃">
            <input type ='hidden' class = "e_btn2 e_btn" onclick="location.href='../mypage/mypage.html'" value="마이페이지">               
            <!-- null 오류 방지용 끝 -->
            <!-- 나타나는 부분 시작 -->
            <input type ='button' class = "j_btn1 j_btn" onclick="location.href='/all/login'" value="로그인">
            <input type ='button' class = "j_btn2 j_btn" onclick="location.href='/all/join'" value="회원가입">
            <!-- 나타나는 부분 끝 -->
        </div>
        <%
        	}
        %>
    </div>
    <!-- 헤더 끝 -->

	<section>
		<div id="j_wrap">
			<div id="j_box">

				<div class="e_div">
					<!-- 왼쪽 카데고리 -->
					<nav class="e_nav">
						<!-- 문의 전체보기 -->
						<div class="e_nav_all" onclick="location.href='/all/service/allService'">문의 전체보기</div>
						<!-- 자주하는 질문 -->
						<div class="e_nav_question" onclick="location.href='/all/service/question-member'">
							<span>자주하는 질문</span> <img src="./img/category_click.png">
						</div>

						<!-- 1:1 문의 -->
						<div class="e_nav_onebyone" onclick="location.href='/all/service/oneByone'">1:1 문의</div>
					</nav>

					<%
						// 데이터 불러오기 위한 선언
						ServiceDTO s_dto = new ServiceDTO();
						ServiceDAO s_dao = new ServiceDAO();
						
						s_dto = (ServiceDTO)request.getAttribute("s_dto");
					%>
					<!-- 오른쪽 내용 -->
					<div class="e_right">
						<!-- 상단 -->
						<div class="e_header">
							<div class="e_hd_top">고객센터 &gt; 자주하는 질문 &gt; 글수정[관리자]</div>
							<div class="e_hd_top_title">글수정[관리자]</div>
						</div>

						<!-- 카데고리별 -->
						<form name="e_fix_form">
							<div class="e_content">
								<!-- 글쓰기 제목 -->
								<div class="e_con_title">
									<div class="e_ti_title">제목</div>
									<div class="e_ti_detail">
										<input type="text" name="e_ti_detail_input"
											id="e_ti_detail_input" value="<%=s_dto.getTitle()%>">
									</div>
								</div>

								<!-- 글쓰기 내용 -->
								<div class="e_con_content">
									<div class="e_cont_title">내용</div>
									<div class="e_cont_detail">
										<textarea name="e_cont_detail_input"
											id="e_cont_detail_input"><%=s_dto.getDescription()%></textarea>
									</div>
								</div>
							</div>

							<!-- 글쓰기 버튼 -->
							<div class="e_button">
								<div class="e_btn_fix">
									<!-- 게시판 데이터 보내기 -->
									<input type="hidden" name="e_bno" id="e_bno"
										value="<%=s_dto.getBno()%>">
										<input type="submit" value="수정 완료" id="e_btn_fix_btn">
								</div>
							</div>
						</form>
					</div>
					
				</div>

			</div>
		</div>
	</section>

</body>
</html>