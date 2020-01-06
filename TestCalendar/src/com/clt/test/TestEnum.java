package com.clt.test;
/**
 * 测试枚举
 * @author Mrchen
 *
 */
public class TestEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Season.SPRING);
		Season a=Season.AUTUMN;
		switch(a) {
		case SPRING:
		 System.out.println("春天");
		 break;
		case AUTUMN:
		 System.out.println("夏天");
		}

	}

}
enum Season{
	SPRING,SUMMER,AUTUMN,WINTER;
}
enum Week{
	星期一,星期二,星期三,星期四,星期五,星期六,星期日;
}
