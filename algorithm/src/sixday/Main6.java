package sixday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 9:36 2019/6/30
 * 输入描述:
 * 1,5,7,9
 * 2,3,4,6,8,10
 * 输入有多个测试用例，每个测试用例有1-2行，每行都是以英文逗号分隔从小到大排列的数字
 * 输出描述:
 * 1,2,3,4,5,6,7,8,9,10
 * 输出一行以英文逗号分隔从小到大排列的数组
 */
public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1, str2;
        str1=br.readLine();
        str2=br.readLine();
        br.close();
        if(str2==null){
            System.out.println(str1);
            return;
        }
        String[] s1 = str1.split(",");
        String[] s2 = str2.split(",");
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int j = 0; j < s1.length; j++){
            list1.add(Integer.parseInt(s1[j]));
        }
        for (int k = 0; k < s2.length; k++){
            list2.add(Integer.parseInt(s2[k]));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length + s2.length; i++){
            if (list1.size() == 0){
                sb.append(list2.removeFirst()+",");
                continue;
            }
            if (list2.size() == 0){
                sb.append(list1.removeFirst()+",");
                continue;
            }
            if (list1.getFirst() <= list2.getFirst() ){
                sb.append(list1.removeFirst()+",");
            } else {
                sb.append(list2.removeFirst()+",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
