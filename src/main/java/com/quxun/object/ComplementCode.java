package com.quxun.object;

/**
 * Description:
 * Created by quxiaozha on 2018-10-9 8:51.
 */
public class ComplementCode {
    public static void check1(int num){
        int count = 0;
        int check = 1;
        while (check != 0) {
            if ((check & num) != 0) {
                count++;
            }
            check = check << 1;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        //1000 0000 0000 0000 0000 0000 0000 0000
        //0000 0000 0000 0000 0000 0000 0000 0000
        //上面两个可以理解为-0和+0
        //但由于数学上没有意义，所以将-0特指为负数的最小值-2^31
        //这也是为什么int的范围是-2^31~2^31-1，负数范围比正数多一个的原因
        check1(0x80000000);//1个1
        check1(0x80000001);//2个1
        check1(-1);//32个1
        check1(0);
    }
}
