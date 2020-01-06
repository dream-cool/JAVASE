import java.util.Arrays;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i <n ; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(test(array));
    }
    public static int test(int[] array){
        int[] temp = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        int count = 0;
        for (int i = 0, length = array.length; i < array.length; i++){
            if (temp[i] != array[i]){
                count++;
            }
        }
        return count;
    }
}