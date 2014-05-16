//添加新用户的表单确认
function formcheck() {
	if (document.myform.account.value.trim() == "") {
		alert("用户名不能为空，请输入用户名！");
		document.myform.account.focus();
		return false;
	}
	
	if (document.myform.password.value.trim() == "") {
		alert("密码不能为空，请输入密码！");
		document.myform.password.focus();
		return false;
	}
	
	if (document.myform.password2.value.trim() == "") {
		alert("密码不能为空，请输入密码！");
		document.myform.password2.focus();
		return false;
	}
	
	if (document.myform.password2.value.trim() != document.myform.password.value.trim()) {
		alert("两次密码输入不一致，请重新输入密码！");
		document.myform.password2.focus();
		return false;
	}
	
	if (document.myform.name.value.trim() == "") {
		alert("姓名不能为空，请输入密码！");
		document.myform.password.focus();
		return false;
	}
}

//修改密码的表单确认
function modifypwdformcheck() {
	
	if (document.myform.password.value.trim() == "") {
		alert("原密码不能为空，请输入密码！");
		document.myform.password.focus();
		return false;
	}
	
	if (document.myform.newpassword.value.trim() == "") {
		alert("新密码不能为空，请输入密码！");
		document.myform.newpassword.focus();
		return false;
	}
	
	if (document.myform.newpassword2.value.trim() == "") {
		alert("请确认密码！");
		document.myform.newpassword2.focus();
		return false;
	}
	
	if (document.myform.newpassword.value.trim() != document.myform.newpassword2.value.trim()) {
		alert("两次密码输入不一致，请重新输入密码！");
		document.myform.newpassword2.focus();
		return false;
	}
	
	if (document.myform.newpassword.value.trim() == document.myform.password.value.trim()) {
		alert("新密码与原有密码一致，请重新输入新密码！");
		document.myform.newpassword.focus();
		return false;
	}
	
}