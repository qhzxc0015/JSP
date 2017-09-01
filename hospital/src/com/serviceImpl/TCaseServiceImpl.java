package com.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.TCaseDao;
import com.pojo.TCase;
import com.service.TCaseService;
import com.util.PageInfo;
/**
 * 
 * 
 * 功能：病例ServiceImpl
 *
 */
public class TCaseServiceImpl implements TCaseService {
		
	private TCaseDao caseDao;	



	public TCaseDao getCaseDao() {
		return caseDao;
	}
	public void setCaseDao(TCaseDao caseDao) {
		this.caseDao = caseDao;
	}
	/**
	 * 添加
	 */
	public Serializable addTCase(TCase acase) {
		this.getCaseDao().addTCase(acase);
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delTCase(Integer id) {
		TCase acase = this.getCaseDao().getTCase(id); 
		this.getCaseDao().delTCase(acase);
		return false;
	}
	/**
	 * 查询
	 */
	public TCase getTCase(Integer id) {
		return this.getCaseDao().getTCase(id);
	}
	/**
	 * 修改
	 */
	public boolean modifyTCase(TCase acase) {
		this.getCaseDao().modifyTCase(acase);
		return false;
	}
	/**
	 * 分页查询
	 */
	public PageInfo queryTCase(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getCaseDao().getTCasesCount(cond);
		List<TCase> list = this.getCaseDao().getTCases(currentpage,
				pageunit, cond);
		PageInfo PageInfo = new PageInfo(currentpage, pageunit, rowCount, url,
				list);
		return PageInfo;
	}
				
}
