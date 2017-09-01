package com.daoImpl;

import java.io.Serializable;
import java.util.List;

import com.base.BaseDaoImpl;
import com.dao.TOfficeDao;
import com.exception.BaseException;
import com.pojo.TOffice;
/**
 * 
 * 
 * 功能：部门信息DaoImpl
 *
 */
public class TOfficeDaoImpl extends BaseDaoImpl implements TOfficeDao {

	/**
	 * 
	 * 信息处理分页查询
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TOffice> getTOffices(int currentpage, int pageunit,
			String cond) {

		try {
			String hql = " from TOffice a where 1=1  " + cond;
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
	public List<TOffice> queryTOffice(String cond) {

		try {
			String hql = " from TOffice a where 1=1  " + cond;
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

	public int getTOfficesCount(String cond) {
		try {
			String hql = " select count(a) from TOffice a where 1=1 "
					+ cond;
			Object t = this.queryAggregation(hql);
			return ((Long) t).intValue();
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Serializable addTOffice(TOffice office) {
		try {
			this.save(office);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delTOffice(TOffice office) {
		try {
			this.delete(office);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public TOffice getTOffice(Integer id) {
		TOffice office = null;
		try {
			office = (TOffice) this.get(TOffice.class, id);
		} catch (BaseException e) {
			e.printStackTrace();
			return null;
		}
		return office;
	}
	/**
	 * 修改
	 */
	public boolean modifyTOffice(TOffice office) {
		try {
			this.merge(office);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 
	 * 查询信息
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TOffice> queryTCase(String cond) {

		try {
			String hql = " from TOffice a where 1=1  " + cond;
			return this.query(hql);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
