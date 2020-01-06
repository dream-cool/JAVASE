package firstday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:54 2019/7/13
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main9{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            count++;
            if(i == str.length()-1 || str.charAt(i) != str.charAt(i + 1)){
                if (count == 1){
                    System.out.print(str.charAt(i));
                }
                if (count > 1){
                    System.out.printf("%d%c",count - 1,str.charAt(i));
                }
                count = 0;
            }
        }
    }
}
