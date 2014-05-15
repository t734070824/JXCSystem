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