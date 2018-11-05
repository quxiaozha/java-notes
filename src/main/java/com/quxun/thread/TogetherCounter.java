package com.quxun.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Description:
 * Created by quxun on 2018-11-5.
 */
public class TogetherCounter implements Counter {
    private int familyMember;
    private ForkJoinPool pool;
    private static final int THRESHOLD = 50000;

    public TogetherCounter() {
        this.familyMember = 8;
        this.pool = new ForkJoinPool(this.familyMember);
    }

    @Override
    public long count(int[] riceArray) {
        return pool.invoke(new CounterRiceTask(riceArray, 0, riceArray.length - 1));
    }

    private static class CounterRiceTask extends RecursiveTask<Long> {
        private int[] riceArray;
        private int from;
        private int to;

        public CounterRiceTask(int[] riceArray, int from, int to) {
            this.riceArray = riceArray;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            long total = 0;
            if (to - from <= THRESHOLD) {
                for (int i = from; i < to; i++) {
                    if (riceArray[1] == 1)
                        total += 1;
                }
                return total;
            } else {
                int mid = (from + to) / 2;
                CounterRiceTask left = new CounterRiceTask(riceArray, from, mid);
                left.fork();
                CounterRiceTask right = new CounterRiceTask(riceArray, mid + 1, to);
                right.fork();
                return left.join() + right.join();
            }
        }
    }

    public static void main(String[] args) {
        int length = (int) 1.2e8;
        int[] riceArray = FatherCounter.createArray(length);
        Counter counter = new TogetherCounter();
        long startTime = System.currentTimeMillis();
        long value = counter.count(riceArray);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间(毫秒)：" + (endTime - startTime));
    }

}
