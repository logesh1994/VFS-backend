package com.cognizant.outreach.vfs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

	public static Date getUtilDate(String dateString, String format) throws Exception {
		return new SimpleDateFormat(format).parse(dateString);  
	}
}
