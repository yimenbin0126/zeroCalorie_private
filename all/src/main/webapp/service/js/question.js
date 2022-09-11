window.onload = function(){
	site();
}

// 뷰 바꾸기
function site(){
	// 회원 정보 관리 클릭
	document.querySelector('#e_choice_mem').addEventListener('click', ()=>{
		document.querySelector('.e_con_mem').style.display = 'block';
		document.querySelector('.e_con_guide').style.display = 'none';
		document.querySelector('#e_choice_mem').style.color = 'white';
		document.querySelector('#e_choice_mem').style.backgroundColor = 'gray';
		document.querySelector('#e_choice_guide').style.color = 'black';
		document.querySelector('#e_choice_guide').style.backgroundColor = 'lightgray';
	});
	
	// 사이트 이용 가이드 클릭
	document.querySelector('#e_choice_guide').addEventListener('click', ()=>{
		document.querySelector('.e_con_guide').style.display = 'block';
		document.querySelector('.e_con_mem').style.display = 'none';
		document.querySelector('#e_choice_guide').style.color = 'white';
		document.querySelector('#e_choice_guide').style.backgroundColor = 'gray';
		document.querySelector('#e_choice_mem').style.color = 'black';
		document.querySelector('#e_choice_mem').style.backgroundColor = 'lightgray';
	});
}