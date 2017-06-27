package com.cesystem.util;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author ÓÚ½­ĞË
 *
 */
public class ResponseMapUtil {
	public static Map<String,Object> responseSuccess(Object o){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", true);
		map.put("data", o);
		return map;
	}
	
	public static Map<String,Object> responseError(String message){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", false);
		map.put("message", message);
		return map;
	}
	public static Map<String,Object> responseSuccessMess(String message){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", true);
		map.put("message", message);
		return map;
	}
}
