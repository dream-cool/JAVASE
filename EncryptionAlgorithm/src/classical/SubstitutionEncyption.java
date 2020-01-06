package classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ：clt
 * @Date ：Created in 9:10 2019/9/17
 */
public class SubstitutionEncyption {

    public static void main(String[] args) {
        select();
//        joker is a murderer
//        eadrksreoiurjrme

//     3  31   sfaasfa2sad4
//        afsafs2dsaa4
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

    public static String encrypt() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        String key = null;
        StringBuilder ciphertext = null;
        Map<Integer, Integer> keys = new HashMap<>(26);
        String m = null;
        try {
            while (Objects.isNull(message) || "".equals(message)) {
                System.out.println("请输入明文密码M");
                message = br.readLine().replace(" ", "");
            }
            while (Objects.isNull(m) || "".equals(m)) {
                System.out.println("请输入m");
                m = br.readLine();
            }
            while (Objects.isNull(key) || "".equals(key) || !"ok".equals(key)) {
                System.out.println("请输入密钥K 即需要置换的列 完成请输入ok");
                key = br.readLine();
                if ("ok".equals(key)) {
                    break;
                }
                keys.put(Integer.parseInt(key.split(" ")[0]), Integer.parseInt(key.split(" ")[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!Objects.isNull(message) && !Objects.isNull(keys) && keys.size() != 0) {
            int column = Integer.parseInt(m);
            int row = (int) Math.ceil((double) message.length() /column);
            char[][] temp = new char[row][column];
            for (int j = 0, i = 0; j < row ; j++) {
                for (int k = 0; k < column; k++) {
                    if (i < message.length()){
                        temp[j][k] = message.charAt(i);
                        i++;
                    } else {
                        temp[j][k] = '#';
                    }
                }
            }
            for (int i = 0; i < column; i++) {
                for (Integer k : keys.keySet()) {
                    char ch = temp[i][k - 1];
                    temp[i][k - 1] = temp[i][keys.get(k) - 1];
                    temp[i][keys.get(k) - 1] = ch;
                }
            }
            ciphertext = new StringBuilder();
            for (int j =  0; j < column ; j++) {
                for (int i = 0; i < row; i++) {
                    ciphertext.append(temp[i][j]);
                }
            }
        }
        System.out.println("密文"+ciphertext);
        return ciphertext.toString();
    }

    public static String decrypt() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder message = null;
        String key = null;
        String ciphertext = null;
        Map<Integer, Integer> keys = new HashMap<>(26);
        String m = null;
        try {
            while (Objects.isNull(ciphertext) || "".equals(ciphertext)) {
                System.out.println("请输入密文");
                ciphertext = br.readLine().replace(" ", "");
            }
            while (Objects.isNull(m) || "".equals(m)) {
                System.out.println("请输入m");
                m = br.readLine();
            }
            while (Objects.isNull(key) || "".equals(key) || !"ok".equals(key)) {
                System.out.println("请输入密钥K 即需要置换的列 完成请输入ok");
                key = br.readLine();
                if ("ok".equals(key)) {
                    break;
                }
                keys.put(Integer.parseInt(key.split(" ")[0]), Integer.parseInt(key.split(" ")[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!Objects.isNull(ciphertext) && !Objects.isNull(keys) && keys.size() != 0) {
            int column = Integer.parseInt(m);
            int row = (int) Math.ceil((double) ciphertext.length() /column);
            char[][] temp = new char[row][column];
            for (int k = 0 ,i = 0; k < column; k++) {
                for (int j = 0; j < row ; j++) {
                    if (i < ciphertext.length()){
                        temp[j][k] = ciphertext.charAt(i);
                        i++;
                    } else {
                        temp[j][k] = '#';
                    }
                }
            }
            for (int i = 0; i < column; i++) {
                for (Integer k : keys.keySet()) {
                    char ch = temp[i][k - 1];
                    temp[i][k - 1] = temp[i][keys.get(k) - 1];
                    temp[i][keys.get(k) - 1] = ch;
                }
            }
            message = new StringBuilder();
            for (int i = 0; i < row; i++) {
                for (int j =  0; j < column ; j++) {
                    message.append(temp[i][j]);
                }
            }
        }
        System.out.println("明文"+message);
        return message.toString();
    }
}
