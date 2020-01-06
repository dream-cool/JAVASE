package secondday;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 9:21 2019/6/15
 */
public class Power {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Power(8, 3));
        System.out.println(System.currentTimeMillis()-start);
    }

    public static double Power(double base, int exponent) {
        if (base == 0){
            return 0;
        }
        double temp = base;
        while(Math.abs(exponent) > 1){
            base = temp * base;
            exponent--;
        }
        if (exponent >= 1){
            return base;
        }
        if (exponent < 0){
            return 1/base;
        }
        return 1;
    }
}
