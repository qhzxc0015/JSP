package com.service;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.pojo.TNews;
import com.util.PageInfo;

/**
 * 
 * 
 * 功能：医疗Service
 *
 */

public interface TNewsService {
	//添加
	public Serializable addTNews(TNews news);
	//查询
	public TNews getTNews(Integer id);
	//删除
	public boolean delTNews(Integer id);
	//修改
	public boolean modifyTNews(TNews news);
	//分页查询
	public PageInfo queryTNews(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond);
}
