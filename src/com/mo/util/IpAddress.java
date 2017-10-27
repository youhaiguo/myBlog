package com.mo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class IpAddress {

	/**
	 * 传人一个ip返回一个地理位置
	 * @param ip
	 * @return
	 */
	public static String changeIpToAddress(String ip) {
		Map<String, String> map = changeJsonToMap(getAddressByIp(ip));
		String country = revert(map.get("country"));
		String province = revert(map.get("province"));
		String city = revert(map.get("city"));
		return country + " " + province + " " + city + " ";
	}
	
	/**
	 * 传人一个ip返回一个地理位置(只有省市)
	 * @param ip
	 * @return
	 */
	public static String changeIpToAddressOnlyProAndCity(String ip) {
		Map<String, String> map = changeJsonToMap(getAddressByIp(ip));
		String province = revert(map.get("province"));
		String city = revert(map.get("city"));
		return province + " " + city;
	}
	
	/**
	 * 传人ip地址，出来的是unicode编码的json数据
	 * @return json字符串
	 * @throws IOException
	 */
	private static String getAddressByIp(String ip) {
		StringBuffer result;
		try {
			URL url = new URL("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=" + ip);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line = null;
			result = new StringBuffer();
			while((line = reader.readLine()) != null) {
				result.append(line);
			}	
			reader.close();
			return result.toString();
		} catch (IOException e) {
			System.out.println("ip没有找到");
		}
		return "无法找到ip地址";
	}


	/**
	 * 将传人的JSON字符串封装为Map
	 * @param json字符串
	 * @return 封装了map的json的数据
	 */
	private static Map<String, String> changeJsonToMap(String address) {
		Map maps = (Map)JSON.parse(address);  
		return maps;
	}

	/**
	 * 将unicode转换为文字
	 * @param 传人一个unicode编码
	 * @return 返回一个汉字
	 */
	private static String revert(String str) 
	{ 
		str = (str == null ? "" : str); 
		if (str.indexOf("\\u") == -1)//如果不是unicode码则原样返回 
			return str; 

		StringBuffer sb = new StringBuffer(1000); 

		for (int i = 0; i < str.length() - 6;) 
		{ 
			String strTemp = str.substring(i, i + 6); 
			String value = strTemp.substring(2); 
			int c = 0; 
			for (int j = 0; j < value.length(); j++) 
			{ 
				char tempChar = value.charAt(j); 
				int t = 0; 
				switch (tempChar) 
				{ 
				case 'a': 
					t = 10; 
					break; 
				case 'b': 
					t = 11; 
					break; 
				case 'c': 
					t = 12; 
					break; 
				case 'd': 
					t = 13; 
					break; 
				case 'e': 
					t = 14; 
					break; 
				case 'f': 
					t = 15; 
					break; 
				default: 
					t = tempChar - 48; 
					break; 
				} 

				c += t * ((int) Math.pow(16, (value.length() - j - 1))); 
			} 
			sb.append((char) c); 
			i = i + 6; 
		} 
		return sb.toString(); 
	}
}
