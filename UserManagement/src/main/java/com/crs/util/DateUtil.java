package com.crs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	
	public String getMySqlDate(Date date)
	{
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate= sdf.format(date);
		return strDate;
		
	}

}
