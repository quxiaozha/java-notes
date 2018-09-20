package com.quxun.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description:904. Fruit Into Baskets：https://leetcode.com/contest/weekly-contest-102/problems/fruit-into-baskets/
 *             Example
 *             Input: [3,3,3,1,2,1,1,2,3,3,4]
 *             Output: 5
 *             Explanation: We can collect [1,2,1,1,2].
 *             If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 * Created by quxiaozha on 2018-9-19 16:42.
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int max = fruitIntoBaskets.totalFruit(new int[]{3, 3, 3, 2, 2, 3, 2, 2, 3, 3, 2});
        System.out.println(max);
    }

    public int totalFruit(int[] tree) {
        int max=0;
        //可能的最大值
        int probableMax = tree.length;
        for (int i = 0; i < tree.length; i++) {//依次计算从每一位开始时的长度，然后取最大
            int basket1 = tree[i];//篮子1
            int basket2 = -1;//篮子2
            int total = 1;
            if (max >= probableMax) {//如果最大值大于或等于可能的最大值，则意味不需要继续进行运算了，直接中断循环
                break;
            }
            --probableMax;
            for (int j = i + 1; j < tree.length; j++) {
                int fruit = tree[j];
                if (fruit == basket1) {
                    ++total;
                    continue;
                }
                if (basket2 == -1) {//判断篮子2有没有装水果
                    basket2 = fruit;
                    ++total;
                } else {
                    if (fruit == basket2) {
                        ++total;
                    } else {
                        break;//当前的果树不是篮子1和篮子2中装的水果类型，直接中断当前循环
                    }
                }
            }
            max = Math.max(total, max);
        }
        return max;
    }

}
