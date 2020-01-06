package tree;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:30 2019/7/12
 */
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 8, 7, 5};
        System.out.println(VerifySquenceOfBST(arr));
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length < 1) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        int root = sequence[sequence.length - 1];
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] > root && !flag) {
                flag = true;
                index = i;
            }
            if (flag && sequence[i] < root) {
                return false;
            }
        }
        if (index != 0){
            int[] left = new int[index];
            int[] right = new int[sequence.length - index - 1];
            for (int i = 0; i < index; i++) {
                left[i] = sequence[i];
            }
            for (int i = index, j = 0; i < sequence.length - 1; i++, j++) {
                right[j] = sequence[i];
            }
            if (!VerifySquenceOfBST(left)) {
                return false;
            }
            if (!VerifySquenceOfBST(right)) {
                return false;
            }
        }
        return true;
    }
}
