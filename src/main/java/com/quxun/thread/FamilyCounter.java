package com.quxun.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Description:
 * Created by quxun on 2018-11-5.
 */
public class FamilyCounter implements Counter {
    private int familyMember;
    private ExecutorService pool;

    public FamilyCounter() {
        this.familyMember = 8;
        this.pool = Executors.newFixedThreadPool(this.familyMember);
    }

    private static class CounterRiceTask implements Callable<Long> {
        private int[] riceArray;
        private int from;
        private int to;

        public CounterRiceTask(int[] riceArray, int from, int to) {
            this.riceArray = riceArray;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long total = 0;
            for (int i = from; i <= to; i++) {
                if (riceArray[i] == 1)
                    total += 1;
                if (total >= 0.125e8)
                    break;
            }
            return total;
        }
    }

    @Override
    public long count(int[] riceArray) {
        long total = 0;
        List<Future<Long>> results = new ArrayList<>();
        int part = riceArray.length / familyMember;
        for (int i = 0; i < familyMember; i++) {
            results.add(pool.submit(new CounterRiceTask(riceArray, i * part, (i + 1) * part)));
        }
        for (Future<Long> j : results) {
            try {
                total += j.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException ignore) {
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int length = (int) 1.2e8;
        int[] riceArray = FatherCounter.createArray(length);
        Counter counter = new FamilyCounter();
        long startTime = System.currentTimeMillis();
        long value = counter.count(riceArray);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间(毫秒)：" + (endTime - startTime));
    }
}
