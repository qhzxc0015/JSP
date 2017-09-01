package com.service;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.pojo.TCase;
import com.util.PageInfo;

/**
 * 
 * 
 * 功能：病例Service
 *
 */

public interface TCaseService {
	//添加
	public Serializable addTCase(TCase acase);
	//查询
	public TCase getTCase(Integer id);
	//删除
	public boolean delTCase(Integer id);
	//修改
	public boolean modifyTCase(TCase acase);
	//分页查询
	public PageInfo queryTCase(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond);
}
