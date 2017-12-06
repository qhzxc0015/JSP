<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 主界面 -->
<link rel="stylesheet" href="Style/css/bootstrap.min.css">  
   <script src="Style/js/jquery.min.js"></script>
   <script src="Style/js/bootstrap.min.js"></script>
<table border="0" cellspacing="0" cellpadding="0">
           
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="list-group">
				 <a class="list-group-item active">系统选项</a>
				<div class="panel-body">
					<a class="btn" href="doctor_Index.jsp" >首页</a>
				</div>				
				
				<div class="panel-body">
					<a class="btn" href="StudentManager.action">手术管理</a>
				</div>				
				<div class="panel-body">
					<a class="btn" href="BuildingManager.action">麻醉药剂管理</a>
				</div>	
				
				<div class="panel-body">
					<a class="btn" href="DomitoryManager.action">麻醉使用管理</a>
				</div>				
				<div class="panel-body">
					<a class="btn" href="StudentRZ.action">病人手术登记</a>
				</div>	
				
				<div class="panel-body">
					<a class="btn" href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a>
				</div>				
				
			</div>
		</div>
	</div>

            
          </table>