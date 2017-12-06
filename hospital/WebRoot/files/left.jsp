<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 
功能介绍：系统左边菜单栏

 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>档案管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(../images/left.gif);
}
-->
</style>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="../images/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<80;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="../images/ico06.gif";}//图片ico06为白色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="../images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="../images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="../images/ico04.gif";
	}
}

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="../images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="../images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02"><%=(String)session.getAttribute("realname") %></span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="/hospital/out_login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>
				
		<%if("0".equals((String)session.getAttribute("power"))){ %>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/user.do?mtype=preupdateUser&id=<%=(String)session.getAttribute("id") %>" target="mainFrame" class="left-font03" onClick="tupian('11');" >用户信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/case.do?mtype=queryCases" target="mainFrame" class="left-font03" onClick="tupian('11');" >机房管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/office.do?mtype=queryOffices" target="mainFrame" class="left-font03" onClick="tupian('12');" >电脑管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/user.do?mtype=queryDoctors" target="mainFrame" class="left-font03" onClick="tupian('12');" >管理员管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/message.do?mtype=queryMessages" target="mainFrame" class="left-font03" onClick="tupian('12');" >系统设置</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
     <!--   <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					 <tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/news.do?mtype=queryNewss" target="mainFrame" class="left-font03" onClick="tupian('12');" >医疗信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE> -->

        <%}%>
        <%if("1".equals((String)session.getAttribute("power"))){ %>    
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/user.do?mtype=preupdateUser&id=<%=(String)session.getAttribute("id") %>" target="mainFrame" class="left-font03" onClick="tupian('13');" >用户信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/case.do?mtype=queryCases" target="mainFrame" class="left-font03" onClick="tupian('11');" >档案管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/message.do?mtype=queryMessages" target="mainFrame" class="left-font03" onClick="tupian('12');" >留言板</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
       <!--   <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/news.do?mtype=queryNewss" target="mainFrame" class="left-font03" onClick="tupian('12');" >医疗信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>   -->              
        <%}%>
        <%if("2".equals((String)session.getAttribute("power"))){ %> 
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/user.do?mtype=preupdateUser&id=<%=(String)session.getAttribute("id") %>" target="mainFrame" class="left-font03" onClick="tupian('11');" >用户信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/case.do?mtype=queryCases" target="mainFrame" class="left-font03" onClick="tupian('11');" >档案查看</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
	 <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/user.do?mtype=queryDoctors" target="mainFrame" class="left-font03" onClick="tupian('12');" >档案填写</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/message.do?mtype=queryMessages" target="mainFrame" class="left-font03" onClick="tupian('12');" >留言板</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
     <!--    <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="25">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="/hospital/news.do?mtype=queryNewss" target="mainFrame" class="left-font03" onClick="tupian('12');" >医疗信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE> -->        
        <%}%>
	  </TD>
  </tr>
</table>
</body>
</html>
