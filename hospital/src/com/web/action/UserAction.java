package com.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.TUser;
import com.service.TOfficeService;
import com.service.TUserService;
import com.util.PageInfo;
import com.util.SimpleBaseAction;
import com.web.form.TUserForm;

/**
 * 
 *
 * 功能：用户信息
 *
 */
public class UserAction extends SimpleBaseAction {
	private TUserService tUserService;
	private TOfficeService officeService;
	public TUserService getTUserService() {
		return tUserService;
	}
	public void setTUserService(TUserService userService) {
		tUserService = userService;
	}

	public TOfficeService getOfficeService() {
		return officeService;
	}
	public void setOfficeService(TOfficeService officeService) {
		this.officeService = officeService;
	}
	/**
	 * 
	 *
	 * 功能：用户信息
	 *
	 */
	public ActionForward checkUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
			if(name!=null&&pwd!=null)
			{
				List<TUser>  users = this.getTUserService().checkUser(name,pwd);
				if(users.size()<1)
				{		
						request.setAttribute("error","error");
						return mapping.findForward("error");
				}else{
					TUser user = users.get(0);
					request.getSession().setAttribute("user",user);
					request.getSession().setAttribute("realname",user.getRealname());
					request.getSession().setAttribute("username",user.getUsername());
					request.getSession().setAttribute("power",user.getPower());
					request.getSession().setAttribute("id",String.valueOf(user.getId()));
					return mapping.findForward("success");
				}
			}
			return null;
	}
	/**
	 * 
	 *
	 * 功能：分页查信息
	 *
	 */
	@SuppressWarnings("unchecked")
	public ActionForward queryUsers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TUserForm userForm = (TUserForm)form; 
		if (request.getSession().getAttribute("querypageunit") == null) {
			request.getSession().setAttribute("querypageunit",
					this.pageunit);
		}
		StringBuffer cond = new StringBuffer();
		if(null!=request.getParameter("searchname1")&&""!=request.getParameter("searchname1").trim()){
			cond.append(" and a.username like '%"+request.getParameter("searchname1").trim()+"%' ");
		}
		int curpage = this.getCurrentpage(request);
		int pageunit = this.getPageunit(request, "querypageunit");

		String url = "./user.do?mtype=queryUsers";
		cond.append(" and a.power=2 ");
		PageInfo pageInfo = this.getTUserService().queryUser(curpage,
				pageunit, request, url, cond.toString());
		request.setAttribute("pageinfo", pageInfo);
		request.setAttribute("searchname1", request.getParameter("searchname1"));
		return mapping.findForward("queryUsers");
	}
	/**
	 * 
	 *
	 * 功能：分页查信息
	 *
	 */
	@SuppressWarnings("unchecked")
	public ActionForward queryDoctors(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TUserForm userForm = (TUserForm)form; 
		if (request.getSession().getAttribute("querypageunit") == null) {
			request.getSession().setAttribute("querypageunit",
					this.pageunit);
		}
		StringBuffer cond = new StringBuffer();
		if(null!=request.getParameter("searchname1")&&""!=request.getParameter("searchname1").trim()){
			cond.append(" and a.username like '%"+request.getParameter("searchname1").trim()+"%' ");
		}
		if(null!=request.getParameter("searchname2")&&""!=request.getParameter("searchname2").trim()){
			cond.append(" and a.realname like '%"+request.getParameter("searchname2").trim()+"%' ");
		}
		if(null!=request.getParameter("searchname3")&&""!=request.getParameter("searchname3").trim()){
			cond.append(" and a.office like '%"+request.getParameter("searchname3").trim()+"%' ");
		}
		int curpage = this.getCurrentpage(request);
		int pageunit = this.getPageunit(request, "querypageunit");

		String url = "./user.do?mtype=queryDoctors";
		cond.append(" and a.power=1 ");
		PageInfo pageInfo = this.getTUserService().queryUser(curpage,
				pageunit, request, url, cond.toString());
		request.setAttribute("officelist", officeService.queryTOffice(""));
		request.setAttribute("pageinfo", pageInfo);
		request.setAttribute("searchname1", request.getParameter("searchname1"));
		request.setAttribute("searchname2", request.getParameter("searchname2"));
		request.setAttribute("searchname3", request.getParameter("searchname3"));
		return mapping.findForward("queryDoctors");
	}
	
	
	
	/**
	 * 
	 *
	 * 功能：预添加
	 *
	 */
	public ActionForward preAddDoctor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		request.setAttribute("officelist", officeService.queryTOffice(""));
		
		return mapping.findForward("preAddDoctor");
	}
	/**
	 * 
	 *
	 * 功能：添加
	 *
	 */
	public ActionForward addUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TUserForm userForm = (TUserForm) form;

		
		
		String url = "";
		TUser user = new TUser();
		user.setAge(userForm.getAge());
		user.setSex(userForm.getSex());
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		user.setRealname(userForm.getRealname());
		if("0".equals((String)request.getSession().getAttribute("power"))){
			user.setPower("1");
			user.setWork(userForm.getWork());
			user.setOffice(userForm.getOffice());
		}else{
			user.setCaseid(userForm.getCaseid());
			user.setPricetype(userForm.getPricetype());
			user.setSeeid(userForm.getSeeid());
			user.setPower("2");
		}
		int i = this.getTUserService().checkUser(userForm.getUsername());
		if(i==0){
			this.getTUserService().addUser(user);
				
			if("0".equals((String)request.getSession().getAttribute("power"))){
					url = "addDoctor";
				}else{
					url = "addUser";
				}
		}else{
			request.setAttribute("errormessage", "内容已经存在，请更换");
			if("0".equals((String)request.getSession().getAttribute("power"))){
				url = "errorDoctor";
			}else{
				url = "errorUser";
			}
				
		}
		
		return mapping.findForward(url);

	}
	/**
	 * 
	 *
	 * 功能：预修改
	 *
	 */
	public ActionForward preupdateUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TUser user = this.getTUserService().getUser(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("user", user);
		String url = "";
		if("0".equals((String)request.getSession().getAttribute("power"))){
			url = "preupdateAdmin";
		}else if("1".equals((String)request.getSession().getAttribute("power"))){
			url = "preupdateDoctor";
		}else{
			url = "preupdateUser";
		}
		return mapping.findForward(url);
	}
	
	/**
	 * 
	 *
	 * 功能：修改
	 *
	 */
	public ActionForward updateUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TUserForm userForm = (TUserForm) form;
		
		TUser user = this.getTUserService().getUser(userForm.getId());
		
		user.setSex(userForm.getSex());
		user.setPassword(userForm.getPassword());
		user.setRealname(userForm.getRealname());
		if("1".equals((String)request.getSession().getAttribute("power"))){
			user.setPower("1");
			user.setWork(userForm.getWork());
			user.setOffice(userForm.getOffice());
			user.setAge(userForm.getAge());
		}else if("2".equals((String)request.getSession().getAttribute("power"))){
			user.setAge(userForm.getAge());
			user.setCaseid(userForm.getCaseid());
			user.setPricetype(userForm.getPricetype());
			user.setSeeid(userForm.getSeeid());
			user.setPower("2");
		}
		this.getTUserService().modifyUser(user);

		request.getSession().setAttribute("user",user);
		request.getSession().setAttribute("realname",user.getRealname());
		request.getSession().setAttribute("username",user.getUsername());
		request.getSession().setAttribute("power",user.getPower());
		return mapping.findForward("updateUser");
		
	}
	/**
	 * 
	 *
	 * 功能：删除
	 *
	 */
	public ActionForward delUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TUserForm userForm = (TUserForm) form;
		this.getTUserService().delUser(Integer.valueOf(userForm.getId()));
		return mapping.findForward("delUser");
	}
	public ActionForward delDoctor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TUserForm userForm = (TUserForm) form;
		this.getTUserService().delUser(Integer.valueOf(userForm.getId()));
		return mapping.findForward("delDoctor");
	}	
	/**
	 * 
	 *
	 * 功能：唯一性验评
	 *
	 */
	public ActionForward checkInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TUserForm userForm = (TUserForm) form;
		TUser user = new TUser();
		user.setUsername(userForm.getUsername());
		
		int i = this.getTUserService().checkUser(userForm.getUsername());
		if(i==0){
			request.setAttribute("errormessage", "验证通过，可以使用！");
		}else{
			request.setAttribute("errormessage", "内容已经存在，请更换");
		}
		request.setAttribute("user", user);
		return mapping.findForward("checkUser");
	}	
	/**
	 * 为文件重命名
	 * @param filename
	 * @return
	 */
	 public String rename(String filename) {  
		   String body="";  
		      String ext="";  
		      Date date = new Date();  
		      int pot = filename.lastIndexOf(".");  
		      if(pot!=-1){  
		          body= date.getTime() +"";  
		          ext=filename.substring(pot);  
		      }else{  
		          body=(new Date()).getTime()+"";  
		          ext="";  
		      }  
		      String newName=body+ext;  
		      return newName;  
	 } 
}
