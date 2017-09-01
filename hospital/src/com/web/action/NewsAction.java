package com.web.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.TNews;
import com.service.TNewsService;
import com.util.PageInfo;
import com.util.SimpleBaseAction;
import com.web.form.TNewsForm;

/**
 * 
 *
 * 功能：医疗信息
 *
 */
public class NewsAction extends SimpleBaseAction {
	private TNewsService newsService  ;

	public TNewsService getNewsService() {
		return newsService;
	}
	public void setNewsService(TNewsService newsService) {
		this.newsService = newsService;
	}
	/**
	 * 
	 *
	 * 功能：分页查询
	 *
	 */
	@SuppressWarnings("unchecked")
	public ActionForward queryNewss(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		if (request.getSession().getAttribute("querypageunit") == null) {
			request.getSession().setAttribute("querypageunit",
					this.pageunit);
		}
		StringBuffer cond = new StringBuffer();

		if(null!=request.getParameter("searchname1")&&""!=request.getParameter("searchname1").trim()){
			cond.append(" and a.news like '%"+request.getParameter("searchname1").trim()+"%' ");
		}
		int curpage = this.getCurrentpage(request);
		int pageunit = this.getPageunit(request, "querypageunit");

		String url = "./news.do?mtype=queryNewss";
		
		PageInfo pageInfo = this.getNewsService().queryTNews(curpage,
				pageunit, request, url, cond.toString());
		request.setAttribute("pageinfo", pageInfo);
		request.setAttribute("searchname1", request.getParameter("searchname1"));
		return mapping.findForward("queryNewss");
	}
	/**
	 * 
	 *
	 * 功能：添加
	 *
	 */
	public ActionForward addNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TNewsForm newsForm = (TNewsForm) form;
		TNews news = new TNews();
		news.setNews(newsForm.getNews());
		news.setPills(newsForm.getPills());
		news.setPrice(newsForm.getPrice());
		this.getNewsService().addTNews(news);
		return mapping.findForward("addNews");

	}
	/**
	 * 
	 *
	 * 功能：预修改
	 *
	 */
	public ActionForward preupdateNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TNewsForm newsForm = (TNewsForm) form;
		
		TNews news = this.getNewsService().getTNews(newsForm.getId());
		request.setAttribute("news", news);
		return mapping.findForward("preupdateNews");
	}
	
	/**
	 * 
	 *
	 * 功能：修改
	 *
	 */
	public ActionForward updateNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TNewsForm newsForm = (TNewsForm) form;
		
		TNews news = this.getNewsService().getTNews(newsForm.getId());
		news.setNews(newsForm.getNews());
		news.setPills(newsForm.getPills());
		news.setPrice(newsForm.getPrice());
		this.getNewsService().modifyTNews(news);
		return mapping.findForward("updateNews");
	}
	/**
	 * 
	 *
	 * 功能：删除
	 *
	 */
	public ActionForward delNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		TNewsForm pictureForm = (TNewsForm) form;
		this.getNewsService().delTNews(pictureForm.getId());
		return mapping.findForward("delNews");
	}
}
