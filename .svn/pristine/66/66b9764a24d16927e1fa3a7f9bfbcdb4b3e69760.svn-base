package com.cesystem.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUseUtil {

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Timestamp nowTime() {
		Timestamp nowTimestamp = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		Date date = new Date();
		long s = date.getTime();
		nowTimestamp = Timestamp.valueOf(df.format(date));

		return nowTimestamp;
	}

}
