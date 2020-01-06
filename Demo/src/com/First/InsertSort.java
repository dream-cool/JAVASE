package com.First;
import com.First.BubbleSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertSort {

    public static void main(String[] args) {

        InsertSort insertSort=new InsertSort();

        //随机数方法
//        int a[]=insertSort.sortRandom();
//        insertSort.insertion(a);

        //example方法
//        char a[]={'E','X','A','M','P','L','E'};
//        insertSort.insertion(a);

        //输入数组方法
        int a[]=insertSort.inPutData();
        insertSort.insertion(a);

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
    public void insertion(int a[]){
        int i,j,temp;
        for(i=1;i<a.length;i++){
            System.out.println("第"+i+"次排序后的数组!");
            System.out.println(Arrays.toString(a));
            temp=a[i];
            for(j = i;j > 0&& a[j - 1] > temp;j--)
                a[j]= a[j - 1];
            a[j] = temp;
        }
    }

    public void insertion(char a[]){
        int i,j;
        char temp;
        for(i=1;i<a.length;i++){
            System.out.println("第"+i+"次排序后的数组!");
            System.out.println("");
            System.out.println(Arrays.toString(a));
            System.out.println("");
            temp=a[i];
            for(j = i;j > 0&& a[j - 1] > temp;j--)
                a[j]= a[j - 1];
            a[j] = temp;
        }
    }
}
