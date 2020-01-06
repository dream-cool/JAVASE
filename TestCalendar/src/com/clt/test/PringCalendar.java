package com.clt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ���ӻ���������
 * @author Mrchen
 *
 */

public class PringCalendar {
	public static void main(String[] args) throws ParseException {
		System.out.println("���������ڣ���ʽ(2019��4��4��)");
		Scanner sc=new Scanner(System.in);
		String DT=sc.nextLine();
		DateFormat df=new SimpleDateFormat("yyyy��MM��dd��");
		Date date=df.parse(DT);
		Calendar c=new GregorianCalendar();
		c.setTime(date);
		int day=c.get(Calendar.DAY_OF_MONTH);
	    System.out.println("��\tһ\t��\t��\t��\t��\t��");
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
