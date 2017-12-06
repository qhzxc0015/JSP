<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 主界面 -->
<link rel="stylesheet" href="Style/css/bootstrap.min.css">  
   <script src="Style/js/jquery.min.js"></script>
   <script src="Style/js/bootstrap.min.js"></script>
   
<script language="JavaScript">
function subgo(){
	document.getElementById("div1").setAttribute(this.class,"list-group-item active");
    
   }
function test(obj){ 
	alert(obj); //[object HTMLInputElement] 
	alert(obj.id); //myinput 
	obj.className="list-group-item active";
	alert(obj.className); //javascript中onclick中的this 
	return obj.className;
	}
function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
</script>
   
   
   
<table border="0" cellspacing="0" cellpadding="0">
           
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="list-group">
				 <a class="list-group-item active">系统选项</a>
				<div class="panel-body">
					<a class="btn" id="div1" href="Index.jsp" >首页</a>
				</div>				
				<div class="panel-body">
					<a class="btn" href="TeacherManager.action" onclick="this.className='btn btn-primary btn-lg active'">手术医师管理</a>
				</div>	
				
				<div class="panel-body">
					<a class="btn" href="StudentManager.action" onclick="this.className='list-group-item active'">手术管理</a>
				</div>				
				<div class="panel-body">
					<a class="btn" href="BuildingManager.action" onclick="this.className='btn btn-primary btn-lg active'">麻醉药剂管理</a>
				</div>	
				
				<div class="panel-body">
					<a class="btn" href="DomitoryManager.action" onclick="this.className='btn btn-primary btn-lg active'">麻醉使用管理</a>
				</div>				
				<div class="panel-body">
					<a class="btn" href="StudentRZ.action" onclick="this.className='btn btn-primary btn-lg active'">病人手术登记</a>
				</div>	
				
				<div class="panel-body">
					<a class="btn" href="StudentTH.jsp" onclick="this.className='btn btn-primary btn-lg active'">麻醉调换</a>
				</div>		
				<div class="panel-body">
					<a class="btn" href="StudentQC.jsp" onclick="this.className='btn btn-primary btn-lg active'">术前的麻醉方案</a>
				</div>			
				<div class="panel-body">
					<a class="btn" href="OutList.action" onclick="this.className='btn btn-primary btn-lg active'">术后麻醉监测
</a>
				</div>	
				
				<div class="panel-body">
					<a class="btn" href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a>
				</div>				
				
			</div>
		</div>
	</div>

            
          </table>