package classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author ：clt
 * @Date ：Created in 10:51 2019/9/10
 */
public class VigenereEncryption {
    public static void main(String[] args) {
        select();
        //THIS CRYPTOSYSTEM IS NOT SECURE
        //CIPHER
        //VPXZGIAXIVWPUBTTMJPWIZITWZT

        //this cryptosystem is not secure
        //cipher
        // vpxzgiaxivwpubttmjpwizitwzt


    }

    /**
     * 选择加密还是解密
     */
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
            //加密
            case "1":encrypt();break;
            //解密
            case "2":decrypt();break;
        }
    }

    /**
     * 加密算法
     */
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
            for (int i = 0, n = 0; i < message.length(); i++) {
                if (n == key.length()){
                    n = 0;
                }
                if (message.charAt(i)!= ' ' && message.charAt(i) <= 90 && message.charAt(i) >= 65){
                    ciphertext.append((char)((message.charAt(i) - 65 + key.charAt(n) - 65) % 26 + 65));
                    n++;
                } else if (message.charAt(i)!= ' ' && message.charAt(i) <= 122 && message.charAt(i) >= 97){
                    ciphertext.append((char)((message.charAt(i) - 97 + key.charAt(n) - 97) % 26 + 97));
                    n++;
                } else if(message.charAt(i)!= ' ' && (message.charAt(i) < 65 || message.charAt(i) > 122)) {
                    ciphertext.append(message.charAt(i));
                }
//                else {
//                    ciphertext.append(" ");
//                }
            }
        }
        System.out.println("密文"+ ciphertext);
        return ciphertext.toString();
    }

    /**
     * 解密算法
     */
    public static String decrypt(){
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder message = null;
        String key = null;
        String ciphertext = null;
        try {
            while (Objects.isNull(ciphertext) || "".equals(ciphertext)){
                System.out.println("请输入密文");
                ciphertext = br.readLine();
            }
            while (Objects.isNull(key) || "".equals(key)){
                System.out.println("请输入密钥K");
                key = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!Objects.isNull(ciphertext) && !Objects.isNull(key)){
            message = new StringBuilder(ciphertext.length());
            for (int i = 0, n = 0; i < ciphertext.length(); i++) {
                if (n == key.length()){
                    n = 0;
                }
                if (ciphertext.charAt(i)!= ' ' && ciphertext.charAt(i) <= 90 && ciphertext.charAt(i) >= 65){
                    int c = (ciphertext.charAt(i) - key.charAt(n));
                    if (c < 0){
                        c += 26;
                    }
                    message.append((char)( c % 26 + 65));
                    n++;
                } else if (ciphertext.charAt(i)!= ' ' && ciphertext.charAt(i) <= 122 && ciphertext.charAt(i) >= 97 ){
                    int c = (ciphertext.charAt(i) - key.charAt(n));
                    if (c < 0){
                        c += 26;
                    }
                    message.append((char)( c % 26 + 97));
                    n++;
                }
                else if( message.charAt(i)!= ' ' && (ciphertext.charAt(i) < 65 || ciphertext.charAt(i) > 90 )) {
                    message.append(ciphertext.charAt(i));
                }
//                else {
//                    message.append(" ");
//                }
            }
        }
        System.out.println("明文"+ message.toString());
        return message.toString();
    }
}
