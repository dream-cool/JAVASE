package com.First;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class SelectSort {

    /**
     * @param args
     */

    public static void main(String[] args) {
        SelectSort selectSort=new SelectSort();
//        int a[]=selectSort.sortRandom();
//        selectSort.selection(a);

        //example方法
//        char a[]={'E','X','A','M','P','L','E'};
//        selectSort.selection(a);

        //输入数组方法
        int a[]=selectSort.inPutData();
        selectSort.selection(a);

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
    public void selection(int a[]){
        int i,j,min,temp;
        for(i=0;i<a.length-1;i++){
            System.out.println("第"+i+"次排序后的数组!");
            System.out.println(Arrays.toString(a));
            min=i;
            for(j=i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min=j;
                }
            }
            if(min!=i){
                temp=a[min];
                a[min]=a[i];
                a[i]=temp;
            }
        }
    }
    public void selection(char a[]){
        int i,j,min;
        char temp;
        for(i=0;i<a.length-1;i++){
            System.out.println("第"+i+"次排序后的数组!");
            System.out.println("");
            System.out.println(Arrays.toString(a));
            System.out.println("");
            min=i;
            for(j=i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min=j;
                }
            }
            if(min!=i){
                temp=a[min];
                a[min]=a[i];
                a[i]=temp;
            }
        }
    }
}

