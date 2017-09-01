package com.service;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.pojo.TMessage;
import com.util.PageInfo;

/**
 * 
 * 
 * 功能：留言本Service
 *
 */

public interface TMessageService {
	//添加
	public Serializable addTMessage(TMessage message);
	//查询
	public TMessage getTMessage(Integer id);
	//删除
	public boolean delTMessage(Integer id);
	//修改
	public boolean modifyTMessage(TMessage message);
	//分页查询
	public PageInfo queryTMessage(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond);
}
