<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="login.css">
    <script src="login.js"></script>
</head>

<body>

   <!-- 헤더 -->
	<%@ include file="/nav/header.jsp" %>

    <section>
        <div id="j_wrap">
            <div id="j_box">
        <!-- 로고 -->
            <div class="e_logo">로그인</div>

            <form name="e_loginform">
                <!-- 아이디, 비밀번호 입력창 -->
                <div class="e_id">
                    <h4 id="e_h4_id">아이디</h4>
                    <input type="text" name="e_id" id="e_input_id" placeholder="아이디를 입력해 주세요." onfocus="this.placeholder=''"
                    onblur="this.placeholder='아이디를 입력해 주세요.'">
                </div>
        
                <div class="e_password">
                    <h4 id="e_h4_pass">비밀번호</h4>
                    <input type="password" name="e_pw" id="e_input_pass" placeholder="비밀번호를 입력해 주세요." onfocus="this.placeholder=''"
                    onblur="this.placeholder='비밀번호를 입력해 주세요.'">
                </div>
        
                <!-- 자동로그인 -->
                <div class="e_auto_login">
                    <input type="checkbox" name="e_auto_login">
                    <span id="e_auto_logincheck">로그인 유지</span>
                </div>
        
                <!-- 로그인 버튼-->
                <div class="e_login">
                    <input type="submit" id="e_login_btn" value="로그인">
                </div>
        
                <!-- 회원가입, 비밀번호 찾기 -->
                <div class="e_other">
                    <a class="e_join_member" href="../join/join.html">회원가입</a>
                    <a class="e_find_pass" href="#">비밀번호 찾기</a>
                </div>
            </div>
        </div>
        </form>
    </section>

</body>

</html>