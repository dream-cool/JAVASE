package secondday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 18:55 2019/7/10
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Main4 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(arr[1].length);
        System.out.println(arr.length);
        System.out.println(Find(5, arr));
    }
    public static boolean Find(int target, int [][] array) {
        int j = 0;
        int i = array.length-1;
        while( i >= 0 && j <= array[i].length-1 ){
            if(target > array[i][j]){
                j++;
            } else if(target < array[i][j]){
                i--;
            } else{
                return true;
            }
        }
        return false;
    }
}
