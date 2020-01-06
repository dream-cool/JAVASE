package com.Second;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {

//        //example方法
//        char a[]={'E','X','A','M','P','L','E'};
//        System.out.println(Arrays.toString(a));
//        System.out.println();
//        quickSort(a,0,6);

        //输入数排序
        int a[]=inPutData();
        quickSort(a,0,a.length-1);

        //随机数方法
//        int a[]=sortRandom();
//        quickSort(a,0,99);
//        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int arr[],int start,int end)
        {
            if (start >= end) return;
            int i = start;
            int j = end;
            // 基准数
            int baseval = arr[start];
            while (i < j)
            {
                // 从右向左找比基准数小的数
                while (i < j && arr[j] >= baseval)
                {
                    j--;
                }
                if (i < j)
                {
                    arr[i] = arr[j];
                    i++;
                }
                // 从左向右找比基准数大的数
                while (i < j && arr[i] < baseval)
                {
                    i++;
                }
                if (i < j)
                {
                    arr[j] = arr[i];
                    j--;
                }
            }
            // 把基准数放到i的位置
            arr[i] = baseval;
            // 递归
            System.out.println(Arrays.toString(arr));
            quickSort(arr,start,i-1);
            quickSort(arr, i + 1, end);
        }

    public static void quickSort(char arr[],int start,int end)
    {
        if (start >= end) return;
        int i = start;
        int j = end;
        // 基准数
        char baseval = arr[start];
        while (i < j)
        {
            // 从右向左找比基准数小的数
            while (i < j && arr[j] >= baseval)
            {
                j--;
            }
            if (i < j)
            {
                arr[i] = arr[j];
                i++;
            }
            // 从左向右找比基准数大的数
            while (i < j && arr[i] < baseval)
            {
                i++;
            }
            if (i < j)
            {
                arr[j] = arr[i];
                j--;
            }
        }
        // 把基准数放到i的位置
        arr[i] = baseval;
        // 递归
        System.out.println(Arrays.toString(arr));

        quickSort(arr,start,i-1);
        quickSort(arr, i + 1, end);
    }

    public static int[] sortRandom() {
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

    public  static int[] inPutData(){ //输入待排序数据
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
}
