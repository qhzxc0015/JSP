package com.dao;

import java.io.Serializable;
import java.util.List;

import com.pojo.TUser;



public interface TUserDao {
	// 添加
	public Serializable addUser(TUser user);
	// 查询
	public TUser getUser(Integer id);
	// 删除
	public boolean delUser(TUser user);
	// 修改
	public boolean modifyUser(TUser user);
	// 分页电子书处理
	public List<TUser> getUsers(int currentpage, int pageunit,
			String cond);
	// 统计总记录数
	public int getUsersCount(String cond);
	// 登录验证
	public List<TUser> queryUser(String cond);
}
