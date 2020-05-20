package concurrentT.ThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private AtomicInteger cnt = new AtomicInteger();

    public void add(){
        cnt.incrementAndGet();
    }

    public int get() {
        return cnt.get();
    }


    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        AtomicExample example = new AtomicExample();
        final CountDownLatch latch = new CountDownLatch(threadSize);
        ExecutorService service  = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            service.execute(() -> {
                example.add();
                latch.countDown();;
            });
        }
        latch.await();

        service.shutdown();
        System.out.println(example.get());

    }
}
