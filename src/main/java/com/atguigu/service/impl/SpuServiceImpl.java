package com.atguigu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.T_MALL_PRODUCT;
import com.atguigu.mapper.SpuMapper;
import com.atguigu.service.SpuService;

/**
 * 1、spu的业务逻辑层实现类
 * @author admin
 *
 */
@Service
public class SpuServiceImpl implements SpuService{

	@Autowired
	private SpuMapper spuMapper;

	/**
	 * 1、添加商品信息
	 */
	@Override
	public void save_spu(List<String> list_image,T_MALL_PRODUCT spu) {
		//给商品图片循环赋值
		for (String tp : list_image) {
			spu.setShp_tp(tp);
		}
		//1、添加商品信息,会把商品主键给返回
		spuMapper.inser_spu(spu);
		
		//2、根据spu的主键信息,插入商品图片
		Map<String, Object> map = new HashMap<>();
		map.clear();
		map.put("shp_id", spu.getId());
		map.put("list_image", list_image);
		spuMapper.inser_images(map);
	}
}
