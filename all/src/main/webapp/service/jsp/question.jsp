<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link rel="stylesheet" href="../nav/header.css">
<link rel="stylesheet" href="./css/question.css">
<script src="./js/question.js"></script>
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
						<div class="e_nav_all" onclick="location.href='/all/service/allService'">
							문의 전체보기
						</div>
						<!-- 자주하는 질문 -->
						<div class="e_nav_question" onclick="location.href='/all/service/question'">
							<span>자주하는 질문</span>
							<img src="">
						</div>
						<!-- 1:1 문의 -->
						<div class="e_nav_onebyone" onclick="location.href='/all/service/oneByone'">1:1 문의</div>
					</nav>

					<!-- 오른쪽 내용 -->
					<div class="e_right">
						<!-- 상단 -->
						<div class="e_hd_top">고객센터 &gt; 자주하는 질문</div>
						<div class="e_header">
							<div class="e_hd_top_que">자주하는 질문</div>
							<div class="e_hd_top_con">
								<span> 설명설명설명설명설명설명<br> 설명설명설명설명설명설명<br>
									설명설명설명설명설명설명
								</span>
							</div>
							
							<input type="button"  value="글쓰기" class="e_hd_top_write"
							onclick="location.href='/all/service/question-write'">

							<!-- 카데고리 선택 -->
							<div class="e_hd_choice">
								<div id="e_choice_mem">회원 정보 관리</div>
								<div id="e_choice_guide">사이트 이용 가이드</div>
							</div>
						</div>

						<!-- 카데고리별 -->
						<div class="e_content">
							<!-- 회원 정보 관리 -->
							<div class="e_con_mem">
								<ul>
									<li>번호</li>
									<li>제목</li>
									<li>글쓴이</li>
									<li>작성시간</li>
									<li>좋아요</li>
								</ul>
								<ul>
									<li>22</li>
									<li>ㅇㄹㅇㄴㄹㅇㄹㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</li>
									<li>랄라라랄ㄹ</li>
									<li>2022-09-04</li>
									<li>333</li>
								</ul>
							</div>

							<!-- 사이트 이용 가이드 -->
							<div class="e_con_guide">
								<ul>
									<li>번호</li>
									<li>제목</li>
									<li>글쓴이</li>
									<li>작성시간</li>
									<li>좋아요</li>
								</ul>
								<ul>
									<li>22</li>
									<li>ㅇㄹㅇㄴㄹㅇㄹㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</li>
									<li>랄라라랄ㄹ</li>
									<li>2022-09-04</li>
									<li>333</li>
								</ul>
							</div>
						</div>

						<div class="e_paging">
							<div class="e_paging_btnleft">&lt;</div>
							<div class="e_paging_num">
								<div id="bno1">1</div>
							</div>
							<div class="e_paging_btnright">&gt;</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

</body>
</html>