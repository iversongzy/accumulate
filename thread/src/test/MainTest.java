import org.junit.Test;
import org.lgt.thread.synchronize.MyThreadA;
import org.lgt.thread.synchronize.MyThreadB;
import org.lgt.thread.synchronize.Son;

public class MainTest {
    @Test
    public void test() {
        System.out.println("A"+Thread.currentThread().holdsLock(MainTest.class));
        synchronized (MainTest.class) {
            System.out.println("B"+Thread.currentThread().holdsLock(MainTest.class));
        }
        System.out.println("C"+Thread.currentThread().holdsLock(MainTest.class));
    }
}
