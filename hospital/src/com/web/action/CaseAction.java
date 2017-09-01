package com.web.action;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.TCase;
import com.service.TCaseService;
import com.util.PageInfo;
import com.util.SimpleBaseAction;
import com.web.form.TCaseForm;

/**
 * 
 *
 * 功能：病例信息
 *
 */
public class CaseAction extends SimpleBaseAction {
	private TCaseService caseService  ;

	public TCaseService getCaseService() {
		return caseService;
	}
	public void setCaseService(TCaseService caseService) {
		this.caseService = caseService;
	}
	/**
	 * 
	 *
	 * 功能：分页查询
	 *
	 */
	@SuppressWarnings("unchecked")
	public ActionForward queryCases(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		if (request.getSession().getAttribute("querypageunit") == null) {
			request.getSession().setAttribute("querypageunit",
					this.pageunit);
		}
		StringBuffer cond = new StringBuffer();

		if(null!=request.getParameter("searchname3")&&""!=request.getParameter("searchname3").trim()){
			cond.append(" and a.casename like '%"+request.getParameter("searchname3").trim()+"%' ");
		}
		if(null!=request.getParameter("searchname1")&&""!=request.getParameter("searchname1").trim()){
			cond.append(" and a.userid like '%"+request.getParameter("searchname1").trim()+"%' ");
		}
		if(null!=request.getParameter("searchname2")&&""!=request.getParameter("searchname2").trim()){
			cond.append(" and a.doctor like '%"+request.getParameter("searchname2").trim()+"%' ");
		}
		if("2".equals((String)request.getSession().getAttribute("power"))){
			cond.append(" and userid = '"+(String)request.getSession().getAttribute("username")+"'");
		}else if("1".equals((String)request.getSession().getAttribute("power"))){
			cond.append(" and doctor = '"+(String)request.getSession().getAttribute("username")+"'");
		}
		int curpage = this.getCurrentpage(request);
		int pageunit = this.getPageunit(request, "querypageunit");

		String url = "./case.do?mtype=queryCases";
		
		PageInfo pageInfo = this.getCaseService().queryTCase(curpage,
				pageunit, request, url, cond.toString());
		request.setAttribute("pageinfo", pageInfo);
		request.setAttribute("searchname1", request.getParameter("searchname1"));
		request.setAttribute("searchname2", request.getParameter("searchname2"));
		request.setAttribute("searchname3", request.getParameter("searchname3"));
		return mapping.findForward("queryCases");
	}
	/**
	 * 
	 *
	 * 功能：添加
	 *
	 */
	public ActionForward addCase(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TCaseForm caseForm = (TCaseForm) form;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		TCase acase = new TCase();
		acase.setCasename(caseForm.getCasename());
		acase.setInputdate(dateFormat.format(date));
		acase.setStatus("0");
		acase.setUserid((String)request.getSession().getAttribute("username"));
		acase.setDoctor(caseForm.getDoctor());
		this.getCaseService().addTCase(acase);
		return mapping.findForward("addCase");

	}
	/**
	 * 
	 *
	 * 功能：预修改
	 *
	 */
	public ActionForward doctorpreupdateCase(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TCaseForm caseForm = (TCaseForm) form;
		
		TCase acase = this.getCaseService().getTCase(caseForm.getId());
		request.setAttribute("case", acase);
		return mapping.findForward("doctorpreupdateCase");
	}
	public ActionForward userpreupdateCase(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TCaseForm caseForm = (TCaseForm) form;
		
		TCase acase = this.getCaseService().getTCase(caseForm.getId());
		request.setAttribute("case", acase);
		return mapping.findForward("userpreupdateCase");
	}
	
	/**
	 * 
	 *
	 * 功能：修改
	 *
	 */
	public ActionForward updateCase(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TCaseForm caseForm = (TCaseForm) form;
		
		TCase acase = this.getCaseService().getTCase(caseForm.getId());
		if("2".equals((String)request.getSession().getAttribute("power"))){
			acase.setUsermg(caseForm.getUsermg());
		}else{
			acase.setDoctormg(caseForm.getDoctormg());
		}
		this.getCaseService().modifyTCase(acase);
		return mapping.findForward("updateCase");
	}
	public ActionForward saveCase(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TCaseForm caseForm = (TCaseForm) form;
		
		TCase acase = this.getCaseService().getTCase(caseForm.getId());
			acase.setStatus("1");
		this.getCaseService().modifyTCase(acase);
		return mapping.findForward("updateCase");
	}
	/**
	 * 
	 *
	 * 功能：删除
	 *
	 */
	public ActionForward delCase(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TCaseForm pictureForm = (TCaseForm) form;
		this.getCaseService().delTCase(pictureForm.getId());
		return mapping.findForward("delCase");
	}
}
