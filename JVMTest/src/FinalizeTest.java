/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:53 2019/7/10
 */
public class FinalizeTest {
    private static FinalizeTest finalizeTest = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeTest.finalizeTest = this;
    }

    public static void main(String[] args) {
        finalizeTest = new FinalizeTest();
        finalizeTest = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (finalizeTest != null){
            System.out.println("alive");
        } else {
            System.out.println("dead");
        }
        finalizeTest = null;
        System.gc();
        if (finalizeTest != null){
            System.out.println("alive");
        } else {
            System.out.println("dead");
        }
    }
}
