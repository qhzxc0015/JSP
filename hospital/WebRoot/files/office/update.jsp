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
功能介绍：修改部门管理

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
				if(document.mainForm.officename.value==""||document.mainForm.officename.value==null)
				{
					alert("不能为空！");
					document.mainForm.officename.focus();
					return false;
				}
				if(document.mainForm.scope.value==""||document.mainForm.scope.value==null)
				{
					alert("不能为空！");
					document.mainForm.scope.focus();
					return false;
				}
				if(document.mainForm.device.value==""||document.mainForm.device.value==null)
				{
					alert("不能为空！");
					document.mainForm.device.focus();
					return false;
				}
				if(document.mainForm.statertime.value==""||document.mainForm.statertime.value==null)
				{
					alert("不能为空！");
					document.mainForm.statertime.focus();
					return false;
				}
				return true;
		}
</script>
</head>

<body class="ContentBody">
  <form action="/hospital/office.do?mtype=updateOffice" method="post"  name="mainForm" id="mainForm" onSubmit="return checkValue()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门修改</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>部门信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">部门名称:</td>
					    <td width="35%"><span class="red">
				        <input name='officename' type="text" class="text" style="width:354px" value="${office.officename }"/>
				        <input name='id' type="hidden" class="text" style="width:354px" value="${office.id }"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">权限范围:</td>
					    <td width="35%"><span class="red">
				        <input name='scope' type="text" class="text" style="width:354px" value="${office.scope }"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">备注信息:</td>
					    <td width="35%"><span class="red">
				        <input name='device' type="text" class="text" style="width:354px" value="${office.device }"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">创建日期:</td>
					    <td width="35%"><span class="red">
				        <input name='statertime' type="text" class="text" style="width:354px" value="${office.statertime }"/>
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
