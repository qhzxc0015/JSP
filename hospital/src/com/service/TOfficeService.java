package com.service;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pojo.TOffice;
import com.util.PageInfo;

/**
 * 
 * 
 * 功能：部门Service
 *
 */

public interface TOfficeService {
	//添加
	public Serializable addTOffice(TOffice office);
	//查询
	public TOffice getTOffice(Integer id);
	//删除
	public boolean delTOffice(Integer id);
	//修改
	public boolean modifyTOffice(TOffice office);
	//分页查询
	public PageInfo queryTOffice(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond);
	public List<TOffice> queryTOffice(String cond);
}
