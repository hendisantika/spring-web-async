package com.hendisantika.web.testing;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 30/06/18
 * Time: 06.30
 * To change this template use File | Settings | File Templates.
 */
public class TimeoutException extends RuntimeException {

    private final long time;
    private final String message;

    public TimeoutException(long time, String message) {
        this.time = time;
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String getMessage() {
        return message;
    }
}