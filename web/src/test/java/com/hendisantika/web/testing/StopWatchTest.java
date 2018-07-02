package com.hendisantika.web.testing;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/07/18
 * Time: 05.43
 * To change this template use File | Settings | File Templates.
 */
public class StopWatchTest {
    @Test
    public void stopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        TimeUnit.SECONDS.sleep(1);
        stopWatch.stop();
        assertThat(stopWatch.getTotalTimeMillis()).isLessThan(1200);
    }

    @Test
    public void isRunning() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        assertThat(stopWatch.isRunning()).isTrue();
        TimeUnit.SECONDS.sleep(1);
        stopWatch.stop();
        assertThat(stopWatch.isRunning()).isFalse();
        assertThat(stopWatch.getTotalTimeMillis()).isLessThan(1200);
    }

    @Test
    public void reset() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        TimeUnit.SECONDS.sleep(1);
        stopWatch.stop();
        stopWatch.reset();
        assertThat(stopWatch.getTotalTimeMillis()).isEqualTo(0);
        assertThat(stopWatch.isRunning()).isFalse();
    }

}