<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div id="j_hi">
        
        <!-- <img src="./img/logo.png" id="j_logo"> -->
        
        <ul id="j_list">
            <li class="j_menu1 j_menu">캘린더</li>
            <li class="j_menu2 j_menu">커뮤니티</li>
            <li class="j_menu3 j_menu">공지사항</li>
            <li class="j_menu4 j_menu">운동</li>
            <li class="j_menu5 j_menu" onclick="location.href='/all/service/allService'">고객센터</li>
        </ul>

        <div id = j_nav> 
            <input type ='button' class = "j_btn1 j_btn" onclick="location.href='../login/login.html'" value="로그인">
            <input type ='button' class = "j_btn2 j_btn" onclick="location.href='../mypage/mypage.html'" value="마이페이지">
            <input type ='button' class = "j_btn3 j_btn" onclick="location.href='/all/join'" value="회원가입">
        </div>
    </div>
