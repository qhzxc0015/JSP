package com.daoImpl;

import java.io.Serializable;
import java.util.List;

import com.base.BaseDaoImpl;
import com.dao.TMessageDao;
import com.exception.BaseException;
import com.pojo.TMessage;
/**
 * 
 * 
 * 功能：留言板信息DaoImpl
 *
 */
public class TMessageDaoImpl extends BaseDaoImpl implements TMessageDao {

	/**
	 * 
	 * 信息处理分页查询
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TMessage> getTMessages(int currentpage, int pageunit,
			String cond) {

		try {
			String hql = " from TMessage a where 1=1  " + cond;
			return this.query(hql, currentpage, pageunit);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * 查询信息
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TMessage> queryTMessage(String cond) {

		try {
			String hql = " from TMessage a where 1=1  " + cond;
			return this.query(hql);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 统计总记录数
	 * 
	 */

	public int getTMessagesCount(String cond) {
		try {
			String hql = " select count(a) from TMessage a where 1=1 "
					+ cond;
			Object t = this.queryAggregation(hql);
			return ((Long) t).intValue();
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Serializable addTMessage(TMessage message) {
		try {
			this.save(message);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delTMessage(TMessage message) {
		try {
			this.delete(message);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public TMessage getTMessage(Integer id) {
		TMessage message = null;
		try {
			message = (TMessage) this.get(TMessage.class, id);
		} catch (BaseException e) {
			e.printStackTrace();
			return null;
		}
		return message;
	}
	/**
	 * 修改
	 */
	public boolean modifyTMessage(TMessage message) {
		try {
			this.merge(message);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
