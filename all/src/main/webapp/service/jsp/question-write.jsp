<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link rel="stylesheet" href="../nav/header.css">
<link rel="stylesheet" href="./css/question-write.css">
<script src="./js/question-write.js"></script>
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
						<div class="e_nav_all" onclick="location.href='/all/service/allService'">문의 전체보기</div>
						<!-- 자주하는 질문 -->
						<div class="e_nav_question" onclick="location.href='/all/service/question'">
							<span>자주하는 질문</span> <img src="">
						</div>

						<!-- 1:1 문의 -->
						<div class="e_nav_onebyone" onclick="location.href='/all/service/oneByone'">1:1 문의</div>
					</nav>

					<!-- 오른쪽 내용 -->
					<div class="e_right">
						<!-- 상단 -->
						<div class="e_header">
							<div class="e_hd_top">고객센터 &gt; 자주하는 질문 &gt; 글쓰기[관리자]</div>
							<div class="e_hd_top_title">글쓰기[관리자]</div>
						</div>

						<!-- 카데고리별 -->
						<div class="e_content">
							<!-- 글쓰기 내용 -->
							<div class="e_con_title">
								<div class="e_ti_title">제목</div>
								<div class="e_ti_detail">sfdsff</div>
							</div>

							<!-- 사이트 이용 가이드 -->
							<div class="e_con_content">
								<div class="e_cont_title">내용</div>
								<div class="e_cont_detail">sfsfd</div>
							</div>
						</div>

						<!-- 글쓰기 버튼 -->
						<div class="e_button">
							<div class="e_btn_write" onclick="location.href='/all/service/question-write'">글쓰기</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

</body>
</html>