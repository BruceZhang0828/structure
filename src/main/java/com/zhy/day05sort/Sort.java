package com.zhy.day05sort;

/**
 * @ClassName: Sort
 * @Description: 排序算法
 * @auther: zhy
 * @Date: 2019/3/1 16:46
 * @Version: 1.0
 **/
public class Sort {
    /**
     * @Author zhy
     * @Description //冒泡排序
     * @Date 16:48 2019/3/1
     * @Param [a, len]
     * @return void
    **/
    public static void bubbleSort(int[] a, int len) {
        if (len <= 1) return;

        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) { //len - i -1 就是之前排好的数据就不用比较
                if (a[i] > a[j]) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
            if (!flag) break;

        }
    }
    /**
     * @Author zhy
     * @Description //插入排序
     * @Date 15:13 2019/3/8
     * @Param [a:表示数组, n表示数组长度]
     * @return void
    **/
    public static void insertionSort(int[] a,int n){
        if (n<1)return;
        for (int i = 0; i <n; i++) {
            int value = a[i];
            int j = i -1;
            for (; j>0 ; --j) {
                if (a[j]>value){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = value;
        }
    }


    public static void main(String[] args) {
        int[] a = {1,5,6,7,3,354,26,7,9};
        insertionSort(a,a.length);
        System.out.println(a);
    }
}
