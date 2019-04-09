package com.atguigu.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.mchange.lang.ObjectUtils;

/**
 * 1、java中只有值传递
 * @author admin
 *
 */
public class Test2 {

	public static void main(String[] args) {
		String s = "";
		String b = null;
		Assert.notNull(s, "ssssssssss");
		//Assert.notNull(b, "bbbbbbbbb");
		System.out.println(s==b);
	}
}