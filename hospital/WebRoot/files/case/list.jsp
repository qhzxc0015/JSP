<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
功能介绍：档案管理管理

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
<form name="mainForm" id="mainForm" method="post" action="/hospital/case.do?mtype=queryCases">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
			<td >查看内容： 按用户姓名：<input type="text" name="searchname1" value="${searchname1 }" /> 
			  按管理员姓名：<input type="text" name="searchname2" value="${searchname2 }" /> 
			  按信息：<input type="text" name="searchname3" value="${searchname3 }" />          
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
               <td height="20"><font color="blue"  >档案管理</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
          	 </tr>
          	 <tr>
               <td height="10" valign="top" ><hr size="1" color="green" /></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" >
                
                  <tr>
                    <td  align="center" bgcolor="#EEEEEE">序列</td>
                    <td  align="center" bgcolor="#EEEEEE">档案信息</td>
                    <td  align="center" bgcolor="#EEEEEE">创建日期</td>
				    <td  align="center" bgcolor="#EEEEEE">用户</td>
				    <td  align="center" bgcolor="#EEEEEE">管理人</td>
				    <td  align="center" bgcolor="#EEEEEE">归档状态</td>
					<td  align="center" bgcolor="#EEEEEE">备注</td>
                  </tr>
                  <c:forEach items="${pageinfo.datas}" var="list" varStatus="i">
	                  <tr>
	                    <td bgcolor="#FFFFFF"  height="20" align="center" >${i.index+1 }</td>
	                    <td bgcolor="#FFFFFF"  align="center">${list.casename }</td>
	                    <td bgcolor="#FFFFFF"  align="center">${list.inputdate }</td>
	                    <td bgcolor="#FFFFFF"  align="center">${list.userid }</td>
	                    <td bgcolor="#FFFFFF"  align="center">${list.doctor }</td>
	                    <td bgcolor="#FFFFFF"  align="center">
	                    	<c:if test="${list.status=='0' }">未归档</c:if>
	                    	<c:if test="${list.status=='1' }">已归档</c:if>
	                    </td>
						<td bgcolor="#FFFFFF"  align="center">
<c:if test="${power==0}"><a href="/hospital/case.do?mtype=delCase&id=${list.id }">删除</a></c:if>
<c:if test="${list.status=='0' }">
<c:if test="${power==1}"><a href="/hospital/case.do?mtype=saveCase&id=${list.id }">归档</a></c:if>
</c:if>
						</td>
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
