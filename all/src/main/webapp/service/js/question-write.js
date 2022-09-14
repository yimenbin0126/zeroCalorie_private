window.onload = function(){
	form();
}

// 글쓰기 데이터 전달
function form(){

	var e_write_form = document.e_write_form;

	// 글쓰기 버튼 클릭
	document.querySelector('#e_btn_write_btn').addEventListener('click', ()=>{
		var selectbox = document.querySelector('#e_con_choice');
		var select_type = selectbox.options[selectbox.selectedIndex].value;
		document.querySelector('#e_choice_val').value = select_type;
		
		e_write_form.method="post";
		e_write_form.action="/service/question-write";
		e_write_form.submit();
	});
	
}