package com.quxun.thread;

import java.util.Random;

/**
 * Description:
 * Created by quxun on 2018-11-5.
 */
public class FatherCounter implements Counter {

    @Override
    public long count(int[] riceArray) {
        long total = 0;
        for (int i : riceArray) {
            if (i == 1) {
                total += 1;
            }

            if (total >= 1e8) {
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int length = (int) 1.2e8;
        int[] riceArray = createArray(length);
        Counter counter = new FatherCounter();
        long startTime = System.currentTimeMillis();
        long value = counter.count(riceArray);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间(毫秒)：" + (endTime - startTime));
    }

    public static int[] createArray(int length) {
        int[] arr = new int[length];
        int i = 0;
        while (i < length) {
            arr[i++] = Math.random() <= 0.8 ? 1 : 0;
        }
        return arr;
    }
}
