package com.daoImpl;

import java.io.Serializable;
import java.util.List;

import com.base.BaseDaoImpl;
import com.dao.TUserDao;
import com.exception.BaseException;
import com.pojo.TUser;
/**
 * 
 * 
 * 功能：用户信息DaoImpl
 *
 */
public class TUserDaoImpl extends BaseDaoImpl implements TUserDao {

	/**
	 * 
	 * 处理分页查询
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TUser> getUsers( int currentpage,  int pageunit,
			 String cond) {

		try {
			final String hql = " from TUser a where 1=1  " + cond;
			return this.query(hql, currentpage, pageunit);
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

	public int getUsersCount(String cond) {
		try {
			String hql = " select count(a) from TUser a where 1=1 "
					+ cond;
			Object t = this.queryAggregation(hql);
			return ((Long) t).intValue();
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 添加用户
	 */
	public Serializable addUser(TUser user) {
		try {
			this.save(user);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delUser(TUser user) {
		try {
			this.delete(user);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public TUser getUser(Integer id) {
		TUser user = null;
		try {
			user = (TUser) this.get(TUser.class, id);
		} catch (BaseException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	/**
	 * 修改
	 */
	public boolean modifyUser(TUser user) {
		try {
			this.merge(user);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 
	 * 类型信息
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TUser> queryUser(String cond) {

		try {
			String hql = " from TUser a where 1=1  " + cond;
			return this.query(hql);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
