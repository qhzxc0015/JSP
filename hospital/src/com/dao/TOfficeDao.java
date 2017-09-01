package com.dao;

import java.io.Serializable;
import java.util.List;

import com.pojo.TOffice;



public interface TOfficeDao {
	// 添加
	public Serializable addTOffice(TOffice office);
	// 查询
	public TOffice getTOffice(Integer id);
	// 删除
	public boolean delTOffice(TOffice office);
	// 修改
	public boolean modifyTOffice(TOffice office);
	// 分页电子书处理信息
	public List<TOffice> getTOffices(int currentpage, int pageunit,
			String cond);
	// 统计总记录数
	public int getTOfficesCount(String cond);
	
	//全部信息
	public List<TOffice> queryTOffice(String cond);
}
