<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link rel="stylesheet" href="../nav/header.css">
<link rel="stylesheet" href="./css/allService.css">
<script src="service/js/allService.js"></script>
</head>

<body>

	<!-- 헤더 -->
	<%@ include file="/nav/header.jsp" %>

	<section>
		<div id="j_wrap">
			<div id="j_box">
				
				<div class="e_div">
					<!-- 카데고리 -->
					<nav class="e_nav">
						<!-- 문의 전체보기 -->
						<div class="e_nav_all" onclick="location.href='/all/service/allService'">
							<span>문의 전체보기</span>
							<img src="">
						</div>
						<!-- 자주하는 질문 -->
						<div class="e_nav_question" onclick="location.href='/all/service/question'">자주하는 질문</div>
						<!-- 1:1 문의 -->
						<div class="e_nav_onebyone" onclick="location.href='/all/service/oneByone'">1:1 문의</div>
					</nav>
	
					<!-- 오른쪽 카데고리 -->
					<div class="e_content">
						<div class="e_ct_header">고객센터 &gt; 문의 전체보기</div>
						<div class="e_ct_top">
							<h4>문의 유형</h4>
							<p>문의 유형을 선택하거나,</p>
							<p>왼쪽의 카데고리를 클릭하면</p>
							<p>해당 페이지로 이동이 가능합니다.</p>
						</div>
	
						<div class="e_ct_middle">
							<div class="e_question">
								<div class="e_que_title" onclick="location.href='/all/service/question'">
									<div>자주하는 질문</div>
								</div>
								<p class="e_que_content">
									자주하는 질문 설명<br> 자주하는 질문 설명<br> 자주하는 질문 설명<br>
								</p>
							</div>
							<div class="e_onebyone">
								<div class="e_one_title" onclick="location.href='/all/service/oneByone'">1:1 문의</div>
								<p class="e_one_content">
									1:1 문의 설명<br> 1:1 문의 설명<br> 1:1 문의 설명<br>
								</p>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

</body>
</html>