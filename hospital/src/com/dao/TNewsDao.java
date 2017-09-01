package com.dao;

import java.io.Serializable;
import java.util.List;

import com.pojo.TNews;



public interface TNewsDao {
	// 添加
	public Serializable addTNews(TNews news);
	// 查询
	public TNews getTNews(Integer id);
	// 删除
	public boolean delTNews(TNews news);
	// 修改
	public boolean modifyTNews(TNews news);
	// 分页电子书处理信息
	public List<TNews> getTNewss(int currentpage, int pageunit,
			String cond);
	// 统计总记录数
	public int getTNewssCount(String cond);
}
