<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>手术麻醉管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">


function mycheck(){
   
   if(isNull(form1.Student_Username.value)){  
   alert("请输入病人住院号！"); 
   return false;
   }

}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">手术麻醉管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">手术后麻醉检测</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="StudentQC.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="38%" height="30" align="right">&nbsp;</td>
                    <td width="62%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right" valign="top"><span style="color:red;">*</span>病人住院号：</td>
                    <td valign="top"><p>
                      <input name="Student_Username" type="text" id="Student_Username" size="40">
                    </p>
                      <p>&nbsp; </p></td>
                  </tr>
                  <tr>
                    <td height="30" align="right" valign="top">恢复记录：</td>
                    <td><p>
                      <textarea name="Student_Username2" cols="40" rows="4" id="Student_Username2"></textarea>
                    </p>
                      <p>&nbsp; </p></td>
                  </tr>
                  <tr>
                    <td height="30" align="right" valign="top">术后随访记录：</td>
                    <td><p>
                      <textarea name="Student_Username3" cols="40" rows="4" id="Student_Username3"></textarea>
                    </p>
                      <p>&nbsp; </p></td>
                  </tr>
                  <tr>
                    <td height="30" align="right" valign="top">医生叮嘱：</td>
                    <td><p>
                      <textarea name="Student_Username4" cols="40" rows="4" id="Student_Username4"></textarea>
                    </p>
                      <p>&nbsp; </p></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="reset" name="button" id="button" value="确定"></td>
                  </tr>
                </table>
              </form></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
