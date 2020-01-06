package classical;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ：clt
 * @Date ：Created in 10:28 2019/9/17
 */
public class Test {

    protected  int a;

    public static void main(String[] args) throws IOException {
//        String str = "hello";
//        String key = "k";
//
//        char[] chars = str.toCharArray();
//        byte[] k = key.getBytes();
//        for (int i = 0; i < chars.length; i++) {
//            Integer.toBinaryString(Integer.parseInt(String.valueOf(chars[i])));
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(maxCommonStr(s1, s2));


    }

    public static String maxCommonStr(String str1, String str2){
        char[] temp1 = str1.toCharArray();
        char[] temp2 = str2.toCharArray();
        StringBuilder sb = new StringBuilder();
        String maxStr = null;
        int maxLength = 0;
        for(int i = 0; i < str1.length(); i++){
            int t = i;
            for(int j = 0; j < str2.length(); j++){
                if (temp1[t] == temp2[j]){
                    sb.append( temp1[t] );
                    t++;
                    if (t == str1.length()){
                        break;
                    }
                } else {
                    t = i;
                    if ( sb.length() > maxLength ){
                        maxStr = sb.toString();
                        maxLength = maxStr.length();
                    }
                    sb = new StringBuilder();
                }
            }
        }
        return maxStr;
    }
}
