    package com.conpany.project;

import java.util.List;

import cn.hutool.core.util.StrUtil;

/** 
     * @ClassName: Test01    
     * @author: Merdader
     * @Date: Feb. 8, 2021 5:43:15 p.m.
	 * 
	 * @description: 
     */

public class Test01 {
	public static void main(String[] args) {
		String str = ", ,,0,de,  \n ,12,";
		
		List<String> split = StrUtil.split(str,',', true, false);
		for (String string : split) {
			System.out.println("["+ string+"]");
		}
		
		
		
	}
}
 