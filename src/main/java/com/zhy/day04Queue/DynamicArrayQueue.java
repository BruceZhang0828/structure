package com.zhy.day04Queue;

/**
 * @ClassName: DynamicArrayQueue
 * @Description: 数组版队列动态扩展
 * @auther: zhy
 * @Date: 2019/3/26 16:13
 * @Version: 1.0
 **/
public class DynamicArrayQueue {
    //数组:items,数组大小:n
    private String[] items;
    private int n = 0;
    // head表示队头,tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    //申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    //入队操作
    public boolean enqueue(String data){
        if (tail==n){
            //tail==n&&head==0,表示整个队列都沾满了
            if (head==0)return false;
            //数据搬移
            for (int i = head; i <tail ; i++) {
                items[i-head] = items[i];
            }
            //搬移后更新tail和head
            tail-=head;
            head =0;
        }

        items[tail] = data;
        tail++;
        return true;
    }

    public String dequeue(){
        if (head==tail)return null;
        String item = items[head];
        ++head;
        return item;
    }

    public void printAll(){
        for (int i = head; i < tail; i++) {
            System.out.print(items[i]+"");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DynamicArrayQueue queue = new DynamicArrayQueue(2);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.printAll();
        String dequeue = queue.dequeue();
        queue.enqueue("3");
        queue.printAll();
        queue.enqueue("4");
    }
}
