package com.First;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort{


    public static void main(String[] args) {
        BubbleSort b=new BubbleSort();


        //随机数方法
//        int a[]=b.sortRandom();
//        b.bubble(a);
//
//
////      //example方法
//        char a[]={'E','X','A','M','P','L','E'};
//        b.bubble(a);
//
        int a[]=b.inPutData();
        b.bubble(a);

        System.out.println("完全排序后的数组");
        System.out.println(Arrays.toString(a));

    }

    public  int[] inPutData(){ //输入待排序数据
        System.out.println("请输入将要排序的数量");
        Scanner sc = new Scanner(System.in);
        int number=sc.nextInt();
        int a[] = new int[number];
        System.out.println("请输入待排序数组");
        for(int i=0;i<number;i++){
            a[i]=sc.nextInt();
        }
        return  a;
    }

    public int[] sortRandom() {
        int a[] = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            a[i]=random.nextInt(100)+1;
        }
        System.out.println("随机数为");
        System.out.println(Arrays.toString(a));
        System.out.println("");
        return a;
    }

    public void bubble(int a[]){  //冒泡排序方法
        int i,j,temp;
        for(i=0;i<a.length;i++){
            System.out.println("第"+i+"次排序后的数组!");
            System.out.println(Arrays.toString(a));
            for(j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

    public void bubble(char a[]){  //冒泡排序方法
        int i,j;
        char temp;
        for(i=0;i<a.length;i++){
            System.out.println("第"+i+"次排序后的数组!");
            System.out.println(Arrays.toString(a));
            for(j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

}
