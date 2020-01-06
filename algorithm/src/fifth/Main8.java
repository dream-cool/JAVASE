package fifth;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 18:33 2019/7/29
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Main8 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(3));
    }

    public static int GetUglyNumber_Solution(int index) {
        int number = 1;
        for(int i = 2; ;i++){
                int j = 1;
            for(; j < i; j++){
                if(i % j == 0 && j != 2 && j != 3 && j != 5){
                    break;
                }
            }
            if (i == j){
                number++;
                if (number == index){
                    return i;
                }
            }
        }
    }
}
