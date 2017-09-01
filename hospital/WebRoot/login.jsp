<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!-- 
功能介绍：系统登录界面

 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>档案管理系统</title>
  <link rel="stylesheet" href="Style/css/bootstrap.min.css">  
   <script src="Style/js/jquery.min.js"></script>
   <script src="Style/js/bootstrap.min.js"></script>

<script type="text/javascript">
function commit() {
	if(form1.username.value=="") {
		alert("请您输入用户名！");
		form1.username.focus();
		return false;
	}
	if(form1.password.value=="") {
		alert("请您输入密码！");
		form1.password.focus();
		return false;
	}
	return true;
}
function checkname(obj)
{
		window.location.href="/hospital/register.jsp";
}
</script>
</head>
<body  background="./images/timg2.jpg">
<form action="user.do?mtype=checkUser" method="post" name="form1" onsubmit="return commit()">


 <table width="684" border="0" cellspacing="0" cellpadding="0" >
 <h1 class="text-center">Archives Management System</h1>
 <h1 class="text-center">
				档案管理系统
			</h1>
  <tr><td>&nbsp</td></tr>
    <tr><td>&nbsp</td></tr>
      <tr><td>&nbsp</td></tr>
        <tr><td>&nbsp</td></tr>
          <tr><td>&nbsp</td></tr>
            <tr><td>&nbsp</td></tr>
            <tr><td>&nbsp</td></tr>
                <tr><td>&nbsp</td></tr>
                    <tr><td>&nbsp</td></tr>
          </table>
<center>
<div class="container">
	<div class="row clearfix" >
		<div class="col-md-12 column">
			<form role="form" class="form-inline">
				<div class="form-group">
					 <label for="exampleInputEmail1">User name</label><input type="text" class="form-control" name="username" id= "username" style="width:300px"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" name="password" id="password" style="width:300px"/>
				</div>
				 <button type="submit" name="Submit2" class="btn btn-primary btn-large" style="width:150px">登录</button>
				 <button type="button" name="reset231" class="btn btn-primary btn-large" style="width:150px" onclick="checkname(this)">注册</button>
			</form>
		</div>
	</div>
</div>
		 <%
      if("error".equals((String)request.getAttribute("error"))){ %>
      	<div  class="alert alert-danger" style="width:300px">信息错误，请重新填写！</div>
      <%}%>
		
</center>




<!-- <table width="100%" border="0" cellspacing="0" cellpadding="0">
</table>
<center>
<fieldset style="width:562px;align=center">
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">帐	号&nbsp;&nbsp;&nbsp;<br /></td>
        <td width="69%"><input name="username" id= "username" type="text" size="28" style="width:150px" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密	码&nbsp;&nbsp;&nbsp;<br /></td>
        <td><input name="password" id="password" type="password" size="30" style="width:150px"/></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="submit" class="right-button02" value="登 录" />
          &nbsp;&nbsp;<input name="reset232" type="reset"" class="right-button02" value="重 置" />
          &nbsp;&nbsp;<input name="reset231" type="button" class="right-button02"  value="注册" onclick="checkname(this)" /></td>
      </tr>
      
      
    </table></td>
  </tr>
</table>
</fieldset>
</center>
-->

</form>
</body>
</html>