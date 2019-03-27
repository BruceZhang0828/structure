package com.zhy.day04Queue;

/**
 * @ClassName: QueueBasedOnLinkedList
 * @Description: 基于链表实现队列
 * @auther: zhy
 * @Date: 2019/3/26 15:29
 * @Version: 1.0
 **/
public class QueueBasedOnLinkedList {
    private Node head = null;
    private Node tail = null;

    //入队
    public void enqueue(String value){
        if(tail==null){
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
        }else{
            tail.next = new Node(value);
            tail = tail.next;
        }
    }
    //出队
    public String dequeue(){
        if (tail==null)return null;

        String data = head.data;
        head = head.next;
        if(head==null){
            tail=null;
        }
        return data;
    }


    public void printAll(){
        Node node = head;
        while (node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println("");
    }


    public static class Node{
        private String data;
        private Node next;

        public Node(String value){
            this(value,null);
        }

        public Node(String value,Node node){
            this.data = value;
            this.next = node;
        }

        public String getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.printAll();
        String dequeue = queue.dequeue();
        queue.printAll();
    }
}
