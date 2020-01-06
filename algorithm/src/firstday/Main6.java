package firstday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 18:33 2019/7/13
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;

public class Main6{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        BigInteger num1 =  new BigInteger(str1);
        BigInteger num2 =  new BigInteger(str2);
        System.out.print(num1.multiply(num2));
    }
}
