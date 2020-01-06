/**
 * @ Author   ：clt.
 * @ Date     ：Created in 14:37 2019/7/29
 */
public class GcTest {

    public GcTest() {
        byte[] bytes = new byte[10 * 1024 * 1024];
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            new GcTest();
        }
    }
}
