package com.oti.myuniversity.component;

import static com.oti.myuniversity.common.Consts.DATE_FORMAT;
import static com.oti.myuniversity.common.Consts.TIME_FORMAT;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class ServerTimeSupplier {
	private static Timestamp record;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);
	
	public static int getDayOfWeek() {
		Calendar rightNow = Calendar.getInstance();
		int day = rightNow.get(Calendar.DAY_OF_WEEK);
		return day;
	}
	
	public ServerTimeSupplier() {
		setTime();
	}

	public static void setTime() {
		record = new Timestamp(System.currentTimeMillis());
	}
	
	public static String checkTime() {
		if (record == null) {
			record = new Timestamp(System.currentTimeMillis());
		}
		return record.toString();
	}
	
	public static Date getDate() {
		return Date.valueOf(dateFormat.format(record));
	}
	
	public static Timestamp getTime() {
		return Timestamp.valueOf(timeFormat.format(record));
	}
}
