package ali;

/**
 * @author ：clt
 * @Date ：Created in 13:59 2019/8/31
 */
public class FloatPrimitiveTest {
    /**
     *Java 语言支持两种基本的浮点类型：float 和 double ，以及与它们对应的包装类 Float 和 Double 。
     * 它们都依据 IEEE 754 标准，该标准用科学记数法以底数为 2 的小数来表示浮点数。
     * 但浮点运算很少是精确的。虽然一些数字可以精确地表示为二进制小数，
     * 比如说 0.5，它等于 2-1；但有些数字则不能精确的表示，比如说 0.1。
     * 因此，浮点运算可能会导致舍入误差，产生的结果接近但并不等于我们希望的结果。
     * 所以，我们看到了 0.1 的两个相近的浮点值，一个是比 0.1 略微大了一点点的 0.100000024，
     * 一个是比 0.1 略微小了一点点的 0.099999964。
     * Jav浮a 对于任意一个点字面量，最终都舍入到所能表示的最靠近的那个浮点值，
     * 遇到该值离左右两个能表示的浮点值距离相等时，默认采用偶数优先的原则——
     * 这就是为什么我们会看到两个都以 4 结尾的浮点值的原因。
     */
    public static void main(String[] args) {
        float a = 1.0f -0.9f;
        float b = 0.9f -0.8f;
        if (a == b){
            System.out.println(true+"   a:"+a+"    b:"+b);
        } else {
            System.out.println(false+"   a:"+a+"   b:"+b);
        }
        float c = 1.0f;
        System.out.println(c);

        float a1 = 1.5f -1.0f;
        float b1 = 1.0f -0.5f;
        if (a1 == b1){
            System.out.println(true+"   a1:"+a1+"    b1:"+b1);
        } else {
            System.out.println(false+"   a1:"+a1+"   b1:"+b1);
        }

        double a2 = 1.0 -0.9;
        double b2 = 0.9 -0.8;
        if (a2 == b2){
            System.out.println(true+"   a2:"+a2+"    b2:"+b2);
        } else {
            System.out.println(false+"   a2:"+a2+"   b2:"+b2);
        }

        System.out.println("##############");

        float f = 510.11341f;
        System.out.println(f);
    }
}
