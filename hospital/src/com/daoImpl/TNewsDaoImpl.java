package com.daoImpl;

import java.io.Serializable;
import java.util.List;

import com.base.BaseDaoImpl;
import com.dao.TNewsDao;
import com.exception.BaseException;
import com.pojo.TNews;
/**
 * 
 * 
 * 功能：医疗信息DaoImpl
 *
 */
public class TNewsDaoImpl extends BaseDaoImpl implements TNewsDao {

	/**
	 * 
	 * 信息处理分页查询
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TNews> getTNewss(int currentpage, int pageunit,
			String cond) {

		try {
			String hql = " from TNews a where 1=1  " + cond;
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
	public List<TNews> queryTNews(String cond) {

		try {
			String hql = " from TNews a where 1=1  " + cond;
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

	public int getTNewssCount(String cond) {
		try {
			String hql = " select count(a) from TNews a where 1=1 "
					+ cond;
			Object t = this.queryAggregation(hql);
			return ((Long) t).intValue();
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Serializable addTNews(TNews news) {
		try {
			this.save(news);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delTNews(TNews news) {
		try {
			this.delete(news);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public TNews getTNews(Integer id) {
		TNews news = null;
		try {
			news = (TNews) this.get(TNews.class, id);
		} catch (BaseException e) {
			e.printStackTrace();
			return null;
		}
		return news;
	}
	/**
	 * 修改
	 */
	public boolean modifyTNews(TNews news) {
		try {
			this.merge(news);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
