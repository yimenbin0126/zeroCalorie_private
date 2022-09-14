window.onload = function(){
	site();
}

// 뷰 바꾸기
function site(){

	var choiceform = document.e_hd_choice_form;

	// 회원 정보 관리 클릭
	document.querySelector('#e_choice_mem').addEventListener('click', ()=>{
		// css 변경
		document.querySelector('.e_con_mem').style.display = 'block';
		document.querySelector('.e_con_guide').style.display = 'none';
		document.querySelector('#e_choice_mem').style.color = 'white';
		document.querySelector('#e_choice_mem').style.backgroundColor = 'gray';
		document.querySelector('#e_choice_guide').style.color = 'black';
		document.querySelector('#e_choice_guide').style.backgroundColor = 'lightgray';
		document.querySelector('#e_hd_choice_LR').value = "L";
	});
	
	// 사이트 이용 가이드 클릭
	document.querySelector('#e_choice_guide').addEventListener('click', ()=>{
		// css 변경
		document.querySelector('.e_con_guide').style.display = 'block';
		document.querySelector('.e_con_mem').style.display = 'none';
		document.querySelector('#e_choice_guide').style.color = 'white';
		document.querySelector('#e_choice_guide').style.backgroundColor = 'gray';
		document.querySelector('#e_choice_mem').style.color = 'black';
		document.querySelector('#e_choice_mem').style.backgroundColor = 'lightgray';
		document.querySelector('#e_hd_choice_LR').value = "R";
	});
	
	// 카데고리 선택
	if (document.querySelector('#e_hd_choice_LR').value == "L"){
		choiceform.submit();
	}
	
	if (document.querySelector('#e_hd_choice_LR').value == "R"){
		choiceform.submit();
	}
}