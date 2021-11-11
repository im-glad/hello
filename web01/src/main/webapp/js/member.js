function registerCheck(){
	if(document.frm.custname.value.length ==0){
		alert("회원성명이 입력되지 않았습니다.");
		frm.custname.focus();
		return false;
	}
		if(document.frm.phone.value.length ==0){
		alert("회원전화가 입력되지 않았습니다.");
		frm.phone.focus();
		return false;
	}
		if(document.frm.address.value.length ==0){
		alert("회원주소가 입력되지 않았습니다.");
		frm.address.focus();
		return false;
	}
	return alert("회원등록이 완료되었습니다.");
}
function modifyCheck(){
	if(document.frm.custname.value.length ==0){
		alert("회원성명이 입력되지 않았습니다.");
		frm.custname.focus();
		return false;
	}
		if(document.frm.phone.value.length ==0){
		alert("회원전화가 입력되지 않았습니다.");
		frm.phone.focus();
		return false;
	}
		if(document.frm.address.value.length ==0){
		alert("회원주소가 입력되지 않았습니다.");
		frm.address.focus();
		return false;
	}
	return alert("회원정보수정이 완료되었습니다.");
	
}