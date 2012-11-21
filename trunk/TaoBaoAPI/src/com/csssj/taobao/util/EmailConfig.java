package com.csssj.taobao.util;

import com.pub.util.ConfigReader;

public class EmailConfig extends ConfigReader{
	static{
		add("email");
	}
	public static String value(String key){
		return value(key, "");
	}
	public static String value(String key,String def){
		return getValue("email", key, def);
	}
}
