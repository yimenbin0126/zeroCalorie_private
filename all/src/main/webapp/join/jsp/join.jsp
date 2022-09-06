<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="css/join.css">
    <script src="js/join.js"></script>
</head>

<body>

    <div id="j_hi">
        
        <!-- <img src="./img/logo.png" id="j_logo"> -->
        
        <ul id="j_list">
            <li class="j_menu1 j_menu">캘린더</li>
            <li class="j_menu2 j_menu">커뮤니티</li>
            <li class="j_menu3 j_menu">공지사항</li>
            <li class="j_menu4 j_menu">운동</li>
        </ul>

        <div id = j_nav> 
            <input type ='button' class = "j_btn1 j_btn" onclick="location.href='../login/login.html'" value="로그인">
            <input type ='button' class = "j_btn2 j_btn" onclick="location.href='../mypage/mypage.html'" value="마이페이지">
            <input type ='button' class = "j_btn3 j_btn" onclick="location.href='../join/join.html'" value="회원가입">
        </div>
    </div>


	<section>
		<div id="j_wrap">
			<div id="j_box">

				<form name="e_mainform">
					<!-- 뒤로가기(로그인하기) -->
					<div class="e_back">
						<input type="button" id="e_back_btn"
							onClick="location.href='../main/main.html'"
							value="&lt;    메인으로 이동">
					</div>

					<!-- 로고 -->
					<div class="e_logo">회원가입</div>

					<!-- 아이디 -->
					<div class="e_id">
						<h4 id="e_h4_id">아이디</h4>
						<div id="e_id_confirm" class="e_errorindex">*영문 소문자와 숫자를 혼합해
							5~9자리로 만들어주세요.</div>
						<input type="text" name="e_id" id="e_input_id"
							placeholder="아이디를 입력해 주세요." onfocus="this.placeholder=''"
							onblur="this.placeholder='아이디를 입력해 주세요.'">
					</div>

					<!-- 비밀번호 -->
					<div class="e_password">
						<h4 id="e_h4_pass">비밀번호</h4>
						<div id="e_pass_confirm" class="e_errorindex">*특수문자(!@#*),
							영문 대문자, 영문 소문자, 숫자 최소 한개 이상을 넣어 혼합해 5~9자리로 만들어주세요.</div>
						<input type="password" name="e_pw" id="e_input_pass"
							placeholder="비밀번호를 입력해 주세요." onfocus="this.placeholder=''"
							onblur="this.placeholder='비밀번호를 입력해 주세요.'">
					</div>

					<!-- 비밀번호 확인 -->
					<div class="e_password_more">
						<h4 id="e_h4_pass_more">비밀번호 확인</h4>
						<div id="e_pass_more_confirm" class="e_errorindex">*비밀번호가 맞지
							않습니다.</div>
						<input type="password" id="e_input_pass_more"
							placeholder="비밀번호를 다시 입력해 주세요." onfocus="this.placeholder=''"
							onblur="this.placeholder='비밀번호를 다시 입력해 주세요.'">
					</div>

					<!-- 이름 -->
					<div class="e_name">
						<h4 id="e_h4_name">이름</h4>
						<div id="e_name_confirm" class="e_errorindex">*이름을 입력해주세요.</div>
						<input type="text" name="e_name" id="e_input_name"
							placeholder="이름을 입력해 주세요." onfocus="this.placeholder=''"
							onblur="this.placeholder='이름을 입력해 주세요.'">
					</div>

					<!-- 생년월일 -->
					<div class="e_birth">
						<h4 id="e_h4_birth">생년월일</h4>
						<div id="e_birth_confirm" class="e_errorindex">*생년월일을
							입력해주세요.</div>
						<input type="text" name="e_birth" id="e_input_birth"
							placeholder="ex) 2000/06/29" onfocus="this.placeholder=''"
							onblur="this.placeholder='ex) 2000/06/29'">
					</div>

					<!-- 성별 -->
					<div class="e_gender">
						<h4 id="e_h4_gender">성별</h4>
						<div id="e_gender_confirm" class="e_errorindex">*성별을 선택해주세요.</div>
						<select name="e_gender" id="e_sel_gender">
							<option value="e_none">선택</option>
							<option value="e_female">여자</option>
							<option value="e_male">남자</option>
						</select>
					</div>

					<!-- 이메일 -->
					<div class="e_email">
						<h4>이메일</h4>
						<div id="e_email_confirm" class="e_errorindex">*이메일 형식이 맞지
							않습니다.</div>
						<input type="email" name="e_email" id="e_input_email"
							placeholder="ex) abc1234@gmail.com" onfocus="this.placeholder=''"
							onblur="this.placeholder='ex) abc1234@gmail.com'">
					</div>

					<!-- 전화번호 -->
					<div class="e_tel">
						<h4>전화번호</h4>
						<div id="e_tel_confirm" class="e_errorindex">*전화번호 형식이 맞지
							않습니다.</div>
						<input type="text" name="e_tel" id="e_input_tel"
							placeholder="ex) 010-1234-5678" onfocus="this.placeholder=''"
							onblur="this.placeholder='ex) 010-1234-5678'">
					</div>

					<!-- 회원가입 버튼 -->
					<div class="e_sub">
						<input type="submit" id="e_sub_btn" value="회원가입">
					</div>
			</div>
		</div>
		</form>
	</section>

</body>
<script src="join.js"></script>

</html>