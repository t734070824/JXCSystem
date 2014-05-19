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

</head>
<body bgcolor="transparent" style='background:transparent'>
 <table id="rounded-corner" summary="2007 Major IT Companies' Profit">
  <tr>
		<td colspan="8" align="left"><strong>产品管理</strong></td>
	</tr>
  <tr>
    <td colspan="8">添加产品&nbsp;&nbsp;&nbsp;&nbsp;<a href="add_shop.html"><img src="images/plus.gif" alt="" title="" border="0" /></a></td>
    </tr>
  <!-- <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="right">产品名称：</td>
    <td colspan="2"> <input name="textfield" type="text" id="textfield" size="20" /></td>
    <td><a href="">查询</a></td>
    </tr> -->
  <tr align="center">
<!--     <td width="66" align="center">产品编号</td> -->
    <td width="114" align="center">产品名称</td>
    <td width="40" align="center">规格</td>
    <td width="70" align="center">类别</td>
    <td width="89" align="center">进货单价</td>
    <td width="100" align="center">金额</td>
    <td width="54" align="center">修改</td>
    <td width="78" align="center">删除</td>
  </tr>
   <c:forEach items="${result}" var="product">
  <tr>
    <td align="center">${product.pName }</td>
    <td align="center">${product.pStyle }</td>
    <td align="center">${product.typename }</td>
    <td align="center">${product.pPrice }</td>
    <td align="center">${product.pZt }</td>
    <td align="center"><a href="XXX.do?typename=${product.pId }" ><img src="images/user_edit.png" width="16" height="16" /></a></td>
    <td align="center">
    <a href="deleteproduct.do?pid=${product.pId }" class="ask"><img src="images/trash.png" alt="" title="" border="0" /></a>
   <%--  <a href="deleteproduct.do?pid=${product.pId }"><img src="images/user_logout.png" width="16" height="16" /></a> --%>
   </td>
  </tr>
 </c:forEach>
  <!-- <tr>
    <td colspan="8" align="right"><div class="pagination">
        <span class="disabled"><< prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>…<a href="">10</a><a href="">11</a><a href="">12</a>...<a href="">100</a><a href="">101</a><a href="">next >></a>
        </div></td>
    </tr>
    <tr>
    <td colspan="5"><font color="green">注</font>：蓝色为普通品 <font color="red">红色为新品</font> <font color="green">绿色为促销品</font></td>
    <td align="right"><input type="checkbox" name="" />全选</td>
     <td colspan="2"><input type="submit" name="button" id="button" value="删除" /></td>
    </tr> -->
</table>
</body>
</html>