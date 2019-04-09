package com.atguigu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.atguigu.dto.MODEL_T_MALL_ATTR;
import com.atguigu.dto.OBJECT_T_MALL_ATTR;
import com.atguigu.mapper.AttrMapper;
import com.atguigu.service.IAttrService;
/**
 * 1、属性的业务逻辑层实现类
 * @author admin
 *
 */
@Service
public class AttrServiceImpl implements IAttrService {
	
	/**注入商品属性的dao*/
	@Autowired
	private AttrMapper attrMapper;
	
	/**
	 * 1、保存商品属性
	 */
	@Override
	public void save_attr(Integer flbh2, List<OBJECT_T_MALL_ATTR> list_attr) {
		for (int i = 0; i < list_attr.size(); i++) {
			//插入属性,返回主键id
			OBJECT_T_MALL_ATTR attr = list_attr.get(i);
			attrMapper.insert_attr(flbh2, attr);
			
			//获得返回主键批量插入属性值
			attrMapper.insert_values(attr.getId(), attr.getList_value());
		}
	}


	/**
	 * 2、根据商品属性表的flbh2去查询商品属性
	 * @param flbh2
	 */
	@Override
	public List<OBJECT_T_MALL_ATTR> get_attr_list(Integer flbh2) {
		List<OBJECT_T_MALL_ATTR> list_attr = attrMapper.get_attr_list(flbh2);
		Assert.notEmpty(list_attr,"查询数据有误,请重新查询");
		return list_attr;
	}
}