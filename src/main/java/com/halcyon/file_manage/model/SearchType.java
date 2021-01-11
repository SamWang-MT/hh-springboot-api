package com.halcyon.file_manage.model;

public class SearchType {
	
	static final String ORDER_DEC = "desc"; // down
	static final String ORDER_AEC = "asc"; // up

	private String type;
	private String orderType;
	private String order = ORDER_AEC;

	private String condition;
	
/**
 * 	模糊查询请求创建
 * @param type 			模糊查询的字段名
 * @param condition		模糊字段值
 * @param orderType		排序字段
 * @param order_desc	是否降序
 */

	public SearchType(String type,String condition,String orderType, Boolean order_desc ) {
		super();
		this.type = type;
		this.orderType = orderType;
		this.setOrder(order);
		this.condition = condition;
		if (order_desc) {
			this.order = ORDER_DEC;
		}
		
		
	}

	public SearchType() {
		super();
	}

	
	/**
	 * 模糊查询请求创建
	 * @param type 			模糊查询的字段名
	 * @param condition		模糊字段值
	 * @param orderType		排序默认同查询字段
	 * @param order_desc	默认升序
	 * 
	 */
	public SearchType(String type, String condition) {
		super();
		this.type = type;
		this.orderType = type;
		this.condition = condition;
		
	}

	
	
	
	public SearchType(String type, String orderType, String condition) {
		super();
		this.type = type;
		this.orderType = orderType;
		this.condition = condition;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getType() {
		return type;

	}
	public void setType(String type) {
		this.type = type;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}