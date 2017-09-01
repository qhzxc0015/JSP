package com.web.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.TOffice;
import com.service.TOfficeService;
import com.util.PageInfo;
import com.util.SimpleBaseAction;
import com.web.form.TOfficeForm;

/**
 * 
 *
 * 功能：部门信息
 *
 */
public class OfficeAction extends SimpleBaseAction {
	private TOfficeService officeService  ;

	public TOfficeService getOfficeService() {
		return officeService;
	}
	public void setOfficeService(TOfficeService officeService) {
		this.officeService = officeService;
	}
	/**
	 * 
	 *
	 * 功能：分页查询
	 *
	 */
	@SuppressWarnings("unchecked")
	public ActionForward queryOffices(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		if (request.getSession().getAttribute("querypageunit") == null) {
			request.getSession().setAttribute("querypageunit",
					this.pageunit);
		}
		StringBuffer cond = new StringBuffer();

		if(null!=request.getParameter("searchname1")&&""!=request.getParameter("searchname1").trim()){
			cond.append(" and a.officename like '%"+request.getParameter("searchname1").trim()+"%' ");
		}
		int curpage = this.getCurrentpage(request);
		int pageunit = this.getPageunit(request, "querypageunit");

		String url = "./office.do?mtype=queryOffices";
		
		PageInfo pageInfo = this.getOfficeService().queryTOffice(curpage,
				pageunit, request, url, cond.toString());
		request.setAttribute("pageinfo", pageInfo);
		request.setAttribute("searchname1", request.getParameter("searchname1"));
		return mapping.findForward("queryOffices");
	}
	/**
	 * 
	 *
	 * 功能：添加
	 *
	 */
	public ActionForward addOffice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TOfficeForm officeForm = (TOfficeForm) form;
		TOffice office = new TOffice();
		office.setDevice(officeForm.getDevice());
		office.setOfficename(officeForm.getOfficename());
		office.setScope(officeForm.getScope());
		office.setStatertime(officeForm.getStatertime());
		this.getOfficeService().addTOffice(office);
		return mapping.findForward("addOffice");

	}
	/**
	 * 
	 *
	 * 功能：预修改
	 *
	 */
	public ActionForward preupdateOffice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TOfficeForm officeForm = (TOfficeForm) form;
		
		TOffice office = this.getOfficeService().getTOffice(officeForm.getId());
		request.setAttribute("office", office);
		return mapping.findForward("preupdateOffice");
	}
	
	/**
	 * 
	 *
	 * 功能：修改
	 *
	 */
	public ActionForward updateOffice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TOfficeForm officeForm = (TOfficeForm) form;
		
		TOffice office = this.getOfficeService().getTOffice(officeForm.getId());
		office.setDevice(officeForm.getDevice());
		office.setOfficename(officeForm.getOfficename());
		office.setScope(officeForm.getScope());
		office.setStatertime(officeForm.getStatertime());
		this.getOfficeService().modifyTOffice(office);
		return mapping.findForward("updateOffice");
	}
	/**
	 * 
	 *
	 * 功能：删除
	 *
	 */
	public ActionForward delOffice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TOfficeForm pictureForm = (TOfficeForm) form;
		this.getOfficeService().delTOffice(pictureForm.getId());
		return mapping.findForward("delOffice");
	}
}
