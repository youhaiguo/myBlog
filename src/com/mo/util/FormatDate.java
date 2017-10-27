package com.mo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {

	/**
	 * 将一个日期转换为格式化的String字符串
	 * @param date
	 * @return
	 */
	public static String changeDateToString(Date date) {  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return sdf.format(date);
	}  

}
