package com.zhy.day03Stack;

/**
 * @ClassName: StackBaseOnLinkedList
 * @Description: TODO
 * @auther: zhy
 * @Date: 2019/3/25 14:52
 * @Version: 1.0
 **/
public class StackBaseOnLinkedList {
    private Node top = null;

    /*
     * @Author zhy
     * @Description 入栈操作
     * @Date 14:56 2019/3/25
     * @Param [node]
     * @return void
    **/
    public void push(int value){
        Node newNode = new Node(value,null);
        if(top==null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }
    /**
     * @Author zhy
     * @Description 弹栈
     * @Date 15:01 2019/3/25
     * @Param []
     * @return int
    **/
    public int pop(){
        if (top==null)return -1;
        int value  =  top.data;
        top = top.next;
        return value;
    }

    public void printAll(){
        Node p = top;
        while(p!=null){
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }


    private static class Node{
        private int data;
        private Node next;

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }


    public static void main(String[] args) {
        StackBaseOnLinkedList stack = new StackBaseOnLinkedList();
        stack.push(1);
        stack.push(8);
        stack.push(6);
        stack.push(4);
        stack.printAll();
    }
}
