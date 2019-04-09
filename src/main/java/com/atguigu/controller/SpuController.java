package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.T_MALL_PRODUCT;
import com.atguigu.service.SpuService;
import com.atguigu.utils.MyFileUpload;
/**
 * 1、spu的controller
 * @author admin
 *
 */
@Controller
@RequestMapping(value="/spu")
public class SpuController {

	@Autowired
	private SpuService spuService;
	
	/**
	 * 1、跳转到添加spu的页面
	 * @return
	 */
	@RequestMapping(value="/goto_spu_add")
	public String goto_spu_add(){
		return "spu/spuadd";
	}
	
	
	/**
	 * 2、添加spu的信息
	 * @return
	 */
	@RequestMapping(value="/spu_add")
	public ModelAndView spu_add(@RequestParam("files") MultipartFile[] files,T_MALL_PRODUCT spu){
		//上传图片,返回集合类名
		List<String> list_image = MyFileUpload.upload_image(files);
		//保存商品信息
		spuService.save_spu(list_image,spu);
		
		//会根据url地址去读,
		ModelAndView modelAndView = new ModelAndView("redirect:/spu/goto_spu_add.do");
		//但是参数会重新方法modelAndView中
		modelAndView.addObject("flbh1", spu.getFlbh1());
		modelAndView.addObject("flbh2", spu.getFlbh2());
		modelAndView.addObject("pp_id", spu.getPp_id());
		return modelAndView;
	}
}
