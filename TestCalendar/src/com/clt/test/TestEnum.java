package com.clt.test;
/**
 * ����ö��
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
		 System.out.println("����");
		 break;
		case AUTUMN:
		 System.out.println("����");
		}

	}

}
enum Season{
	SPRING,SUMMER,AUTUMN,WINTER;
}
enum Week{
	����һ,���ڶ�,������,������,������,������,������;
}
