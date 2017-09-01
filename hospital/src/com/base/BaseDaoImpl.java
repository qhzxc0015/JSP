
package com.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.exception.BaseException;


public class BaseDaoImpl extends HibernateDaoSupport {
	public Object findById(final Class cla, final Serializable id) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.get(cla, id);
			}
		});
	}

	public List findByProperty(final String queryString, final Object value) {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query queryObject = getSession().createQuery(
								queryString);
						queryObject.setParameter(0, value);
						return queryObject.list();

					}
				});
	}

	public List findByExample(final Object instance) {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						List list = session.createCriteria(
								instance.getClass().getName()).add(
								Example.create(instance)).list();
						return list;
					}
				});

	}

	public List getPageData(final String hql, final int curpage,
			final int pagerecord) {

		// this.getSessionFactory().getCurrentSession();
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((curpage - 1) * pagerecord);
				query.setMaxResults(pagerecord);
				return query.list();
			}
		});

	}

	public int getCount(final String hql) {
		int count = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.uniqueResult();
					}
				});
		return count;
	}

	public Object getValue(final String hql) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				return query.uniqueResult();
			}
		});
	}

	public Serializable save(final Object obj) throws BaseException {
		Serializable iid = (Serializable) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Serializable id = session.save(obj);
						return id;
					}
				});
		return iid;
	}

	public Object merge(final Object obj) throws BaseException {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Object ob = session.merge(obj);
				return ob;
			}
		});
	}

	/**
	 * 利用Hibernate的�1�7�用类删除一个对豄1�7
	 */
	public void delete(final Object obj) throws BaseException {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.delete(obj);
				return null;
			}
		});
	}

	/**
	 * 利用Hibernate的�1�7�用类获得一个对豄1�7
	 * 
	 * @param c
	 *            霄1�7要获得对象所属的类结构1�7
	 * @param id
	 *            霄1�7要获得对象的标识笄1�7
	 * @return 返回该对豄1�7
	 */
	public Object get(final Class c, final Serializable id) throws BaseException {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.get(c, id);
			}
		});
	}

	/**
	 * 利用Hibernate的�1�7�用类获得（装载load）一个对豄1�7
	 * 
	 * @param c
	 *            扄1�7霄1�7获得对象扄1�7属的类结构1�7
	 * @param id
	 *            扄1�7霄1�7获得该对象的标识笄1�7
	 * @return 返回该对豄1�7
	 */
	public Object load(final Class c, final Serializable id) throws BaseException {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Object obj = session.load(c, id);
				Hibernate.initialize(obj);
				return obj;
			}
		});
	}

	/**
	 * 利用Hibernate的�1�7�用类修改一个对象的属�1�7�1�7
	 * 
	 * @param obj
	 *            要修改的对象
	 */
	public void update(final Object obj) throws BaseException {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.update(obj);
				return null;

			}
		});
	}

	/**
	 * 用Hibernate中的HQL语句，修改或删除指定的对豄1�7
	 * 
	 * @param hql
	 *            传入HQL语句
	 * @param Params
	 *            可变参数，对HQL语句中的参数("?"叄1�7)进行赋�1�7�1�7 ，如：where id = ＄1�7 and name = ＄1�7
	 * @return 执行修改或删除所影响的行敄1�7
	 */
	public int updateOrDelete(final String hql, final Object... Params)
			throws BaseException {
		return (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query q = session.createQuery(hql);
						try {
							q = setQueryValue(q, Params);
						} catch (BaseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int num = q.executeUpdate();
						return num;
					}
				});
	}

	/**
	 * 给Query查询对象进行赋�1�7�的方法
	 * 
	 * @param q
	 *            准备赋�1�7�的Query查询对象
	 * @param Params
	 *            给Query查询对象赋�1�7�所用的参数
	 * @return 赋�1�7�后的Query查询对象
	 */
	// ------------------------------------------------------------------------------------
	public Query setQueryValue(final Query q, final Object... Params)
			throws BaseException {
		return (Query) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						if (Params != null && Params.length > 0) {
							int i = 0;
							for (Object o : Params) {
								q.setString(i, o.toString());
								i++;
							}
						}
						return q;
					}
				});
	}

	/**
	 * 增加或修改一个对豄1�7
	 * 
	 * @param obj
	 *            霄1�7要增加或删除的对豄1�7
	 */
	public void saveOrUpdate(final Object obj) throws BaseException {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.saveOrUpdate(obj);
				return null;
			}
		});
	}

	public List queryBySql(final String sql) throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						List list = session.createSQLQuery(sql).list();
						return list;
					}
				});
	}

	/**
	 * 分页中条件查询统讄1�7 (20090822 泄1�7)
	 * 
	 * 通过Hibernate中HQL语句进行聚合查询
	 * 
	 * @param hql
	 *            聚合查询的HQL语句
	 * @param Params
	 *            给HQL语句中传入的参数 如：where id = ＄1�7 and name = ＄1�7
	 * @return 对象-------聚合查询的结果只有一丄1�7
	 */

	// 分页中条件查询统讄1�7
	public Object queryAggregation(final String hql, final Object... Params)
			throws BaseException {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery(hql);
				if (Params != null && Params.length > 0) {
					int i = 0;
					for (Object obj : Params) {
						if (obj != null) {
							q.setString(i, obj.toString());
							i++;
						}
					}
				}
				return q.uniqueResult();
			}
		});
	}

	public List query(final String hql) throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						List list = session.createQuery(hql).list();
						return list;
					}
				});
	}

