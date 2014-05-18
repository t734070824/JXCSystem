<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<title>IN ADMIN PANEL | Powered by INDEZINER</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="JS/jquery.min.js"></script>
<script type="text/javascript" src="JS/ddaccordion.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
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
});
</script>
<script type="text/javascript">
function docheck()
{
       alert("产品已出库!");
}
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

</head>
<body bgcolor="transparent" style='background:transparent'>
<form action="stockout.do" method="post">
 <table id="rounded-corner" summary="2007 Major IT Companies' Profit">
   	<tr>
		<td colspan="4" align="left"><strong>产品出库</strong></td>
	</tr>
  	<tr>
    	<td align="right">出库网点</td>
	    <td colspan="3">
	    	<select name="shopid">
	    	<c:forEach items="${shops }" var="shop">
	    		<option value="${shop.sId }">${shop.sName }</option>
	    	</c:forEach>
	      	</select>
	    </td>
  	</tr>
  	<tr>
	    <td align="center">产品名称</td>
	    <td align="center">产品数量</td>
	    <td align="center">产品价格</td>
	    <td align="center">出库数量</td>
	</tr>
	<c:forEach items="${products }" var="product">
	<tr>
	    <td align="center"><input type="text" size="10" value="${product.name }" readonly /></td>
	    <td align="center"><input type="text" size="10" value="${product.num }" readonly /></td>
	    <td align="center"><input type="text" size="10" value="${product.price }" readonly /></td>
	    <td align="center"><input type="text" size="10" name="${product.pid }" onKeyUp="this.value=this.value.replace(/\D/g,'')" /></td>
	</tr>
	</c:forEach>
	<tr>
	    <td align="right">出库时间</td>
	    <td><input name="outtime" type="text" size="20" onclick="WdatePicker()"/></td>
	    <td align="left" colspan="2">＊点击文本框获取时间</td>
	</tr>
	<tr>
	    <td align="right">备注</td>
	    <td colspan="3"><input name="remark" type="text" size="20" /></td>
	</tr>
	<tr>
	    <td colspan="4" align="center">
	    	<input type="submit" value="确认出库" />
	    	<input type="reset" value="重新填写" />
	    </td>
	</tr>
</table>
</form>
</body>
</html>