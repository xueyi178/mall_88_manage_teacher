package com.atguigu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.atguigu.bean.T_MALL_VALUE;
import com.atguigu.dto.OBJECT_T_MALL_ATTR;

/**
 * 1、商品属性的数据访问层接口
 * @author admin
 *
 */
public interface AttrMapper {
	/**
	 * 1、添加商品属性
	 * @param flbh2
	 * @param attr
	 */
	void insert_attr(@Param("flbh2") Integer flbh2,@Param("attr") OBJECT_T_MALL_ATTR attr);

	/**
	 * 2、添加商品属性值
	 * @param attr_id
	 * @param list_values
	 */
	void insert_values(@Param("attr_id") Integer attr_id,@Param("list_values") List<T_MALL_VALUE> list_values);

	/**
	 * 3、根据商品属性表的flbh2去查询商品属性
	 * @param flbh2
	 * @return
	 */
	List<OBJECT_T_MALL_ATTR> get_attr_list(Integer flbh2);
}
