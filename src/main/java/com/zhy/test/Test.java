package com.zhy.test;

/**
 * @ClassName: Test
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/3/25 10:31
 * @Version: 1.0
 **/
public class Test {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String J, String S) {
        char[] j=J.toCharArray();
        char[] s=S.toCharArray();
        int count[]=new int ['z'-'A'+1];//创建一个数组记录每个字符出现的次数
        for(char ch:s){
            count[ch-'A']++;
        }
        int sum=0;
        for(char ch:j){
            sum+=count[ch-'A'];
        }
        return sum;
    }
}
