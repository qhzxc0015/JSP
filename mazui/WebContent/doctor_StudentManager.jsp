<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�����������ϵͳ</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">�����������ϵͳ</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left_index.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">��������</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="StudentManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> ���ܵ����� <a href="StudentAdd.jsp">�����������</a></td>
                    <td width="72%">��ѯ��
                      <select name="State" id="State">
                        <option value="δ����">δ����</option>
                        <option value="������">������</option>
                        <option value="��Ժ">��Ժ</option>
                      </select>
                      
                      <select name="SearchRow" id="SearchRow">
                        <option value="Student_Name">����</option>
                        <option value="Student_Username">סԺ��</option>
                        <option value="Student_Class">����</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="�����ѯ"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>סԺ��</strong></td>
                    <td bgcolor="#D5E4F4"><strong>��������</strong></td>
                    <td bgcolor="#D5E4F4"><strong>�Ա�</strong></td>
                    <td bgcolor="#D5E4F4"><strong>����</strong></td>
                    <td bgcolor="#D5E4F4"><strong>״̬</strong></td>
                    <td bgcolor="#D5E4F4"><strong>����</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Student_Username}</td>
                      <td>${Student_Name}</td>
                      <td>${Student_Sex}</td>
                      <td>${Student_Class}</td>
                      <td align="center">${Student_State}</td>
                      <td align="center"><a href="StudentUpdate.action?Student_ID=${Student_ID}">�޸�</a> <a href="StudentDel.action?Student_ID=${Student_ID}" onClick="return confirm('ȷ��Ҫɾ���ò�����')">ɾ��</a></td>
                    </tr>
                  </s:iterator>
                </table></td>
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
