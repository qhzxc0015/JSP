<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>手术麻醉管理系统</title>
<link rel="stylesheet" href="Style/css/bootstrap.min.css">
<script src="Style/js/jquery.min.js"></script>
<script src="Style/js/bootstrap.min.js"></script>
</head>
<script language="JavaScript">
	function mycheck() {
		if (isNull(form1.Type.value)) {
			alert("请选择身份！");
			return false;
		}
		if (isNull(form1.Username.value)) {
			alert("请输入登录账号！");
			return false;
		}
		if (isNull(form1.Password.value)) {
			alert("请输入密码！");
			return false;
		}

	}

	function isNull(str) {
		if (str == "")
			return true;
		var regu = "^[ ]+$";
		var re = new RegExp(regu);
		return re.test(str);
	}
</script>
<body background="./Images/bgp2.jpg">


	<center>

		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="page-header">
					<h1>手术麻醉管理系统</h1>
					<h1>
						<small>The Management System of Operation And Anesthesia</small>
					</h1>
				</div>
			</div>
		</div>

		<br>
		<br>
		<br>
		<br>
		<br>
		<table width="684" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="292" align="center" valign="top">
					<table width="350" height="201" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
						</tr>
						<tr>
							<td align="center" valign="top">
								<form name="form1" action="GoLogin.action" method="post"">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td height="30" colspan="2" align="center" class="STYLE2"><span
												style="color: red;"> <%
 	if (request.getAttribute("Msg") != null) {
 %>
													<%=request.getAttribute("Msg")%> <%
 	}
 %>
											</span></td>
										</tr>
										<tr>
											<td height="30" align="right" class="STYLE2">身份：</td>
											<td align="left"><select name="Type" id="Type"
												class="form-control">
													<option value="系统管理员">系统管理员</option>
													<option value="手术医师">手术医师</option>
													<!--   <option value="病人">病人</option> --> 
											</select></td>
										</tr>
										<tr>
											<td>&nbsp</td>
										</tr>
										<tr>
											<td width="37%" height="30" align="right" class="STYLE2">登录账号：</td>
											<td width="300" align="left"><input type="text"
												name="Username" id="Username" class="form-control" /></td>
										</tr>
										<tr>
											<td>&nbsp</td>
										</tr>
										<tr>
											<td height="30" align="right" class="STYLE2">密码：</td>
											<td align="left"><input type="password" name="Password"
												id="Password" class="form-control" /></td>
										</tr>
										<tr>
											<td>&nbsp</td>
										</tr>
										<tr>
											<td height="30" colspan="4" align="center"><label>
													<input type="submit" class="btn btn-default" name="button"
													id="button" value="&nbsp&nbsp&nbsp登&nbsp录&nbsp&nbsp&nbsp">
											</label></td>
										</tr>
									</table>
								</form>

							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>


	</center>
</body>
</html>
