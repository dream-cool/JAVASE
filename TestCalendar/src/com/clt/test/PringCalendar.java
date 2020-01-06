package com.clt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历测试
 * @author Mrchen
 *
 */

public class PringCalendar {
	public static void main(String[] args) throws ParseException {
		System.out.println("请输入日期！格式(2019年4月4日)");
		Scanner sc=new Scanner(System.in);
		String DT=sc.nextLine();
		DateFormat df=new SimpleDateFormat("yyyy年MM月dd日");
		Date date=df.parse(DT);
		Calendar c=new GregorianCalendar();
		c.setTime(date);
		int day=c.get(Calendar.DAY_OF_MONTH);
	    System.out.println("日\t一\t二\t三\t四\t五\t六");
	    c.set(Calendar.DAY_OF_MONTH,1); 
	    for(int i=1;i<c.get(Calendar.DAY_OF_WEEK);i++) {
	    	System.out.print("\t");
	    }
	    int days=c.getMaximum(Calendar.DATE);
	    for(int i=1;i<days;i++) {
	    	if(day==c.get(Calendar.DAY_OF_MONTH)) {
	    		System.out.print(c.get(Calendar.DAY_OF_MONTH)+"*"+"\t");
	    	}
	    	else
	    	System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
	    	if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
	    		System.out.println();
	    	}
	    	c.add(Calendar.DAY_OF_MONTH,1);
	    }
		
		
	}
}
