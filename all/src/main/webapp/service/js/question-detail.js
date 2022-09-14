window.onload = function(){
	form();
}

// 뷰 데이터 전달
function form(){


	// 관리자 접속 시, 버튼 보이게 하기
	if (document.querySelector('#e_hidden_YN') == "Y"){
		document.querySelector('.e_hidden').style.display = "block";
	} else {
		document.querySelector('.e_hidden').style.display = "none";
	}
	
	// 버튼 클릭
	if(document.querySelector('.e_hidden').style.display == "block") {
		var e_btn_fix_form = document.e_btn_fix_form;
		var e_btn_delete_form = document.e_btn_delete_form;

		// 글 수정 버튼
		document.querySelector('#e_btn_fix').addEventListener('click', ()=>{
			var result_fix = confirm("게시물을 수정하시겠습니까?");
			if(result_fix == true){
				e_btn_fix_form.method="post";
				e_btn_fix_form.action="/service/question-detail";
				e_btn_fix_form.submit();
			}
		});
		
		// 글 삭제 버튼
		document.querySelector('#e_btn_delete').addEventListener('click', ()=>{
			var result_delete = confirm("게시물을 삭제하시겠습니까?");
			if(result_delete == true){
				e_btn_delete_form.method="post";
				e_btn_delete_form.action="/service/question-detail";
				e_btn_delete_form.submit();
			}
		});
	}
	
}