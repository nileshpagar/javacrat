package com.javacrat.retry;

public class ExponentialBackOffContext {

        private final double multiplier;

        private long interval;

        private long maxInterval;

        public ExponentialBackOffContext(long expSeed, double multiplier,
                                         long maxInterval) {
            this.interval = expSeed;
            this.multiplier = multiplier;
            this.maxInterval = maxInterval;
        }

        public synchronized long getSleepAndIncrement() {
            long sleep = this.interval;
            if (sleep > maxInterval) {
                sleep = maxInterval;
            }
            else {
                this.interval = getNextInterval();
            }
            interval++;
            return sleep;
        }

        public long getNextInterval() {
            return (long) (this.interval * this.multiplier);
        }

        public double getMultiplier() {
            return multiplier;
        }

        public long getInterval() {
            return interval;
        }

        public long getMaxInterval() {
            return maxInterval;
        }




    public static void main(String[] args) {
        ExponentialBackOffContext exponentialBackOffContext = new ExponentialBackOffContext(3, Math.PI, Long.MAX_VALUE);
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
        System.out.println(exponentialBackOffContext.getSleepAndIncrement());
    }

}

