package com.halcyon.file_manage.tools;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.druid.sql.visitor.functions.If;
import com.halcyon.file_manage.annotations.FM_Constants;
import com.halcyon.file_manage.model.Archive;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName: SqlConditionUtils
 * @author: Merdader
 * @Date: Feb. 8, 2021 7:37:19 p.m.
 * 
 * @description:
 */

public class FM_SqlUtils {
	public static Map<String, Object> createQueryMap(String... arg) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		for (int i = 0; i < arg.length; i++) {
				
			queryMap.put(arg[i], arg[++i]);
		}
		return queryMap;
	}

	/**
	 * 创建Condition
	 * @param <E>
	 * @param beanClass
	 * @param arg
	 * @return
	 */
	public static <E> Condition getCondition(Class<E> beanClass, String... arg){
		
		Map<String, Object> queryMap = createQueryMap(arg);
		return createConditions(beanClass, queryMap);
	}

	/**
	 * 
	 * @param <E>
	 * @param beanClass
	 * @param order
	 * @param orderType
	 * @param arg 字段1名，字段1值，字段21名，字段2值...
	 * @return
	 */
	/*
	 * public static <E> Condition getCondition(Class<E> beanClass, String
	 * order,String orderType,String... arg){
	 * 
	 * Map<String, Object> queryMap = createQueryMap(arg); return
	 * createConditions(beanClass, queryMap,order,orderType); }
	 * 
	 */
	/**
	 * create FM condition query
	 * 
	 * @param <E>
	 * @param queryMap
	 * @param orderName
	 * @param orderType
	 * @return
	 */
	public static <E> Condition createConditions(Class<E> beanClass, Map<String, Object> queryMap, String orderName,
			String orderType) {
		Condition condition = new Condition(beanClass, false, false);
//		Criteria createCriteria = condition.createCriteria();
		if (CollectionUtil.isEmpty(queryMap)) {
			return condition;
		}
		for (String key : queryMap.keySet()) {
			condition.createCriteria();
			
			if (StrUtil.isBlankIfStr( queryMap.get(key))|| "0".equals(queryMap.get(key))) {
				continue;
			}
			if (key.startsWith("_")) {
				setLikeConditon(condition, key, queryMap.get(key).toString());
			}else if (key.startsWith("$")) {
				setBTConditon(condition, key, queryMap.get(key).toString());
			} else {
				setEQConditon(condition, key, queryMap.get(key).toString());
			}
		}
		setOderConditon(condition, orderName, orderType);
		return condition;
	}

	public static <E> Condition createConditions(Class<E> beanClass, Map<String, Object> queryMap) {
		return createConditions(beanClass, queryMap, "id", "desc");
	}

	private static void setOderConditon(Condition condition, String order, String orderType) {
		condition.setOrderByClause(order + " " + orderType);
	}

	private static void setEQConditon(Condition condition, String key, String value) {
		//Criteria criteria = condition.and();
		Criteria criteria = condition.getOredCriteria().get(0);
		criteria.andEqualTo(key, value);
	}
	
	private static void setBTConditon(Condition condition, String key, String value) {
		key = key.substring(1);
		if (value.indexOf(",")==-1) {
			return;
		}
		//Criteria criteria = condition.and();
		Criteria criteria = condition.getOredCriteria().get(0);
		
		String[] parms = StrUtil.split(value, FM_Constants.SEPARATOR_ID);		
		criteria.andBetween(key, parms[0], parms[1]);
	}
	

	private static void setLikeConditon(Condition condition, String key, String value) {
		key = key.substring(1);
//		Criteria criteria = condition.and();
		Criteria criteria = condition.getOredCriteria().get(0);
//		criteria.andCondition(key + " like ", "%"+ value + "%");
		criteria.andLike(key, "%"+ value + "%");
	}

}
