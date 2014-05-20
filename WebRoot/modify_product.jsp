<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<form name="myform"  action="addproduct.do">
 <table id="rounded-corner" summary="2007 Major IT Companies' Profit">
	<tr>
		<td colspan="6" align="left"><strong>添加产品</strong></td>
	</tr>
  <tr>
    <td width="112" align="right">产品名称</td>
    <td>
    <input name="pId" type="hidden" id="pId" size="20" value ="${product.pId }"/>
    <input name="pName" type="text" id="pName" size="20" value ="${product.pName }"/></td>
  </tr>
  <tr>
    <td align="right">产品类别</td>
    <td>
      <select name="tId">
	    	<c:forEach items="${types }" var="type">
	    		<c:choose>
	    		<c:when test="${type.tId == product.tId }">
	    			<option value="${type.tId }" selected="selected">${type.tType }</option>
	    		</c:when>
	    		<c:otherwise>
	    			<option value="${type.tId }" >${type.tType }</option>
	    		</c:otherwise>
	    		</c:choose>
	    	</c:forEach>
	      	</select>
</td>
  </tr>
  <tr>
    <td align="right">产品规格</td>
    <td><input name="pStyle" type="text" id="pStyle" size="20" value ="${product.pStyle }"/></td>
   </tr>
  <tr>
    <td align="right">产品价格</td>
    <td><input name="pPrice" type="text" id="pPrice" size="20" value ="${product.pPrice }"/></td>
  </tr>

  <tr>
    <td colspan="2" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="button1" id="button1" value="确认添加" />        &nbsp;&nbsp;&nbsp;&nbsp;          <input type="reset" name="button2" id="button2" value="重新填写" ></td>
    </tr>
</table>
</form>
</body>
</html>