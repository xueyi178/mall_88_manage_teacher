package com.atguigu.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
/**
 * 1、文件上传的工具类
 * @author admin
 *
 */
public class MyFileUpload {

	public static List<String> upload_image(MultipartFile[] files) {
			
		//1、通过MyPropertyUtil去读取配置文件,获取上传路径
		String path = MyPropertyUtil.getProperty("myUpload.proerties", "windows_path");

		List<String> list_image = new ArrayList<String>();

		for (int i = 0; i < files.length; i++) {
			//判断文件名是否为空
			if (!files[i].isEmpty()) {
				//获取上传的原始文件名,
				String originalFilename = files[i].getOriginalFilename();

				//对文件名,进行处理
				String name = System.currentTimeMillis() + originalFilename;
				//上传路径
				String upload_name = path + "/" + name;

				try {
					files[i].transferTo(new File(upload_name));
					//把文件名添加到集合中
					list_image.add(name);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//返回上传文件名
		return list_image;
	}
}
