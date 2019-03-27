package com.zhy.day04Queue;

/**
 * @ClassName: ArrayQueue
 * @Description: 用数组实现队列
 * @auther: zhy
 * @Date: 2019/3/26 8:48
 * @Version: 1.0
 **/
public class ArrayQueue {

    private String[] items;
    private int n = 0;
    //head 表示队头下标,tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    //入队
    public boolean enqueue(String value) {
        if (tail == n) return false;
        items[tail] = value;
        ++tail;
        return true;
    }

    //出队
    public String dequeue() {
        if (head == tail) return null;
        String item = items[head];
        ++head;
        return item;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue("你是不是爱上了我");
        queue.enqueue("911");
        queue.enqueue("1993");
        queue.enqueue("1015");
        queue.enqueue("吃了吗");
        String dequeue = queue.dequeue();
        queue.enqueue("好吃吗");
        queue.printAll();
    }


}
