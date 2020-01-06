package classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author ：clt
 * @Date ：Created in 11:02 2019/9/17
 */
public class SequentialEncryption {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i >= 0; i = i + i) {
            count++;
        }
        System.out.println(count);
    }

    public static void select() {
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
        switch (str) {
            case "1":
                encrypt();
                break;

            case "2":
                decrypt();
                break;
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

        }
        return null;
    }

    public static String decrypt(){
        return null;
    }

}
