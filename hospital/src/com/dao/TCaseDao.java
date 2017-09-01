package com.dao;

import java.io.Serializable;
import java.util.List;

import com.pojo.TCase;

public interface TCaseDao {
	// 添加
	public Serializable addTCase(TCase acase);
	// 查询
	public TCase getTCase(Integer id);
	// 删除
	public boolean delTCase(TCase acase);
	// 修改
	public boolean modifyTCase(TCase acase);
	// 分页电子书处理信息
	public List<TCase> getTCases(int currentpage, int pageunit,
			String cond);
	//全部信息
	public List<TCase> queryTCase(String cond);
	// 统计总记录数
	public int getTCasesCount(String cond);
}
