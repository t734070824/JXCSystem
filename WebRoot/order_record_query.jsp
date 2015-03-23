<%@page import="com.friday.model.Order"%>
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
<script language="JavaScript">
	/* 根据订单id获取订单详情 */
	function queryDetail(did) {
		var xmlHttp=new XMLHttpRequest();
		xmlHttp.open("GET", "querydetail.do?did="+did+"&table=order", true);				
		xmlHttp.onreadystatechange=function() {
		if (xmlHttp.readyState==4)
			result.innerHTML = xmlHttp.responseText;
		else
			result.innerHTML = "正在查询，请稍等";
		};
		xmlHttp.send();
	}
</script>
<script language="javascript" type="text/javascript" src="JS/niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="CSS/niceforms-default.css" />

</head>
<body bgcolor="transparent" style='background:transparent'>         
<table id="rounded-corner" summary="2007 Major IT Companies' Profit">
    <thead>
	<tr>
		<td colspan="5" align="left"><strong>订单记录查询</strong></td>
	</tr>
    <tr>
    	<td colspan="5" align="right">
       	<form action="queryorder.do" method="post">
        	  <label>开始时间：</label>
        	  <input name="starttime" type="text" id="textfield" size="5" onclick="WdatePicker()" />
        	  <label>结束时间:</label>
        	  <input name="endtime" type="text" id="textfield2" size="5" onclick="WdatePicker()" />
        	  <label>订单编号:</label>
        	  <input name="orderid" type="text" id="textfield3" size="5" />
        	  <label>订单状态:</label>
        	  <select name="orderstate">
        	  	<option value="2">所有类型</option>
        	  	<option value="0">未处理</option>
        	  	<option value="1">已入库</option>
        	  	<option value="-1">已退回</option>
        	  </select>
        	  <input type="submit" value="查询" />
       	</form>
       	</td>
     </tr>
        <tr>
        	<td width="61" align="center"><strong>订单编号</strong></td>
            <td width="50" align="center"><strong>订购时间</strong></td>
            <td width="64" align="center"><strong>经办人 </strong></td>
            <td width="85" align="center"><strong>合计金额</strong></td>
            <td width="64" align="center"><strong>状态</strong></td>
        </tr>
    </thead>
    <tfoot>
		 <tr>
			<td colspan="5" align="right">
			<div class="pagination">
				<form action="queryorder.do" method="post" style="display:none" name="hideform">
		       	  <input name="starttime" type="text" id="textfield" size="8" onclick="WdatePicker()" value="${starttime }"/>
		       	  <input name="endtime" type="text" id="textfield2" size="8" onclick="WdatePicker()" value="${endtime }"/>
		       	  <input name="orderid" type="text" id="textfield3" size="8" value="${orderid }"/>
		       	  <input name="orderstate" value="${orderstate }" />
		       	  <input type="submit" value="查询" />
		      	</form>
		      	<% 
		      		int pagecount = request.getAttribute("pagecount") == null ? 1 : (Integer)request.getAttribute("pagecount");
		      		int pagecurrent = request.getAttribute("pagecurrent") == null ? 0 : (Integer)request.getAttribute("pagecurrent");

		      		if (pagecurrent == 0) out.print("<span class=\"disabled\">prev</span>");
		      		else out.print("<a href=\"javascript:hideform.action='queryorder.do?page=" + String.format("%d", pagecurrent-1) +"';hideform.submit()\">prev</a>");
		      		for(int i=0; i < pagecount; i++) {
		      			if(i == pagecurrent) out.print("<span class=\"current\">" + String.format("%d", i+1) + "</span>");
		      			else out.print("<a href=\"javascript:hideform.action='queryorder.do?page=" + String.format("%d", i) +"';hideform.submit()\">" + String.format("%d", i+1) + "</a>");
		      		}
		      		if (pagecurrent == pagecount-1) out.print("<span class=\"disabled\">next</span>");
		      		else out.print("<a href=\"javascript:hideform.action='queryorder.do?page=" + String.format("%d", pagecurrent+1) +"';hideform.submit()\">next</a>");
		      	%>
			</div>
			</td>
		 </tr>
	</tfoot>
    <tbody>
    <c:forEach items="${result }" var="order">
    	<tr>
            <td align="center"><a href="javascript:queryDetail('${order.oId}')">${order.oId }</a></td>
            <td align="center">${order.date }</td>
            <td align="center">${order.user }</td>
            <td align="center">${order.price }</td>
            <td align="center">${order.style }</td>
        </tr>
     </c:forEach>
    </tbody>
</table>
<div id="result"></div>
</body>
</html>