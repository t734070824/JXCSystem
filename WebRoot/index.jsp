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

</head>
<body>
<div id="main_container">

	<div class="header">
    <div class="logo"><a href="#"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>
    
    <div class="right_header">Welcome <%=session.getAttribute("name") %> | <a href="logout.do" class="logout">Logout</a></div>
    <div class="jclock"></div>
    </div>
    
    <div class="main_content">
    
		<div class="menu">
		<ul>
			<li><a onclick="clickA(this);" alt="order_record_query.jsp">订单记录查询</a></li>
			<li><a onclick="clickA(this);" alt="product_storage.jsp">产品入库</a></li>
			<li><a onclick="clickA(this);" alt="stock_query.jsp">库存查询</a></li>
			<li><a onclick="clickA(this);" alt="product_sale.jsp">产品销售</a></li>
			<li><a onclick="clickA(this);" alt="stock_warn.jsp">库存报警</a></li>
			<li><a onclick="clickA(this);" alt="staff_management.jsp">员工管理</a></li>
			<li><a onclick="clickA(this);" alt="modify_password.jsp">修改密码</a></li>
		</ul>
		</div> 

    <div class="center_content">  

    <div class="left_content">
      <div class="sidebarmenu">
            
            <a class="menuitem submenuheader" href="">订单管理</a>
            <div class="submenu">
                    <ul>
                    <li><a onclick="clickA(this);" alt="order_product.jsp">订购产品</a></li>
                    <li><a onclick="clickA(this);" alt="order_record_query.jsp">订单记录查询</a></li>
                    </ul>
          </div>
                <a class="menuitem submenuheader" href="" >入库管理</a>
                <div class="submenu">
                    <ul>
                    <li><a onclick="clickA(this);" alt="product_storage.jsp">产品入库</a></li>
                    <li><a onclick="clickA(this);" alt="storage_record_query.jsp">入库记录查询</a></li>
                    <li><a onclick="clickA(this);" alt="Returns_records_query.jsp">退货记录查询</a></li>
                  </ul>
                </div>
                <a class="menuitem submenuheader" href="">库存信息</a>
                <div class="submenu">
                    <ul>
                    <li><a onclick="clickA(this);" alt="stock_query.jsp">库存查询</a></li>
                    <li><a onclick="clickA(this);" alt="stock_warn.jsp">库存报警</a></li>
                    <li><a onclick="clickA(this);" alt="shop_management.jsp">网点管理</a></li>
                    </ul>
                </div>
               <a class="menuitem submenuheader" href="">出库管理</a>
                <div class="submenu">
                    <ul>
                    <li><a onclick="clickA(this);" alt="product_out_storage.jsp">产品出库</a></li>
                    <li><a onclick="clickA(this);" alt="warehouse_out.jsp">出库记录查询</a></li>
                    <li><a onclick="clickA(this);" alt="product_sale.jsp">产品销售</a></li>
                    </ul>
                </div>
                    <a class="menuitem submenuheader" href="">员工信息</a>
                <div class="submenu">
                    <ul>
                    <li><a onclick="clickA(this);" alt="staff_management.jsp">员工管理</a></li>
                    <li><a onclick="clickA(this);" alt="add_staff.jsp">添加员工</a></li>
                    <li><a onclick="clickA(this);" alt="staff_birthday_remind.jsp">员工生日提醒</a></li>
                    </ul>
                </div>
                <a class="menuitem submenuheader" href="">客户管理</a>
                <div class="submenu">
                    <ul>
                    <li><a onclick="clickA(this);" alt="#">客户管理</a></li>
                    <li><a onclick="clickA(this);" alt="#">待定</a></li>
                    <li><a onclick="clickA(this);" alt="#">待定</a></li>
                    </ul>
                </div>
                <a class="menuitem submenuheader" href="">系统设置</a>
                <div class="submenu">
                    <ul>
                    <li><a onclick="clickA(this);" alt="add_manager.jsp">添加管理员</a></li>
                    <li><a onclick="clickA(this);" alt="modify_password.jsp">修改密码</a></li>
                    <li><a onclick="clickA(this);" alt="">产品管理</a></li>
                    <li><a onclick="clickA(this);" alt="class_management.jsp">类别管理</a></li>
                    </ul>
                </div>
        </div>
      <div class="sidebar_box">
        <div class="sidebar_box_bottom"></div>
      </div>
    </div>  
    
    <div class="right_content">            
    <iframe id='mainiFrame' src="order_product.html" width="100%" height=1000 frameborder="0" scrolling="no"></iframe>
    </div><!-- end of right content-->
  </div>   <!--end of center content -->               
                    
    <div class="clear"></div>
    </div> <!--end of main content-->
	
    
    <div class="footer">
    
    	<div class="left_footer">IN ADMIN PANEL | Powered by <a href="http://indeziner.com">INDEZINER</a></div>
    	<div class="right_footer"><a href="http://indeziner.com"><img src="images/indeziner_logo.gif" alt="" title="" border="0" /></a></div>
    
    </div>

</div>	
</body>
<script>
    function clickA(a){$('#mainiFrame').attr('src',$(a).attr('alt'));}
</script>
</html>