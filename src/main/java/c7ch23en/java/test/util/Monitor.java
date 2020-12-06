package c7ch23en.java.test.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author c7ch23en
 */
public class Monitor {

    private final AtomicLong timestampNs = new AtomicLong(-1);

    public static Monitor create() {
        return new Monitor();
    }

    public long start() {
        long now = System.nanoTime();
        if (timestampNs.compareAndSet(-1, now))
            return now;
        throw new IllegalStateException("Monitor already started");
    }

    public long stop() {
        long now = System.nanoTime();
        long start = timestampNs.getAndSet(-1);
        if (start >= 0)
            return now - start;
        throw new IllegalStateException("Monitor not started");
    }

}
