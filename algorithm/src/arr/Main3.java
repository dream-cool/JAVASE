package arr;

import java.util.Random;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:50 2019/7/26
 */
public class Main3 {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = new Random().nextInt(1000000);
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(InversePairs1(arr));
        System.out.println(InversePairs2(arr));
    }

    public static int InversePairs1(int[] array) {
        long p = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    p++;
                }
            }
        }
        return (int) (p % 1000000007);
    }

    public static int InversePairs2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        return arrayCount(array, copy, 0, array.length - 1);
    }

    public static int arrayCount(int[] arr, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = arrayCount(arr, copy, low, mid)%1000000007;
        int rightCount = arrayCount(arr, copy, mid + 1, high)%1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int copyIndex = high;
        while (i >= low && j >= mid + 1) {
            if (arr[i] > arr[j]) {
                count = count + j - mid;
                copy[copyIndex--] = arr[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            } else {
                copy[copyIndex--] = arr[j--];
            }
        }
        for (; i >= low; i--) {
            copy[copyIndex--] = arr[i];
        }
        for (; j >= mid + 1; j--) {
            copy[copyIndex--] = arr[j];
        }
        for (int k = low; k <= high; k++) {
            arr[k] = copy[k];
        }
        return (leftCount+rightCount+count)%1000000007;
    }

}
