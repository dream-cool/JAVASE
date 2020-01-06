package sort;

import java.util.Arrays;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 19:11 2019/7/2
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr1 = {165, 6, 23, 798, 15, 649, 13, 496};
        int[] arr = {10, 78, 0, 23, -567, 0};
        int[] arr2 = new int[100];
        for (int i = 0; i < 100; i++) {
            arr2[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr2));
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr2));
    }

    public static void quickSort2(int[] arr,int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while( l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while( arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while(arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if( l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值  后移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值  前移
            if(arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort(arr, l, right);
        }
    }


    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int middle = arr[(right + left)/2];
        int m = (right+left)/2;
        int temp = 0;
        while (left < right) {
            while (arr[left] <= middle && left < m){
                left++;
            }
            while (arr[right] >= middle && right > m){
                right--;
            }
            if (left >= right){
                break;
            }
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        if (left == right){
            left++;
            right--;
        }
        if (l < right){
            quickSort(arr, l, right);
        }
        if (r > left){
            quickSort(arr, left, r);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort1(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int base = arr[l];
        int temp = 0;
        while (left < right) {
            while (arr[left] < base){
                left++;
            }
            while (arr[right] > base){
                right--;
            }
            if (left == right){
                if (base > arr[left]){
                    temp = arr[right];
                    arr[right] = arr[left];
                    arr[left] = temp;
                }
                left++;
                right--;
            } else {
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }

        }
        if (l < right){
            quickSort1(arr, l, right);
        }
        if (r > left){
            quickSort1(arr, left, r);
        }
        System.out.println(Arrays.toString(arr));
    }
}
