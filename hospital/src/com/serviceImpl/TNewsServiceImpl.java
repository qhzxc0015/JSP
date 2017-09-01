package com.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.TNewsDao;
import com.pojo.TNews;
import com.service.TNewsService;
import com.util.PageInfo;
/**
 * 
 * 
 * 功能：医疗ServiceImpl
 *
 */
public class TNewsServiceImpl implements TNewsService {
		
	private TNewsDao newsDao;	


	public TNewsDao getNewsDao() {
		return newsDao;
	}
	public void setNewsDao(TNewsDao newsDao) {
		this.newsDao = newsDao;
	}
	/**
	 * 添加
	 */
	public Serializable addTNews(TNews news) {
		this.getNewsDao().addTNews(news);
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delTNews(Integer id) {
		TNews news = this.getNewsDao().getTNews(id);
		this.getNewsDao().delTNews(news);
		return false;
	}
	/**
	 * 查询
	 */
	public TNews getTNews(Integer id) {
		return this.getNewsDao().getTNews(id);
	}
	/**
	 * 修改
	 */
	public boolean modifyTNews(TNews news) {
		this.getNewsDao().modifyTNews(news);
		return false;
	}
	/**
	 * 分页查询
	 */
	public PageInfo queryTNews(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getNewsDao().getTNewssCount(cond);
		List<TNews> list = this.getNewsDao().getTNewss(currentpage,
				pageunit, cond);
		PageInfo PageInfo = new PageInfo(currentpage, pageunit, rowCount, url,
				list);
		return PageInfo;
	}
				
}
