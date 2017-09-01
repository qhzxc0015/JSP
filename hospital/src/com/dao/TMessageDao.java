package com.dao;

import java.io.Serializable;
import java.util.List;

import com.pojo.TMessage;



public interface TMessageDao {
	// 添加
	public Serializable addTMessage(TMessage message);
	// 查询
	public TMessage getTMessage(Integer id);
	// 删除
	public boolean delTMessage(TMessage message);
	// 修改
	public boolean modifyTMessage(TMessage message);
	// 分页电子书处理信息
	public List<TMessage> getTMessages(int currentpage, int pageunit,
			String cond);
	// 统计总记录数
	public int getTMessagesCount(String cond);
}
