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

//添加员工时候的表单数据校验
function addstaffformcheck() {
	
	if (document.myform.name.value.trim() == "") {
		alert("姓名不能为空，请输入密码！");
		document.myform.name.focus();
		return false;
	}
	
	//去除单选框中所有选项，依次检查是否被选中。如果所有的选项都未被选中，那么提示需要选择性别。
	var radios = document.getElementsByName("sex");
	var tag = false;
	for(radio in radios) {
	   if(radios[radio].checked) {
	      tag = true;
	      break;
	   }
	}
	if(!tag) {
		alert("请选择员工性别！");
		return false;
	} 
	

	
	if (document.myform.phone.value.trim() == "") {
		alert("电话号码不能为空，请输入密码！");
		document.myform.phone.focus();
		return false;
	}
	
	if (document.myform.address.value.trim() == "") {
		alert("家庭住址不能为空！");
		document.myform.address.focus();
		return false;
	}
	
	if (document.myform.birthday.value.trim() == "") {
		alert("生日日期不能为空！");
		document.myform.birthday.focus();
		return false;
	}
	
	if (document.myform.price.value.trim() == "") {
		alert("工资不能为空！");
		document.myform.price.focus();
		return false;
	}
	
	var price = document.myform.price.value.trim();
	if(Number(price) && pareFloat(price))
		{
		;
		}
	else{
		alert("工资必须为数字！");
		document.myform.price.focus();
		return false;
	}
	
	var phone = document.myform.phone.value.trim();
	if(Number(phone) && pareInt(phone))
		{
		;
		}
	else{
		alert("请正确填写手机号码！");
		document.myform.phone.focus();
		return false;
	}
	

}