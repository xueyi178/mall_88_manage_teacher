package com.atguigu.service;

import java.util.List;

import com.atguigu.dto.MODEL_T_MALL_ATTR;
import com.atguigu.dto.OBJECT_T_MALL_ATTR;

/**
 * 1、商品属性的业务逻辑层接口
 * @author admin
 *
 */
public interface IAttrService {
	/**
	 * 1、保存商品属性
	 * @param flbh2
	 * @param list_attr
	 */
	void save_attr(Integer flbh2, List<OBJECT_T_MALL_ATTR> list_attr);

	/**
	 * 2、根据商品属性表的flbh2去查询商品属性
	 * @param flbh2
	 * @return 
	 */
	List<OBJECT_T_MALL_ATTR> get_attr_list(Integer flbh2);

}
