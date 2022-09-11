<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link rel="stylesheet" href="../nav/header.css">
<link rel="stylesheet" href="./css/question-detail.css">
<script src="./js/question-detail.js"></script>
</head>

<body>

	<!-- 헤더 -->
	<%@ include file="/nav/header.jsp" %>

	<section>
			<div id="j_wrap">
				<div id="j_box">

				<div class="e_div">
					<!-- 왼쪽 카데고리 -->
					<nav class="e_nav">
						<!-- 문의 전체보기 -->
						<div class="e_nav_all"
							onclick="location.href='/all/service/allService'">문의 전체보기</div>
						<!-- 자주하는 질문 -->
						<div class="e_nav_question"
							onclick="location.href='/all/service/question'">
							<span>자주하는 질문</span> <img src="">
						</div>
						<!-- 1:1 문의 -->
						<div class="e_nav_onebyone"
							onclick="location.href='/all/service/oneByone'">1:1 문의</div>
					</nav>

					<!-- 오른쪽 내용 -->
					<div class="e_right">
						<!-- 상단 -->
						<!-- 회원 정보 관리 -->
						<div class="e_hd_top">고객센터 &gt; 자주하는 질문 &gt; 회원 정보 관리</div>
						<div class="e_header">
							<div class="e_hd_top_que">회원 정보 관리</div>
						</div>

						<!-- 사이트 이용 가이드 -->
						<!-- <div class="e_header">
						<div class="e_hd_top">고객센터 &gt; 자주하는 질문 &gt; 사이트 이용 가이드</div>
						<div class="e_hd_top_que">사이트 이용 가이드</div>
					</div> -->

						<!-- 내용 -->
						<div class="e_hd_top_con">
							<div class="e_con_title">제목</div>
							<div class="e_con_explain">
								<div class="e_explain_member">
									<span>관리자</span> <span> | 조회 : 23</span>
								</div>
								<div class="e_explain_date">2022-08-02</div>
							</div>
							<div class="e_con_content">
								<p>
									설명 설명 설명설명 설명 설명설명 설명 설명설명 설명 설명설명 설명 설명설명 설명 설명설명 설명
									설명설명 설명 설명설명 설명 설명설명 설명 설명설명 설명 설명
									설명설명 설명 설명설명 설명 설명설명 설명 설명설명 설명 설명
									설명설명 설명 설명설명 설명 설명설명 설명 설명설명 설명 설명
									설명설명 설명 설명설명 설명 설명설명 설명 설명설명 설명 설명
									설명설명 설명 설명설명 설명 설명설명 설명 설명설명 설명 설명
								</p>
								<div class="e_blank"></div>
								<div class="e_content_like">
									<p class="e_like_heart">♥</p>
									<p class="e_like_num">34</p>
								</div>
							</div>
						</div>

						<div class="e_button">
							<div class="e_btn_fix">글 수정</div>
							<div class="e_btn_delete">글 삭제</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

</body>
</html>