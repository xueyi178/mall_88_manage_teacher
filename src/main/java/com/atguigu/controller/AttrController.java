package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.dto.MODEL_T_MALL_ATTR;
import com.atguigu.dto.OBJECT_T_MALL_ATTR;
import com.atguigu.service.IAttrService;
/**
 * 1、商品属性的控制层
 * @author admin
 *
 */
@Controller
@RequestMapping(value="/attr")
public class AttrController {

	/**注入商品属性的业务逻辑层接口*/
	@Autowired
	private IAttrService attrService;

	/**
	 * 1、跳转到添加商品属性值的页面
	 * @param modelMap
	 * @param spu
	 * @return
	 */
	@RequestMapping(value="/goto_attr_add")
	public String goto_spu_add(Integer flbh2,Model model){
		model.addAttribute("flbh2", flbh2);
		return "spu/attrAdd";
	}

	/**
	 * 2、提交商品属性的controller
	 * @return
	 */
	@RequestMapping(value="/attr_add")
	public ModelAndView attr_add(Integer flbh2,MODEL_T_MALL_ATTR list_attr){
		//保存商品属性
		Assert.notNull(flbh2, "属性编号不能为空");
		Assert.notNull(list_attr.getList_attr().get(0), "属性值不能为空");

		attrService.save_attr(flbh2, list_attr.getList_attr());
		//会根据url地址去读,
		ModelAndView modelAndView = new ModelAndView("redirect:/attr/goto_attr_add.do");
		//但是参数会重新方法modelAndView中
		modelAndView.addObject("flbh2",flbh2);
		return modelAndView;
	}

	/**
	 * 3、根据分类2的id,查询出属性表和具体的属性值
	 * @param flbh2
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/get_attr_list")
	public String get_attr_list(Integer flbh2,Model model){
		Assert.notNull(flbh2, "分类id不能为空");
		//根据商品属性的id去查
		List<OBJECT_T_MALL_ATTR> list_attr = attrService.get_attr_list(flbh2);
		model.addAttribute("flbh2", flbh2);
		model.addAttribute("list_attr", list_attr);
		return "spu/attrListInner";
	}
}
