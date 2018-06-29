package com.hendisantika.web.testing;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 30/06/18
 * Time: 06.27
 * To change this template use File | Settings | File Templates.
 */
public class Testing implements AutoCloseable {

    private final ExecutorService executorService;
    private final int actionCount;
    private final StopWatch stopWatch = new StopWatch();
    private long realCount = 0;

    public Testing(int actionCount) {
        this(actionCount, actionCount, Executors.defaultThreadFactory());
    }

    public Testing(int actionCount, int threadCount) {
        this(actionCount, threadCount, Executors.defaultThreadFactory());
    }

    public Testing(int actionCount, int threadCount, ThreadFactory threadFactory) {
        this(actionCount, Executors.newFixedThreadPool(threadCount, threadFactory));
    }

    public Testing(int actionCount, ExecutorService executorService) {
        this.actionCount = actionCount;
        this.executorService = executorService;
    }

    public int totalActionCount() {
        return actionCount;
    }

    public void run(final Runnable action) throws InterruptedException, TimeoutException {
        run(360000, action);
    }

    public void run(long timeoutMs, final Runnable action) throws InterruptedException, TimeoutException {
        this.stopWatch.start();
        CountDownLatch countDownLatch = spawnThreads(action);
        if (!countDownLatch.await(timeoutMs, MILLISECONDS)) {
            throw new TimeoutException(timeoutMs, "timed out exception");
        }
        this.realCount = countDownLatch.getCount();
        this.stopWatch.stop();
    }

    public long getTotalTimeSeconds() {
        return stopWatch.getTotalTimeSeconds();
    }

    public long getTotalTimeMillis() {
        return stopWatch.getTotalTimeMillis();
    }

    private CountDownLatch spawnThreads(final Runnable action) {
        final CountDownLatch finished = new CountDownLatch(actionCount);
        CyclicBarrier barrier = new CyclicBarrier(actionCount);
        for (int i = 0; i < actionCount; i++) {
            executorService.submit(() -> {
                try {
                    barrier.await();
                    action.run();
                } finally {
                    finished.countDown();
                }
                return null;
            });
        }
        return finished;
    }

    public void shutdown() {
        executorService.shutdown();
    }

    public long getRealCount() {
        return realCount;
    }

    @Override
    public void close() {
        this.shutdown();
    }
}