//	public List query(final String hql, final Object... Params)
//			throws BaseException {
//		return (List) this.getHibernateTemplate().execute(
//				new HibernateCallback() {
//					public Object doInHibernate(Session session)
//							throws HibernateException, SQLException {
//						Query q = session.createQuery(hql);
//						if (Params != null && Params.length > 0) {
//							for (int i = 0; i < Params.length; i++) {
//								q.setString(i, Params[i].toString());
//							}
//							/*
//							 * Michael增加 int i = 0; for(Object obj : Params){
//							 * q.setString(i,"%"+obj.toString()+"%"); i++; }
//							 */}
//						List list = q.list();
//						return list;
//					}
//				});
//	}

	/**
	 * 分页显示数据列表 ＄1�7+分页查询 20090822 注） 利用HQL语句查询对象
	 * 
	 * @param hql
	 *            传入HQL的查询语叄1�7
	 * @param Params
	 *            给HQL中为"?"号的参数赋�1�7�的可变参数 如：where id=? and name=?
	 * @return 返回丄1�7个封装了查询结果的List容器
	 */
	/*
	 * public List query(String hql, Object... Params){ Session s =
	 * this.getSession(); Query q = s.createQuery(hql); if(Params != null &&
	 * Params.length > 0){ for(int i = 0; i < Params.length; i++){
	 * q.setString(i, Params[i].toString()); } } List list = q.list(); return
	 * list; }
	 */
	public List querylb(final String hql, final int currentpage,
			final int pageunit, final Object... Params) throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query q = session.createQuery(hql);
						if (Params != null && Params.length > 0) { // 取出可变参数中设置的条件
							int i = 0;
							for (Object obj : Params) {
								if (obj != null) {
									q.setString(i, obj.toString());
									i++;
								}
							}
						}
						// q.setFirstResult((currentpage-1)*pageunit); //分页展现
						// q.setMaxResults(pageunit);
						try {
							page(q, currentpage, pageunit);
						} catch (BaseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						List list = q.list();
						return list;
					}
				});
	}

	public List query(final String hql, final int currentpage,
			final int pageunit, final Object... Params) throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query q = session.createQuery(hql);
						if (Params != null && Params.length > 0) { // 取出可变参数中设置的条件
							int i = 0;
							for (Object obj : Params) {
								if (obj != null) {
									q.setString(i, obj.toString());
									i++;
								}
							}
						}
						// q.setFirstResult((currentpage-1)*pageunit); //分页展现
						// q.setMaxResults(pageunit);
						try {
							page(q, currentpage, pageunit);
						} catch (BaseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						List list = q.list();
						return list;
					}
				});
	}

	/**
	 * 利用HQL进行分页查询对象
	 * 
	 * @param hql
	 *            传入想要查询的HQL语句
	 * @param currentpage
	 *            当前顄1�7
	 * @param pageunit
	 *            分页单位
	 * @param Params
	 *            可变参数，给传入HQL语句帄1�7"?"的部分赋值（也就是加入条件）
	 * @return 封装了查询结果（对象）的List容器
	 */
	/*
	 * public List query(String hql, int currentpage, int pageunit, Object...
	 * Params){ Query q = this.getSession().createQuery(hql); if(Params != null &&
	 * Params.length > 0){ //取出可变参数中设置的条件 int i = 0; for(Object obj : Params){
	 * q.setString(i, obj.toString()); i++; } }
	 * q.setFirstResult((currentpage-1)*pageunit); //分页展现
	 * q.setMaxResults(pageunit); this.page(q, currentpage, pageunit); List list =
	 * q.list(); return list; }
	 */
	/**
	 * 将Query查询对象进行分页展现的方泄1�7
	 * 
	 * @param q
	 *            传入霄1�7要分页的Query查询对象
	 * @param currentpage
	 *            当前顄1�7
	 * @param pageunit
	 *            分页单位
	 * @return 分页后的Query查询对象
	 */
	public Query page(final Query q, final int currentpage, final int pageunit)
			throws BaseException {
		return (Query) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						q.setFirstResult((currentpage - 1) * pageunit);
						q.setMaxResults(pageunit);
						return q;
					}
				});
	}

	/**
	 * 将Query查询对象进行分页展现的方泄1�7
	 * 
	 * @param q
	 *            传入霄1�7要分页的Query查询对象
	 * @param currentpage
	 *            当前顄1�7
	 * @param pageunit
	 *            分页单位
	 * @return 分页后的Query查询对象
	 */
	/*
	 * public Query page(Query q, int currentpage, int pageunit){
	 * q.setFirstResult((currentpage-1)*pageunit); q.setMaxResults(pageunit);
	 * return q; }
	 */
	/**
	 * 用createCriteria进行查询某个类的对象，并可添加多个条仄1�7
	 * 
	 * @param c
	 *            要查询PO的类结构
	 * @param conditions
	 *            条件的可变参数，用createCriteria方法进行查询时，追加的多个条仄1�7
	 * @return 加条件过滤后扄1�7查询到对象的数量
	 *         <li>注意：setProjection（投影）对象得出对象数量
	 */
	public Object query(final Class c, final Criterion... conditions)
			throws BaseException {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(c);
				if (conditions != null && conditions.length > 0) {
					for (Criterion criterion : conditions) {
						criteria.add(criterion);
					}
				}
				return criteria.setProjection(Projections.rowCount())
						.uniqueResult();
			}
		});
	}

	/**
	 * 用createCriteria进行查询某个类的对象，并可添加多个条仄1�7
	 * 
	 * @param c
	 *            要查询PO的类结构
	 * @param conditions
	 *            条件的可变参数，用createCriteria方法进行查询时，追加的多个条仄1�7
	 * @return 加条件过滤后扄1�7查询到对象的数量
	 *         <li>注意：setProjection（投影）对象得出对象数量
	 */
	/*
	 * public Object query(Class c, Criterion... conditions){ Criteria criteria =
	 * this.getSession().createCriteria(c); if(conditions != null &&
	 * conditions.length > 0){ for(Criterion criterion : conditions){
	 * criteria.add(criterion); } } return
	 * criteria.setProjection(Projections.rowCount()).uniqueResult();
	 * //得出上面条件过滤后查询出对象的数量，使用的机制是count(*)到数据库中查的1�7 // return
	 * criteria.setProjection(Projections.count("id")).uniqueResult();
	 * //和上面的作用丄1�7样，使用的机制是：count(deptid) // return
	 * criteria.setProjection(Projections.avg("deptnum")).uniqueResult();
	 * //在投影中求平均�1�7�，返回的是Double // return criteria.list(); }
	 */
	/**
	 * 用createCriteria进行查询某个类的对象，并可添加多个条件，并分页进行显礄1�7
	 * 
	 * @param c
	 *            要查询PO的类结构
	 * @param incurrentpage
	 *            当前顄1�7
	 * @param pageunit
	 *            分页单位
	 * @param conditions
	 *            条件的可变参数，用createCriteria方法进行查询时，追加的多个条仄1�7
	 * @return 封装了分页后查询结果的List容器
	 */
	public List query(final Class c, final int incurrentpage,
			final int pageunit, final Criterion... conditions) throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(c);
						if (conditions != null && conditions.length > 0) {
							for (Criterion cri : conditions) {
								criteria.add(cri);
							}
							criteria.addOrder(Order.desc("id")); // 排序方案，这里也可以动�1�7�的传入客户想要排序的方案，传个Order就行
						}
						criteria.setFirstResult((incurrentpage - 1) * pageunit);
						criteria.setMaxResults(pageunit);
						return criteria.list();
					}
				});
	}

	/**
	 * 用createCriteria进行查询某个类的对象，并可添加多个条件，并分页进行显礄1�7
	 * 
	 * @param c
	 *            要查询PO的类结构
	 * @param incurrentpage
	 *            当前顄1�7
	 * @param pageunit
	 *            分页单位
	 * @param conditions
	 *            条件的可变参数，用createCriteria方法进行查询时，追加的多个条仄1�7
	 * @return 封装了分页后查询结果的List容器
	 */
	/*
	 * public List query(Class c, int incurrentpage, int pageunit, Criterion...
	 * conditions){ Criteria criteria = this.getSession().createCriteria(c);
	 * if(conditions != null && conditions.length > 0){ for(Criterion cri :
	 * conditions){ criteria.add(cri); } criteria.addOrder(Order.desc("id"));
	 * //排序方案，这里也可以动�1�7�的传入客户想要排序的方案，传个Order就行 }
	 * criteria.setFirstResult((incurrentpage-1)*pageunit);
	 * criteria.setMaxResults(pageunit); return criteria.list(); }
	 */
	/**
	 * A->guofei;
	 * 在这里要注意的是；在那个baseDaoi里面丄1�7般把包裹日期在内的基本的类型都都强制转化成了String类型；然而象Clob,Blob这样的类型就不能强制转化成String类型了，否则就抱错了啊；
	 * 扄1�7以在进行转化成String 类型时要充分的�1�7�虑到可能的各种类型(或�1�7�是 设置些参数可以让使用者自由的进行的参数定义转捄1�7)＄1�7---霄1�7要完善中
	 * 此方法主要�1�7�用对用复杂的原生sql进行查询的的结果集的封装,使用的时候一定要注意两点＄1�7�原生sql返回的字段的顺序咄1�7
	 * 个数必须和fanmes参数里的元素对应
	 * 
	 * @param objs
	 *            原生sql查询产生的object数组结果雄1�7
	 * @param fnames
	 *            被封装成的对象的属�1�7�1�7
	 * @param clas
	 *            被封装对象的Class
	 * @return 被封装对象的list
	 */
	public List createDO(final Object[] objs, final List<String> fnames,
			final Class clas) throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						List dos = new Vector();
						if (objs[0].getClass().isArray())
							;
						{
							for (int i = 0; i < objs.length; i++) {
								int ml = ((Object[]) objs[i]).length;
								Object obj = null;
								try {
									obj = clas.newInstance();
								} catch (InstantiationException e1) {
									e1.printStackTrace();
								} catch (IllegalAccessException e1) {
									e1.printStackTrace();
								}
								for (int j = 0; j < ml; j++) {
									Field field;
									try {
										field = clas.getDeclaredField(fnames
												.get(j).toString());
										Class fclass = field.getType();
										Method m = clas.getDeclaredMethod("set"
												+ fnames.get(j).toString()
														.substring(0, 1)
														.toUpperCase()
												+ fnames.get(j).toString()
														.substring(1),
												new Class[] { fclass });
										
												m.invoke(
														obj,
														new Object[] { (String) (((Object[]) objs[i])[j]) });
									} catch (SecurityException e) {
										e.printStackTrace();
									} catch (NoSuchFieldException e) {
									} catch (NoSuchMethodException e) {
										e.printStackTrace();
									} catch (IllegalArgumentException e) {
										e.printStackTrace();
									} catch (IllegalAccessException e) {
										e.printStackTrace();
									} catch (InvocationTargetException e) {
										e.printStackTrace();
									}
								}
								dos.add(obj);
							}
						}
						return dos;
					}
				});
	}

	/**
	 * 在这里要注意的是；在那个baseDaoi里面丄1�7般把包裹日期在内的基本的类型都都强制转化成了String类型；然而象Clob,Blob这样的类型就不能强制转化成String类型了，否则就抱错了啊；
	 * 扄1�7以在进行转化成String 类型时要充分的�1�7�虑到可能的各种类型(或�1�7�是 设置些参数可以让使用者自由的进行的参数定义转捄1�7)＄1�7---霄1�7要完善中
	 * 此方法主要�1�7�用对用复杂的原生sql进行查询的的结果集的封装,使用的时候一定要注意两点＄1�7�原生sql返回的字段的顺序咄1�7
	 * 个数必须和fanmes参数里的元素对应
	 * 
	 * @param objs
	 *            原生sql查询产生的object数组结果雄1�7
	 * @param fnames
	 *            被封装成的对象的属�1�7�1�7
	 * @param clas
	 *            被封装对象的Class
	 * @return 被封装对象的list
	 */
	
	/*
	 * public List getDatasBysql(String sql, List fnames) { 
	 * Auto-generated method stub return null; }
	 */
	public List getDatasBysql(final String sql, final List<String> fnames)
			throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						SQLQuery sqlquery = session.createSQLQuery(sql);
						for (String s : fnames) {
							sqlquery.addScalar(s, Hibernate.STRING);
						}

						return sqlquery.list();
					}
				});
	}

	public List getDatasBysql(final String sql, final List<String> fnames,
			final Integer curpage, final Integer pageunit) throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						SQLQuery sqlquery = session.createSQLQuery(sql);
						for (String s : fnames) {
							sqlquery.addScalar(s, Hibernate.STRING);
						}
						sqlquery.setFirstResult((curpage - 1) * pageunit);
						sqlquery.setMaxResults(pageunit);
						return sqlquery.list();
					}
				});
	}

	public List createMyDO(final String sql, final List fnames, final Class clas)
			throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@SuppressWarnings("unchecked")
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						try {
							List datas = getDatasBysql(sql, fnames);
							if (datas.toArray().length <= 0)
								return datas;
							List myDOdatas = createDO(datas.toArray(), fnames,
									clas);
							return myDOdatas;
						} catch (BaseException e) {
							e.printStackTrace();
						}
						return null;
					}
				});
	}

	public List createMyDO(final String sql, final List fnames,
			final Integer curpage, final Integer pageunit, final Class clas)
			throws BaseException {
		return (List) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@SuppressWarnings("unchecked")
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						try {
							List datas = getDatasBysql(sql, fnames, curpage,
									pageunit);
							if (datas.toArray().length <= 0)
								return datas;
							List myDOdatas = createDO(datas.toArray(), fnames,
									clas);
							return myDOdatas;
						} catch (BaseException e) {
							e.printStackTrace();
						}
						return null;
					}
				});
	}

	public int getCountBySql(final String sql, final String asname)
			throws BaseException {
		return (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						return session.createSQLQuery(sql).addScalar(asname,
								Hibernate.INTEGER).uniqueResult();
					}
				});
	}

	public void testHql1() {
		final String hql = "from Sqgzl A where A.sqrq>to_date('2008-12-20','yyyy-MM-dd')";
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = session.createQuery(hql).list();
				return list;
			}
		});

	}

	/**
	 * 注意此方法除了能执行“增删改”等更新操作，还能执行create table,alter table 等这样的DDL语句...
	 * 注意本方泄1�7 设计的表名或者属性必须为数据库中的字段和表名，不能为实体的名称和属�1�7�1�7
	 * @param sql
	 */
	public void executeBySql(final String sql) {

		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Connection conn = session.connection();
				PreparedStatement ps = conn.prepareStatement(sql);
				int h = ps.executeUpdate();
				ps.close();
				return h;
			}
		});
	}
	/**
	 * 注意此方法除了能执行“增删改”等更新操作，还能执行create table,alter table 等这样的DDL语句...
	 * 注意本方泄1�7 设计的表名或者属性必须为实体的名称和属�1�7�1�7
	 * @param sql
	 */
	public void executeByHql(final String sql) {

		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query queryupdate=session.createQuery(sql);
				int ret=queryupdate.executeUpdate();
				return ret;
			}
		});
	}
	/**
	 * 为自定义表单浏览时得到相应数据定刄1�7
	 * 此方法转用作 自定义表单；
	 * @param sql
	 */
	/*
	 * public Map<String ,Object> executeQueryBySql(final String sql,final Set<Formfiled>
	 * fileds) {
	 * 
	 * return (Map<String,Object>)this.getHibernateTemplate().execute(new
	 * HibernateCallback(){ public Object doInHibernate(Session session) throws
	 * HibernateException, SQLException { Connection conn=session.connection();
	 * Statement st = conn.createStatement(); ResultSet rs
	 * =st.executeQuery(sql); Map map = new HashMap(0); if(rs.next()){ for
	 * (Formfiled filed : fileds) { //System.out.println(filed.getFiledcode());
	 * //System.out.println(rs.getString(filed.getFiledcode()));
	 * map.put(filed.getFiledcode(),rs.getObject(filed.getFiledcode())==null?
	 * "":rs.getObject(filed.getFiledcode())); } } st.close(); return map; } } ); }
	 */
	public void clearTran() {

		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				session.flush();
				return null;
			}
		});

	}

}
