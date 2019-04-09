package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.T_MALL_PRODUCT;

/**
 * 1、spu的业务逻辑层接口
 * @author admin
 *
 */
public interface SpuService {
	/**
	 * 1、添加spu商品
	 * @param product
	 */
	void save_spu( List<String> list_image,T_MALL_PRODUCT spu);
}
