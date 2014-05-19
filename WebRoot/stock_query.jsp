<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
});
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
<form action="stockquery.do" method="post">
  <table id="rounded-corner" summary="2007 Major IT Companies' Profit" width="623" border="0">
  	<tr>
		<td colspan="4" align="left"><strong>库存查询</strong></td>
	</tr>
          <tr>
            <td width="82" align="center">搜索：</td>
            <td width="88" align="center"><label for="select">
            <select name="sName" id="sName" >
            <c:forEach items="${shop}" var="shopName"> 
            <option value="${shopName.sId}">${shopName.sName}</option>
            </c:forEach>
              
              </select></label></td>
            <td colspan="4" align="left"><input type="submit" value="查询" style="font-size:16px" /></td>
            </tr>
         	<tr>
				<td colspan="4" align="center"><strong>${shopname}</strong></td>
			</tr>
          <tr>
            <td align="center">产品名称</td>
            <td width="79" align="center">规格</td>
            <td width="96" align="center">单价</td>
            <td width="70" align="center">库存数量</td>

          </tr>
         
          <c:forEach items="${stock }" var="productsMessage">
          <tr>
            <td align="center">${productsMessage.name}</td>
            <td align="center">${productsMessage.guige}</td>
            <td align="center">${productsMessage.price}</td>
            <td align="center">${productsMessage.num}</td>

          </tr>
          </c:forEach>
          
          <tr>
			<td colspan="4" align="right"><div class="pagination">
				<span class="disabled">prev</span><span class="current">1</span><span class="disabled">prev</span>
			</div></td>
		 </tr>
</table>
</form>
</body>
</html>