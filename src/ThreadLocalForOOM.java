import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：何汉叁
 * @date ：2024/4/5 17:56
 * @description：TODO
 */
public class ThreadLocalForOOM {
    /**
     * -Xms50m -Xmx50m
     */
    static class OOMObject {
        private Long[] a = new Long[2 * 1024 * 1024];
    }

    final static ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    final static ThreadLocal<OOMObject> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            pool.execute(() -> {
                threadLocal.set(new OOMObject());
                System.out.println("oom object--->" + finalI);
                OOMObject oomObject = threadLocal.get();
                System.out.println("oomObject---->" + oomObject);
                // threadLocal.remove(); // 记得remove 防止内存泄露，此时一定要在使用完remove
            });

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
