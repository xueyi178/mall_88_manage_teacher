package com.atguigu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 1、读取配置文件的
 * @author admin
 *
 */
public class MyPropertyUtil {

	public static String getProperty(String pro, String key) {
		//1、创建一个Properties,去读取配置文件
		Properties properties = new Properties();

		//2、返回一个流
		InputStream resourceAsStream = MyPropertyUtil.class.getClassLoader().getResourceAsStream(pro);

		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//3、获取键
		String property = properties.getProperty(key);
		
		return property;
	}
}
