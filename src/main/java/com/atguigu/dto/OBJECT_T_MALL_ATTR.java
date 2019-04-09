package com.atguigu.dto;

import java.util.List;
import com.atguigu.bean.T_MALL_ATTR;
import com.atguigu.bean.T_MALL_VALUE;
/**
 * 1、商品属性包装类
 * @author admin
 *
 */
public class OBJECT_T_MALL_ATTR extends T_MALL_ATTR{
	//属性值表
	private List<T_MALL_VALUE> list_value;

	public List<T_MALL_VALUE> getList_value() {
		return list_value;
	}

	public void setList_value(List<T_MALL_VALUE> list_value) {
		this.list_value = list_value;
	}
}
