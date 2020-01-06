package classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author ：clt
 * @Date ：Created in 10:32 2019/9/10
 */
public class AffineEncryption {
    public static void main(String[] args) {
//        select();
//      7 2  明文密码HUIH @242JFA FA1]D
//      7 2  密文ZMGZ @242NLC LC1]X
        System.out.println(gcd(4, 26));
    }

    public static void select(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            while (Objects.isNull(str) || (!"1".equals(str) && !"2".equals(str))) {
                System.out.println("1:加密 ---------------  2:解密");
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (str){
            case "1":encrypt();break;

            case "2":decrypt();break;
        }
    }

    public static String encrypt(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        String key1 = null;
        String key2 = null;
        StringBuilder ciphertext = null;
        try {
            while (Objects.isNull(message) || "".equals(message)) {
                System.out.println("请输入明文密码M");
                message = br.readLine();
            }
            while (Objects.isNull(key1) || "".equals(key1)) {
                System.out.println("请输入密钥K1");
                key1 = br.readLine();
            }
            while (Objects.isNull(key2) || "".equals(key2)) {
                System.out.println("请输入密钥K2");
                key2 = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!Objects.isNull(message) && !Objects.isNull(key1) && !Objects.isNull(key2)) {
            ciphertext = new StringBuilder(message.length());
            message = message.toUpperCase();
            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) != ' ' && message.charAt(i) <= 90 && message.charAt(i) >= 65) {
                    ciphertext.append((char)
                            (((message.charAt(i) - 65) * Integer.parseInt(key1) + Integer.parseInt(key2)) % 26 + 65));
                } else if (message.charAt(i) > 90 || message.charAt(i) < 65){
                    ciphertext.append(message.charAt(i));
                }
                else {
                    ciphertext.append(" ");
                }
            }
        }
        System.out.println("密文"+ciphertext);
        return ciphertext.toString();
    }

    private static String decrypt(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder message = null;
        String key1 = null;
        String key2 = null;
        String ciphertext = null;
        try {
            while (Objects.isNull(ciphertext) || "".equals(ciphertext)) {
                System.out.println("请输入密文密码M");
                ciphertext = br.readLine();
            }
            while (Objects.isNull(key1) || "".equals(key1)) {
                System.out.println("请输入密钥K1");
                key1 = br.readLine();
            }
            while (Objects.isNull(key2) || "".equals(key2)) {
                System.out.println("请输入密钥K2");
                key2 = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!Objects.isNull(ciphertext) && !Objects.isNull(key1) && !Objects.isNull(key2)) {
            message = new StringBuilder(ciphertext.length());
            ciphertext = ciphertext.toUpperCase();
            for (int i = 0; i < ciphertext.length(); i++) {
                char ch = ciphertext.charAt(i);
                if (ch != ' ' && ch <= 90 && ch >= 65) {
                    ch -= 65;
                    while ( (ch - Integer.parseInt(key2)) % Integer.parseInt(key1) != 0 ){
                        ch += 26;
                    }
                    ch = (char) ((ch - Integer.parseInt(key2)) / Integer.parseInt(key1) + 65);
                    message.append(ch);
                } else if (ch > 90 || ch < 65){
                    message.append(ch);
                }
                else {
                    message.append(" ");
                }
            }
        }
        System.out.println("明文"+message);
        return message.toString();
    }

    public static int gcd(int x,int y)
    {
        int t;
        while (y != 0){
            t=x;
            x=y;
            y=t%y;
        }
        return x;
    }
}
