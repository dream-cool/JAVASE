package ali;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：clt
 * @Date ：Created in 14:56 2019/8/31
 */
public class LockTest {

    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        try {
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
