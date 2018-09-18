package com.quxun.algorithms;

import java.util.Arrays;

/**
 * @Author quxiaozha
 * Description:冒泡、选择、插入、希尔排序笔记
 * Created by quxiaozha on 2018-9-17.
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr1 = getArr(100000);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);
        int[] arr4 = Arrays.copyOf(arr1, arr1.length);
        printArr("origin", arr1);
        printArr("selectionSort Complete", selectionSort(arr1));//4229.644444 ms
        System.out.println();
        printArr("origin", arr2);
        printArr("bubbleSort Complete", bubbleSort(arr2));//14270.112 ms
        System.out.println();
        printArr("origin", arr3);
        printArr("insertionSort Complete", insertionSort(arr3));//992.203111 ms
        System.out.println();
        printArr("origin", arr4);
        printArr("shellSort Complete", shellSort(arr4));//11.108444 ms
    }

    /**
     * @Author quxiaozha
     * @Description 冒泡排序 依次比较相邻两个元素的大小，将小的放在左边，第一轮排序后，最小的元素就到了第一位，然后依次
     *              对其余元素重复上面的操作，这样小元素就不停的冒上来，最后排序完成。
     * @Date 14:27 2018-9-17
     * @Param [arr]
     * @return int[]
     **/
    public static int[] bubbleSort(int[] arr) {
        long start,end;
        start=System.nanoTime();
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }

        }
        end=System.nanoTime();
        System.out.println("bubbleSort duration: "+(end-start)*1.0/(1000*1000)+" ms");
        return arr;
    }

    /**
     * @Author quxiaozha
     * @Description 选择排序，执行第i次遍历时，将arr[i]与arr[i+1]及之后的数据进行比较，找到最小的元素，并交换位置。
     *              第i次遍历完成后，arr[i]即为本轮最小的元素。
     * @Date 10:10 2018-9-17
     * @Param [arr]待排序数组
     * @return int[]排序后的数组
     **/
    public static int[] selectionSort(int[] arr) {
        long start,end;
        start=System.nanoTime();
        int minIndex,tmp;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        end=System.nanoTime();
        System.out.println("selectionSort duration: "+(end-start)*1.0/(1000*1000)+" ms");
        return arr;
    }

    /**
     * @Author quxiaozha
     * @Description 插入排序，从0开始，每次遍历保证前面的n个元素时有序状态，后面循环中每次取一个元素，插入到前面已经有序的
     *              数组中，具体方式是将当前元素与已排序的元素从大大小依次比较，如果当前元素比已排序的元素小时，将原来已经
     *              有序的元素往后移一位，给新元素挪一个“坑”，然后继续往前比较，一路将“坑”前移，直到找到当前元素比已排序数
     *              组大的元素为止，最后将当前元素填到上面留出来的那个坑中即可。
     * @Date 10:25 2018-9-17
     * @Param [a]
     * @return int[]
     **/
    public static int[] insertionSort(int[] a) {
        long start,end;
        start=System.nanoTime();
        int tmp;
        for (int i = 1; i < a.length; i++) {
            tmp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > tmp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
        end=System.nanoTime();
        System.out.println("insertionSort duration: "+(end-start)*1.0/(1000*1000)+" ms");
        return a;
    }

    /**
     * @Author quxiaozha
     * @Description 希尔排序 将数组按照步长分组，对每组分别排序，然后减小步长，重新分组，对每个分组进行插入排序，直到步长
     *              为1则排序完成。
     * @Date 10:26 2018-9-17
     * @Param [a]
     * @return int[]
     **/
    public static int[] shellSort(int[] a){
        long start,end;
        start=System.nanoTime();
        int h = a.length/2;
        int tmp;
        while (h >= 1){
            for (int i = 0; i < h; i++) {
                for (int j = i + h; j < a.length; j = j + h) {
                    tmp = a[j];
                    int k = j - h;
                    while(k >= 0 && a[k]>tmp){
                        a[k+h] = a[k];
                        k = k - h;
                    }
                    a[k + h] = tmp;
                }
            }
            h = h/2;
        }
        end=System.nanoTime();
        System.out.println("shellSort duration: "+(end-start)*1.0/(1000*1000)+" ms");
        return a;

    }

    public static void printArr(String prefix, int[] arr) {
        //System.out.println(prefix + ":" + Arrays.toString(arr));
    }

    public static int[] getArr(int len){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        return arr;
    }

}
