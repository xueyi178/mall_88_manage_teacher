package com.atguigu.mapper;

import java.util.Map;

import com.atguigu.bean.T_MALL_PRODUCT;

/**
 * 1、spu的数据访问层接口
 * @author admin
 *
 */
public interface SpuMapper {

	/**
	 * 1、添加spu
	 * @param product
	 */
	void inser_spu(T_MALL_PRODUCT product);

	/**
	 * 向数据库中插入商品图片
	 * @param map
	 */
	void inser_images(Map<String, Object> map);
}
