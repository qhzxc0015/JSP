<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
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
				if(document.mainForm.casename.value==""||document.mainForm.casename.value==null)
				{
					alert("不能为空！");
					document.mainForm.casename.focus();
					return false;
				}
				return true;
		}
</script>
</head>

<body class="ContentBody">
  <form action="/hospital/case.do?mtype=addCase" method="post"  name="mainForm" id="mainForm" onSubmit="return checkValue()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;档案填写</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>档案信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">信息:</td>
					    <td width="35%"><span class="red">
					    <textarea rows="4" cols="50" name='casename' ></textarea>
					    <input type="hidden" name="doctor" value="<%=request.getParameter("doctor") %>">
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
