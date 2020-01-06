package classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author ：clt
 * @Date ：Created in 10:11 2019/9/10
 */
public class ShiftEncryption {
    public static void main(String[] args) {
        select();
//    3   abc 12c de @
//    3   CDE 12E FG @
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
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String message = null;
        String key = null;
        StringBuilder ciphertext = null;
        try {
            while (Objects.isNull(message) || "".equals(message)){
                System.out.println("请输入明文密码M");
                message = br.readLine();
            }
            while (Objects.isNull(key) || "".equals(key)){
                System.out.println("请输入密钥K");
                key = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!Objects.isNull(message) && !Objects.isNull(key)){
            ciphertext = new StringBuilder(message.length());
            message = message.toUpperCase();
            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                if(' ' != ch && ch >=65 && ch <= 90){
                    ciphertext.append((char)((ch + Integer.parseInt(key) -65) % 26 + 65));
                } else if(ch < 65 || ch > 90 ) {
                    ciphertext.append(ch);
                } else {
                    ciphertext.append(" ");
                }
            }
        }
        System.out.println("密文"+ ciphertext);
        return ciphertext.toString();
    }

    public static String decrypt(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder message = null;
        String key = null;
        String ciphertext = null;
        try {
            while ("".equals(ciphertext) || null == ciphertext){
                System.out.println("请输入密文");
                ciphertext = br.readLine();
            }
            while ("".equals(key) || null == key){
                System.out.println("请输入秘钥");
                key = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(ciphertext != null && key != null){
            message = new StringBuilder(ciphertext.length());
            ciphertext = ciphertext.toUpperCase();
            int k = Integer.parseInt(key) % 26;
            for(int i = 0; i < ciphertext.length(); i++){
                char ch = ciphertext.charAt(i);
                if(' ' != ch && ch >=65 && ch <= 90){
                    if((ch - k -65) < 0 ){
                        message.append((char)((ch - k - 65) + 26 +65));
                    } else {
                        message.append((char)((ch - k -65) + 65));
                    }
                } else if(ch < 65 || ch > 90 ) {
                    message.append(ch);
                } else {
                    message.append(" ");
                }
            }
        }
        System.out.println("明文为"+message);
        return message.toString();
    }
}
