package com.zhy.day02linkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LRUBasedArray
 * @Description:
 *  1.基于数组实现LRU缓存
 *  2.空间复杂度为O(n)
 *  3.不支持null的缓存
 * @auther: zhy
 * @Date: 2019/2/25 16:46
 * @Version: 1.0
 **/
public class LRUBasedArray<T> {
    private static final int DEFAULT_CAPACITY = (1<<3);
    private int capacity ;
    private int count;
    private T[] value;
    private Map<T,Integer> holder;

    public LRUBasedArray(){
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity){
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }
    /**
     * @Author zhy
     * @Description 模拟访问某个值
     * @Date 16:55 2019/2/25
     * @Param [object]
     * @return void
    **/
    public void offer(T object){
        if (object == null){
            throw new IllegalArgumentException("该缓存不支持null");
        }
        Integer index = holder.get(object);
        if (index == null){
            if(isFull()){
                removeAndCache(object);
            }else{
                cache(object,count);
            }
        }else{
            update(index);
        }
    }
    /**
     * @Author zhy
     * @Description 缓存满的情况,踢出后,再缓存到数组头部
     * @Date 19:04 2019/2/25
     * @Param [object]
     * @return void
    **/
    public void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);
        cache(object,count);
    }
    /**
     * @Author zhy
     * @Description 缓存数据到头部,但要先右移
     * @Date 19:17 2019/2/25
     * @Param [object, end]
     * @return void
    **/
    public void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object,0);
        count ++;
    }

    

    //若缓存中指定的值,则更新位置
    public void update(int end){
        T target  = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target,0);
    }
    /**
     * @Author zhy
     * @Description //end左边的数据统一右移一位
     * @Date 18:48 2019/2/25
     * @Param [end]
     * @return void
    **/
    private void rightShift(int end) {
        for (int i = end - 1; i >=0 ; i--) {
            holder.put(value[i],i+1);
        }
    }
    public boolean isContain(T object){
        return holder.containsKey(object);
    }
    public boolean isEmpty(){
        return count==0;
    }
    public boolean isFull(){
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(value[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    static class TestLRUBasedArray{

        public static void main(String[] args) {
            testDefaultConstructor();
        }

        private static void testDefaultConstructor() {
            System.out.println("======无参测试=====");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            lru.offer(6);
            System.out.println(lru);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }


    }
}
