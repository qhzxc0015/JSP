package com.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.TMessageDao;
import com.pojo.TMessage;
import com.service.TMessageService;
import com.util.PageInfo;
/**
 * 
 * 
 * 功能：留言板ServiceImpl
 *
 */
public class TMessageServiceImpl implements TMessageService {
		
	private TMessageDao messageDao;	



	public TMessageDao getMessageDao() {
		return messageDao;
	}
	public void setMessageDao(TMessageDao messageDao) {
		this.messageDao = messageDao;
	}
	/**
	 * 添加
	 */
	public Serializable addTMessage(TMessage message) {
		this.getMessageDao().addTMessage(message);
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delTMessage(Integer id) {
		TMessage message = this.getMessageDao().getTMessage(id);
		this.getMessageDao().delTMessage(message);
		return false;
	}
	/**
	 * 查询
	 */
	public TMessage getTMessage(Integer id) {
		return this.getMessageDao().getTMessage(id);
	}
	/**
	 * 修改
	 */
	public boolean modifyTMessage(TMessage message) {
		this.getMessageDao().modifyTMessage(message);
		return false;
	}
	/**
	 * 分页查询
	 */
	public PageInfo queryTMessage(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getMessageDao().getTMessagesCount(cond);
		List<TMessage> list = this.getMessageDao().getTMessages(currentpage,
				pageunit, cond);
		PageInfo PageInfo = new PageInfo(currentpage, pageunit, rowCount, url,
				list);
		return PageInfo;
	}
				
}
