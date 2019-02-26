package com.zhy.day02linkList;

import java.util.Scanner;

/**
 * @ClassName: LRUBaseLinkedList
 * @Description: 基于单链表实现LRU算法
 * @auther: zhy
 * @Date: 2019/2/26 14:09
 * @Version: 1.0
 **/
public class LRUBaseLinkedList<T> {
    //默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;
    //头节点
    private SNode<T> head;
    //链表长度
    private Integer length;
    //链表容量
    private Integer capacity;

    public LRUBaseLinkedList(){
        this.head  = new SNode<T>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity){
        this.head  = new SNode<T>();
        this.capacity = capacity;
        this.length = 0;
    }
    /**
     * @Author zhy
     * @Description add 方法
     * @Date 14:26 2019/2/26
     * @Param [data]
     * @return void
    **/
    public void add(T data) {
        SNode preNode = findPreNode(data);

        if (preNode != null) {
            deleteElepmentOptim(preNode);
            insertElemAtBrgin(data);
        } else {
            if (length >= this.capacity) {
                deleteElepmentEnd();
            }
            insertElemAtBrgin(data);
        }
    }
    /**
     * @Author zhy
     * @Description 链表头部插入节点
     * @Date 18:36 2019/2/26
     * @Param [data]
     * @return void
    **/
    public void insertElemAtBrgin(T data) {
        SNode next = head.getNext();
        head.setNext(new SNode(data,next));
        length++;
    }

    /**
     * @Author zhy
     * @Description 删除preNode节点的下一个节点
     * @Date 18:34 2019/2/26
     * @Param [preNode]
     * @return void
    **/
    public void deleteElepmentOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length --;
    }

    /**
     * @Author zhy
     * @Description 查找元素的前一个节点 并返回
     * @Date 14:27 2019/2/26
     * @Param [data]
     * @return com.zhy.day02linkList.LRUBaseLinkedList<T>.SNode
    **/
    private SNode findPreNode(T data) {
        SNode node = head;
        while (node.getNext() != null){ //head节点 没有前一个节点
            if(data==node.getNext().getElement()){
                return node;
            }
            node = node.next;
        }

        return null;
    }
    /**
     * @Author zhy
     * @Description //删除尾节点
     * @Date 18:30 2019/2/26
     * @Param []
     * @return void
    **/
    public void deleteElepmentEnd() {
        SNode ptr = head;
        if (ptr.getNext() == null) return;
        //获取倒数第二个节点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }
    /**
     * @Author zhy
     * @Description //打印
     * @Date 18:44 2019/2/26
     * @Param []
     * @return void
    **/
    public void printAll(){
        SNode node = head.getNext();
        while (node != null){
            System.out.print(node.getElement()+ ",");
            node = node.getNext();
        }

        System.out.println();

    }

    /**
     * @Author zhy
     * @Description 链表节点
     * @Date 14:21 2019/2/26
     * @Param
     * @return
    **/
    public class SNode<T>{
        private T element;

        private SNode next;

        public SNode(T element){
            this.element = element;
        }

        public SNode(T element,SNode next){
            this.element = element;
            this.next = next;
        }

        public SNode(){
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public SNode getNext(){
            return this.next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner scanner = new Scanner(System.in);
        while (true){
            list.add(scanner.nextInt());
            list.printAll();
        }
    }
}
