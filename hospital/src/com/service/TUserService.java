package com.service;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pojo.TUser;
import com.util.PageInfo;

/**
 * 
 * 
 * 功能：用户Service
 *
 */

public interface TUserService {
	//添加
	public Serializable addUser(TUser user);
	//查询
	public TUser getUser(Integer id);
	//删除
	public boolean delUser(Integer id);
	//修改
	public boolean modifyUser(TUser user);
	//分页查询
	public PageInfo queryUser(int currentpage, int pageunit,
			HttpServletRequest request, String url, String cond);
	//唯一性验
	public int checkUser(String name);
	//登录验证
	public List<TUser> checkUser(String name, String pwd);
}
