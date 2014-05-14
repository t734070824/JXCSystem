<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>IN ADMIN PANEL | Powered by INDEZINER</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="JS/jquery.min.js"></script>
<script type="text/javascript" src="JS/ddaccordion.js"></script>
<script type="text/javascript">
ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='images/plus.gif' class='statusicon' />", "<img src='images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})
</script>
<script src="JS/jquery.jclock-1.2.0.js.txt" type="text/javascript"></script>
<script type="text/javascript" src="JS/jconfirmaction.jquery.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$('.ask').jConfirmAction();
	});
	
</script>
<script type="text/javascript">
$(function($) {
    $('.jclock').jclock();
});
</script>

<script language="javascript" type="text/javascript" src="JS/niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="CSS/niceforms-default.css" />

</head>
<body>
   <table id="rounded-corner" summary="2007 Major IT Companies' Profit">
    <tr>
		<td colspan="7" align="left"><strong>添加员工</strong></td>
	</tr>
  <tr>
    <td colspan="3">注：</td>
    </tr>
  <tr>
    <td width="111" align="right"><strong>员工姓名：</strong></td>
    <td colspan="2"><form id="form1" name="form1" method="post" action="">
      <label for="textfield"></label>
      <input type="text" name="textfield" id="textfield" />
    </form></td>
  </tr>
  <tr>
    <td align="right"><strong>员工性别：</strong></td>
    <td colspan="2"><form id="form2" name="form2" method="post" action="">
      <p>
        <label>
          <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_0" />
          男</label>
        <label>
          <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" />
         女</label>
        <br />
      </p>
    </form></td>
  </tr>
  <tr>
    <td align="right"><strong>联系电话：</strong></td>
    <td colspan="2"><form id="form3" name="form3" method="post" action="">
      <label for="textfield2"></label>
      <input type="text" name="textfield2" id="textfield2" />
    </form></td>
  </tr>
  <tr>
    <td align="right"><strong>家庭住址：</strong></td>
    <td colspan="2"><form id="form4" name="form4" method="post" action="">
      <label for="textfield3"></label>
      <input type="text" name="textfield3" id="textfield3" />
    </form></td>
  </tr>
  <tr>
    <td align="right"><strong>身份证号：</strong></td>
    <td colspan="2"><form id="form5" name="form5" method="post" action="">
      <label for="textfield4"></label>
      <input type="text" name="textfield4" id="textfield4" />
    </form></td>
  </tr>
  <tr>
    <td align="right"><strong>员工生日：</strong></td>
    <td width="182"><form id="form6" name="form6" method="post" action="">
      <label for="textfield5"></label>
      <input type="text" name="textfield5" id="textfield5" />
    </form></td>
    <td width="316" align="left" ><a href="">＊点击文本框获取时间</a></td>
  </tr>
  <tr>
    <td align="right"><strong>员工工资：</strong></td>
    <td colspan="2"><form id="form7" name="form7" method="post" action="">
      <label for="textfield6"></label>
      <input type="text" name="textfield6" id="textfield6" />
    </form></td>
  </tr>
  <tr>
    <td align="right"><strong>备注</strong></td>
    <td colspan="2"><form id="form8" name="form8" method="post" action="">
      <label for="textfield7"></label>
      <input type="text" name="textfield7" id="textfield7" />
    </form></td>
  </tr>
  <tr>
    <td align="right">&nbsp;</td>
    <td colspan="2"><form id="form9" name="form9" method="post" action="">
      <input type="submit" name="button" id="button" value="确认添加" />&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" value="重新填写"/>
    </form></td>
  </tr>
</table>
</body>
</html>