package com.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.TUserDao;
import com.pojo.TUser;
import com.service.TUserService;
import com.util.PageInfo;
/**
 * 
 * 
 * 功能：用户ServiceImpl
 *
 */
public class TUserServiceImpl implements TUserService {
		
	private TUserDao tUserDao;	


	public TUserDao getTUserDao() {
		return tUserDao;
	}
	public void setTUserDao(TUserDao userDao) {
		tUserDao = userDao;
	}
	/**
	 * 添加
	 */
	public Serializable addUser(TUser user) {
		this.getTUserDao().addUser(user);
		return null;
	}
	/**
	 * 删除
	 */
	public boolean delUser(Integer id) {
		TUser user = this.getTUserDao().getUser(id);
		this.getTUserDao().delUser(user);
		return false;
	}
	/**
	 * 查询
	 */
	public TUser getUser(Integer id) {
		return this.getTUserDao().getUser(id);
	}
	/**
	 * 修改
	 */
	public boolean modifyUser(TUser user) {
		this.getTUserDao().modifyUser(user);
		return false;
	}
	/**
	 * 分页查询
	 */
	public PageInfo queryUser(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond) {
		
		int rowCount = this.getTUserDao().getUsersCount(cond);
		List<TUser> list = this.getTUserDao().getUsers(currentpage,
				pageunit, cond);
		PageInfo PageInfo = new PageInfo(currentpage, pageunit, rowCount, url,
				list);
		return PageInfo;
	}
	/**
	 * 唯一性验
	 */
	public int checkUser(String name) {
		String cond=" and a.username='"+name+"' ";
		return this.getTUserDao().getUsersCount(cond);
	}
	/**
	 * 验证用户信息
	 */
	@SuppressWarnings("unchecked")
	public List<TUser> checkUser(String name, String pwd) {
		String cond = "";
			cond = " and a.username = '"+name+"' and a.password =  '"+pwd+"'";
		List<TUser> list = (List) this.getTUserDao().queryUser(cond);
		return list;
	}			
}
