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
    <thead>
	<tr>
		<td colspan="7" align="left"><strong>本月员工生日提醒</strong></td>
	</tr>
    	<tr>
    	  <td width="123" align="center"><strong>姓名</strong></td>
    	  <td width="126" align="center"><strong>部门</strong></td>
    	  <td width="79" align="center"><strong>生日</strong></td>
    	  <td align="center">祝福发送至</td>
    	  </tr>
    </thead>
    <tbody>
    	<tr>
        	<td align="center">lwr</td>
            <td align="center">XXX</td>
            <td align="center">XXX-XX-XX</td>
            <td align="center">XXX-XX-XX999999</td>
        </tr>
    	<tr>
    	  <td align="center">jlj</td>
            <td align="center">XXX</td>
            <td align="center">XXX-XX-XX</td>
            <td align="center">XXX-XX-XX999999</td>
  	    </tr>
        <tr>
    	  <td align="center">dyh</td>
            <td align="center">XXX</td>
            <td align="center">XXX-XX-XX</td>
            <td align="center">XXX-XX-XX999999</td>
  	    </tr>
        <tr>
    	  <td align="center">csy</td>
            <td align="center">XXX</td>
            <td align="center">XXX-XX-XX</td>
            <td align="center">XXX-XX-XX999999</td>
  	    </tr>
        <tr>
    	  <td align="center">cxw</td>
            <td align="center">XXX</td>
            <td align="center">XXX-XX-XX</td>
            <td align="center">XXX-XX-XX999999</td>
  	    </tr>
        <tr>
    	  <td align="center">sh</td>
            <td align="center">XXX</td>
            <td align="center">XXX-XX-XX</td>
            <td align="center">XXX-XX-XX999999</td>
  	    </tr>
       <tr>
			<td colspan="8" align="right"><div class="pagination">
				<span class="disabled"><< prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>…<a href="">10</a><a href="">11</a><a href="">12</a>...<a href="">100</a><a href="">101</a><a href="">next >></a>
			</div></td>
		 </tr>
    </tbody>
</table>
</body>
</html>