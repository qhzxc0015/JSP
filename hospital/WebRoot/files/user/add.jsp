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
功能介绍：添加

 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
<%
if(request.getParameter("flag")!=null&&"success".equals(request.getParameter("flag"))){
	response.getWriter().println("<script>alert('添加成功!');</script>");
}
%>
<script type="text/javascript">
		function checkValue(){
				if(document.mainForm.username.value==""||document.mainForm.username.value==null)
				{
					alert("不能为空！");
					document.mainForm.username.focus();
					return false;
				}
				if(document.mainForm.password.value==""||document.mainForm.password.value==null)
				{
					alert("不能为空！");
					document.mainForm.password.focus();
					return false;
				}
				if(document.mainForm.realname.value==""||document.mainForm.realname.value==null)
				{
					alert("不能为空！");
					document.mainForm.realname.focus();
					return false;
				}
				if(document.mainForm.sex.value==""||document.mainForm.sex.value==null)
				{
					alert("不能为空！");
					document.mainForm.sex.focus();
					return false;
				}
				if(document.mainForm.love.value==""||document.mainForm.love.value==null)
				{
					alert("不能为空！");
					document.mainForm.love.focus();
					return false;
				}
				if(document.mainForm.working.value==""||document.mainForm.working.value==null)
				{
					alert("不能为空！");
					document.mainForm.working.focus();
					return false;
				}				
				return true;
		}
</script>
</head>

<body class="ContentBody">
  <form action="/hospital/user.do?mtype=addUser" method="post"  name="mainForm" id="mainForm" onSubmit="return checkValue()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户注册</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>用户信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">登录名称:</td>
					    <td width="35%"><span class="red">
				        <input name='username' type="text" class="text" style="width:354px" value=""/>
				        <input name='status' type="hidden" class="text" style="width:354px" value="1"/>
				        *</span>${errormessage }
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">登录密码:</td>
					    <td width="35%"><span class="red">
				        <input name='password' type="password" class="text" style="width:354px" value=""/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">姓名:</td>
					    <td width="35%"><span class="red">
				        <input name='realname' type="text" class="text" style="width:354px" value=""/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">性别:</td>
					    <td width="35%"><span class="red">
					    <select name="sex">
					    	<option value="男">男</option>
					    	<option value="女">女</option>
					    </select>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">年龄:</td>
					    <td width="35%"><span class="red">
				        <input name='age' type="text" class="text" style="width:354px" value=""/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">部门:</td>
					    <td width="35%"><span class="red">
				        <select name="office">
				        	<c:forEach items="${officelist}" var="l">
				        	<option value="${l.officename }" > ${l.officename }</option>
				        	</c:forEach>
				        </select>
				        *</span>
				        </td>
					  </tr>	
					  <tr>
					    <td align="right" width="19%">职称:</td>
					    <td width="35%"><span class="red">
				        <input name='work' type="text" class="text" style="width:354px" value=""/>
				        *</span>
				        </td>
					  </tr>				  
					  </table>
			  <br />
				</fieldset>			
			</td>
		</tr>
		</table>
	 </td>
  </tr>
	<tr>
		<td colspan="2" align="center" height="50px">
		<input type="submit" name="submitbut" value="保存" class="button" />　
		
		<input type="reset" name="reset" value="重置" class="button"  />
		</td>
	</tr>
</table>
</div>
</form>
</body>
</html>
