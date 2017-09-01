package com.daoImpl;

import java.io.Serializable;
import java.util.List;

import com.base.BaseDaoImpl;
import com.dao.TCaseDao;
import com.exception.BaseException;
import com.pojo.TCase;
/**
 * 
 * 
 * 功能：病例信息DaoImpl
 *
 */
public class TCaseDaoImpl extends BaseDaoImpl implements TCaseDao {

	/**
	 * 
	 * 信息处理分页查询
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<TCase> getTCases(int currentpage, int pageunit,
			String cond) {

		try {
			String hql = " from TCase a where 1=1  " + cond;
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
	public List<TCase> queryTCase(String cond) {

		try {
			String hql = " from TCase a where 1=1  " + cond;
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

	public int getTCasesCount(String cond) {
		try {
			String hql = " select count(a) from TCase a where 1=1 "
					+ cond;
			Object t = this.queryAggregation(hql);
			return ((Long) t).intValue();
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Serializable addTCase(TCase acase) {
		try {
			this.save(acase);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delTCase(TCase acase) {
		try {
			this.delete(acase);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public TCase getTCase(Integer id) {
		TCase acase = null;
		try {
			acase = (TCase) this.get(TCase.class, id);
		} catch (BaseException e) {
			e.printStackTrace();
			return null;
		}
		return acase;
	}
	/**
	 * 修改
	 */
	public boolean modifyTCase(TCase acase) {
		try {
			this.merge(acase);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
