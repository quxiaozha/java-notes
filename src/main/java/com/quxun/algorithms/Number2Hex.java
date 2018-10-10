package com.quxun.algorithms;

/**
 * Description:https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/description/
 * Created by quxiaozha on 2018-10-10 15:57.
 */
public class Number2Hex {
    public static String toHex(int num) {

        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int tmp;
        while (num != 0) {
            tmp = num & 0xf;
            if (tmp >= 10) {
                sb.append((char) (tmp - 10 + 'a'));
            } else {
                sb.append((char) (tmp + '0'));
            }

            /**
             * <<:左移运算符，num << 1,相当于num乘以2
             * >>:右移运算符，num >> 1,相当于num除以2
             * >>>:无符号右移，忽略符号位，空位都以0补齐
             **/
            num = num >>> 4; //无符号位移动
        }

        return sb.reverse().toString();
    }

    public static String toHex2(int num) {
        if (num == 0) return "0";
        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0) {
            tmp = num & 0xf;
            sb.append(hexChars[tmp]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex2(-10));
    }
}
