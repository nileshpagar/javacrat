package com.javacrat.retry;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.springframework.retry.backoff.ExponentialRandomBackOffPolicy;

import java.util.Random;

public class ExponentialBackoffStrategy {

    private final long maxBackoff;

    private long backoffValue;

    private long attempts;
    private static final long DEFAULT_MAX_RETRIES = 900000;

    private Random random = new Random();

    public ExponentialBackoffStrategy( long maxBackoff ) {
        this.maxBackoff = maxBackoff;
    }

    public long getWaitTimeExp(int attempts) {
        final double pow = Math.pow( 2, attempts);
        final int rand = random.nextInt( 1000 );
        return ( long ) Math.min( pow + rand, maxBackoff );
    }

    public static ExponentialBackoffStrategy getDefault() {
        return new ExponentialBackoffStrategy( DEFAULT_MAX_RETRIES );
    }


    public static void main(String[] args) {
        ExponentialBackoffStrategy exponentialBackoffStrategy = ExponentialBackoffStrategy.getDefault();
        /*System.out.println(exponentialBackoffStrategy.getWaitTimeExp(1));
        System.out.println(exponentialBackoffStrategy.getWaitTimeExp(2));
        System.out.println(exponentialBackoffStrategy.getWaitTimeExp(3));
        System.out.println(exponentialBackoffStrategy.getWaitTimeExp(4));
        System.out.println(exponentialBackoffStrategy.getWaitTimeExp(5));
        System.out.println(exponentialBackoffStrategy.getWaitTimeExp(6));
        System.out.println(exponentialBackoffStrategy.getWaitTimeExp(7));
        System.out.println(exponentialBackoffStrategy.getWaitTimeExp(8));*/
    }

}
