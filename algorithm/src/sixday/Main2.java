package sixday;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 9:05 2019/6/26
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] D = new int[n];
        int[] P = new int[n];
        for(int i = 0; i < n; i++){
            D[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        int[] A = new int[m];
        for(int i = 0; i < m; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(D);
        Arrays.sort(P);
        int[] income = new int[m];
        for (int i =0; i < m; i++){
            int j = n-1;
            while(j >= 0){
                if (A[i] >= D[j]){
                    A[i] -= D[j];
                    income[i] += P[j];
                }
                j--;
            }
        }
        for(int i = 0; i < m; i++){
            System.out.println(income[i]);
        }
    }
}
