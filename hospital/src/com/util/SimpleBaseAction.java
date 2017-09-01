package com.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.actions.DispatchAction;

public class SimpleBaseAction extends DispatchAction {
	//分页变量
	public int currentpage = 1;
	public int pageunit = 10;
	//自动拼接查询条件方法
	public Object[] getCondPrams(ActionForm actionForm,String poClassPathPrefix) throws Exception {
		Class clas=actionForm.getClass();
		StringBuffer  cond=new StringBuffer();
		List params=new ArrayList();
		Field[] fileds=clas.getDeclaredFields();
		for(Field f:fileds)
		{
			String methdName="get"+(f.getName().substring(0,1)).toUpperCase()+f.getName().substring(1);
			
				
				if(f.getName().indexOf("_")>=0)
				{
					Method	m=clas.getDeclaredMethod(methdName, null);
							String[] strs=f.getName().split("_");
							Class poClas=Class.forName(poClassPathPrefix+"."+(strs[0].substring(0,2)).toUpperCase()+strs[0].substring(2));
						Object oValue	=m.invoke(actionForm, null);
						if(oValue!=null&&!"".equals(oValue))
						{
							Field	field=poClas.getDeclaredField(strs[1]);
							if(field.getType().getSimpleName().equals("String"))
							{
								cond.append(" and "+strs[0]+"."+strs[1]+" like ? ");
								params.add('%'+(String)oValue+'%');	
							}else{
								cond.append(" and "+strs[0]+"."+strs[1]+" = ? ");
								params.add(oValue);
							} 
						}	
				}
			
		}
		if(cond.toString().length()<=0||params.size()<=0)
		{
			return null;
		}else{
			return new Object[]{cond,params};
		}
	}
	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPageunit() {
		return pageunit;
	}

	public void setPageunit(int pageunit) {
		this.pageunit = pageunit;
	}
	public int getCurrentpage(HttpServletRequest request) {
		String currentpage = request.getParameter("currentpage");
		if(currentpage != null && !"".equals(currentpage)){
			return Integer.parseInt(currentpage);
		}
		return this.currentpage;
	}

	public int getPageunit(HttpServletRequest request,String str) {
		String pageunit= request.getParameter("pageunit");
		if(pageunit != null && !"".equals(pageunit)){
			request.getSession().setAttribute(str, pageunit);
			return Integer.parseInt(pageunit);
		}else{
			return Integer.parseInt(request.getSession().getAttribute(str).toString());
		}
	}
}
