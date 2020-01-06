/**
 * @ Author   ：clt.
 * @ Date     ：Created in 10:51 2019/7/14
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,3,5,7,9,11,11,11,11,11,13,42,66,69};
        System.out.println(GetNumberOfK(arr,1));
        System.out.println(GetNumberOfK(arr,11));
    }
    public static int GetNumberOfK(int [] array , int k) {
        if (array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length-1;
        int mid;
        int count = 0;
        do{
            mid = (left + right)/2;
            if (array[mid] >  k){
                right = mid - 1;
            } else if (array[mid] < k ){
                left = mid + 1;
            } else{
                int temp = mid;
                count++;
                while (temp > 0 && array[--temp] == array[mid]){
                    count++;
                }
                temp = mid;
                while (temp < array.length-1 && array[++temp] == array[mid]){
                    count++;
                }
                return count;
            }
        }while (left <= right);
        return  0;
    }
}
