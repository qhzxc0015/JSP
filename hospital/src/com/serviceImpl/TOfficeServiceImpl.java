package com.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.TOfficeDao;
import com.pojo.TOffice;
import com.service.TOfficeService;
import com.util.PageInfo;
/**
 * 
 * 
 * 功能：部门ServiceImpl
 *
 */
public class TOfficeServiceImpl implements TOfficeService {
		
	private TOfficeDao officeDao;	

	public TOfficeDao getOfficeDao() {
		return officeDao;
	}
	public void setOfficeDao(TOfficeDao officeDao) {
		this.officeDao = officeDao;
	}
	/**
	 * 添加
	 */
	public Serializable addTOffice(TOffice office) {
		this.getOfficeDao().addTOffice(office);
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delTOffice(Integer id) {
		TOffice office = this.getOfficeDao().getTOffice(id);
		this.getOfficeDao().delTOffice(office);
		return false;
	}
	/**
	 * 查询
	 */
	public TOffice getTOffice(Integer id) {
		return this.getOfficeDao().getTOffice(id);
	}
	/**
	 * 修改
	 */
	public boolean modifyTOffice(TOffice office) {
		this.getOfficeDao().modifyTOffice(office);
		return false;
	}
	/**
	 * 分页查询
	 */
	public PageInfo queryTOffice(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getOfficeDao().getTOfficesCount(cond);
		List<TOffice> list = this.getOfficeDao().getTOffices(currentpage,
				pageunit, cond);
		PageInfo PageInfo = new PageInfo(currentpage, pageunit, rowCount, url,
				list);
		return PageInfo;
	}
	public List<TOffice> queryTOffice(String cond) {
		return this.getOfficeDao().queryTOffice(cond);
	}
				
}
