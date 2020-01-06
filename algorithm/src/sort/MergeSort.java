package sort;

import java.util.Arrays;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 9:22 2019/7/4
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        int[] temp = new int[arr.length];
        merge(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            merge(arr, left, mid, temp);
            merge(arr, mid + 1, right, temp);
            mergeSort(arr, left, mid, right, temp);
        }
    }

    public static void mergeSort(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        while (i <= mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        t = 0;
        while (left <= right){
            arr[left] = temp[t];
            t++;
            left++;
        }
    }
}
