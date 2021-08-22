package com.javacrat.concurrency.bestprice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class BestPriceSelector {

    public static void main(String[] args) throws Exception {
        Callable<Double> t1 = new Callable<Double>() {
            @Override
            public Double call() {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    return new Double(0);
                }
                return new Double("1.0");
            }
        };

        Callable<Double> t2 = new Callable<Double>() {
            @Override
            public Double call() {
                try {
                    Thread.currentThread().sleep(1200);
                } catch (InterruptedException e) {
                    return new Double(0);
                }
                return new Double("1.2");
            }
        };
        Callable<Double> t3 = new Callable<Double>() {
            @Override
            public Double call() {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    return new Double(0);
                }
                return new Double("2");
            }
        };
        List<Callable<Double>> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Double>> futures = executorService.invokeAll(tasks, 2000, TimeUnit.MILLISECONDS);
        Double price = 0d;
        Double _price = 0d;
        for(Future<Double> future : futures) {
            try {
                _price = future.get();
            } catch(Exception e) {
                System.out.println("Error");
            }
            if (_price > price) price = _price;
        }
        System.out.println(price);
        executorService.shutdown();
    }

}
