package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 1、后台管理系统的跳转controller
 * @author admin
 *
 */
@Controller
@RequestMapping(value="/manage")
public class IndexController {
	
	/**
	 * 1、跳转到main的页面
	 * @return
	 */
	@RequestMapping(value="/main")
	public String index(){
		return "manage/main";
	}
	
	/**
	 * 2、跳转到商品添加的页面
	 * @return
	 */
	@RequestMapping(value="/goto_spu.do")
	public String goto_spu(){
		return "manage/spu";
	}
	
	/**
	 * 3、跳转到属性值的页面
	 * @return
	 */
	@RequestMapping(value="/goto_attr")
	public String goto_attr(){
		return "spu/attr";
	}
}
