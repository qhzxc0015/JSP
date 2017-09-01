<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-taip" prefix="taip"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 
功能介绍：用户管理信息

 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form name="mainForm" id="mainForm" method="post" action="/hospital/user.do?mtype=queryUsers">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
			<td >查看内容： 按用户名：<input type="text" name="searchname1" value="${searchname1 }" />           
              <input name="Submit" type="submit" class="right-button02" value="查 询" /></td>
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20"><font color="blue"  >用户管理</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
          	 </tr>
          	 <tr>
               <td height="10" valign="top" ><hr size="1" color="green" /></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" >
                
                  <tr>
                    <td  align="center" bgcolor="#EEEEEE">序列</td>
				    <td  align="center" bgcolor="#EEEEEE">登录名</td>
				    <td  align="center" bgcolor="#EEEEEE">密码</td>
				    <td  align="center" bgcolor="#EEEEEE">姓名</td>
				    <td  align="center" bgcolor="#EEEEEE">年龄</td>
				    <td  align="center" bgcolor="#EEEEEE">性别</td>
				    <td  align="center" bgcolor="#EEEEEE">身份证号</td>
                    <td  align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <c:forEach items="${pageinfo.datas}" var="list" varStatus="i">
	                  <tr>
	                    <td bgcolor="#FFFFFF"  height="20" align="center" >${i.index+1 }</td>
	                    <td bgcolor="#FFFFFF"  align="center">${list.username }</td>
					    <td bgcolor="#FFFFFF"  align="center">${list.password }</td>
					    <td bgcolor="#FFFFFF"  align="center">${list.realname }</td>	
					    <td bgcolor="#FFFFFF"  align="center">${list.age }</td>	
					    <td bgcolor="#FFFFFF"  align="center">${list.sex }</td>
					    <td bgcolor="#FFFFFF"  align="center">${list.seeid }</td>
					    <td bgcolor="#FFFFFF"  align="center"><a href="/hospital/user.do?mtype=delUser&id=${list.id }">删除</a></td>
	                  </tr>
	               </c:forEach>
                </table></td>
              </tr>
              <tr>
              	<td>
              	<jsp:include flush="true" page="../../pagetag.jsp"></jsp:include>
              	</td>
              </tr>
            </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
