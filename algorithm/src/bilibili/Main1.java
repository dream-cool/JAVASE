package bilibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 9:52 2019/7/8
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[100];
        int i = 0;
        while (br.read() != 0){
            strings[i] = br.readLine();
            i++;
        }
        Arrays.toString(strings);
    }
}
