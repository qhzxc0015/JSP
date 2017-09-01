package com.web.action;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.TMessage;
import com.service.TMessageService;
import com.util.PageInfo;
import com.util.SimpleBaseAction;
import com.web.form.TMessageForm;

/**
 * 
 *
 * 功能：留言本信息
 *
 */
public class MessageAction extends SimpleBaseAction {
	private TMessageService messageService  ;

	public TMessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(TMessageService messageService) {
		this.messageService = messageService;
	}
	/**
	 * 
	 *
	 * 功能：分页查询
	 *
	 */
	@SuppressWarnings("unchecked")
	public ActionForward queryMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		if (request.getSession().getAttribute("querypageunit") == null) {
			request.getSession().setAttribute("querypageunit",
					this.pageunit);
		}
		StringBuffer cond = new StringBuffer();

		if(null!=request.getParameter("searchname1")&&""!=request.getParameter("searchname1").trim()){
			cond.append(" and a.message like '%"+request.getParameter("searchname1").trim()+"%' ");
		}
		int curpage = this.getCurrentpage(request);
		int pageunit = this.getPageunit(request, "querypageunit");

		String url = "./message.do?mtype=queryMessages";
		
		PageInfo pageInfo = this.getMessageService().queryTMessage(curpage,
				pageunit, request, url, cond.toString());
		request.setAttribute("pageinfo", pageInfo);
		request.setAttribute("searchname1", request.getParameter("searchname1"));
		return mapping.findForward("queryMessages");
	}
	/**
	 * 
	 *
	 * 功能：添加
	 *
	 */
	public ActionForward addMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TMessageForm MessageForm = (TMessageForm) form;
		TMessage Message = new TMessage();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Message.setUser((String)request.getSession().getAttribute("username"));
		Message.setInputdate(dateFormat.format(date));
		Message.setMessage(MessageForm.getMessage());
		this.getMessageService().addTMessage(Message);
		return mapping.findForward("addMessage");

	}
	/**
	 * 
	 *
	 * 功能：预修改
	 *
	 */
	public ActionForward preupdateMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TMessageForm messageForm = (TMessageForm) form;
		
		TMessage message = this.getMessageService().getTMessage(messageForm.getId());
		request.setAttribute("message", message);
		return mapping.findForward("preupdateMessage");
	}
	
	/**
	 * 
	 *
	 * 功能：修改
	 *
	 */
	public ActionForward updateMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TMessageForm messageForm = (TMessageForm) form;
		
		TMessage message = this.getMessageService().getTMessage(messageForm.getId());
		message.setReply(messageForm.getReply());
		message.setDoctor((String)request.getSession().getAttribute("username"));
		this.getMessageService().modifyTMessage(message);
		return mapping.findForward("updateMessage");
	}
	/**
	 * 
	 *
	 * 功能：删除
	 *
	 */
	public ActionForward delMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TMessageForm pictureForm = (TMessageForm) form;
		this.getMessageService().delTMessage(pictureForm.getId());
		return mapping.findForward("delMessage");
	}
}
