package ali;

import java.util.Objects;

/**
 * @author ：clt
 * @Date ：Created in 14:08 2019/8/31
 */
public class SwitchTest {
    /**
     * switch () 表达式内部执行的竟然是 (s = param).hashCode()，
     * 当 param 为 null 的时候，s 也为 null，调用 hashCode() 方法的时候自然会抛出 NullPointerException 了。
     */
    public static void main(String[] args) {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }


}
