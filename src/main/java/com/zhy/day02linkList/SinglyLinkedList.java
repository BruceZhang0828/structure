package com.zhy.day02linkList;

/**
 * @ClassName: SinglyLinkedList
 * @Description: 单链表的插入 删除 查找操作
 *               链表中存储的是int类型数据
 * @auther: zhy
 * @Date: 2019/2/18 21:03
 * @Version: 1.0
 **/
public class SinglyLinkedList {
    private Node head = null;
    //根据
    private Node findByValue(int value){
        Node p = head;
        while(p != null && p.data!=value){
            p = p.next;
        }
        return p;
    }

    public  Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while (p!=null && pos!= index){
            p = p.next;
            ++pos;
        }
        return p;
    }

    //头结点插入
    public void insertToHead(int value){
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if(head!=null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    //顺序插入
    //链表尾部插入
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        //空链表,可以插入新节点作为head ,也可以不操作
        if(head==null){
            head = newNode;
        }else{
            Node q = head;
            while(q.next!=null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void insertAfter(Node p,int value){
        Node newNode = new Node(value,null);
        insertAfter(p,newNode);
    }

    public void insertAfter(Node p,Node newNode){
        if (p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p,int value){
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }

    public void insertBefore(Node p,Node newNode){
        if (p == null) return;
        if (p ==head){
            insertToHead(newNode);
        }

        Node q = head;
        while (q.next!=null && q.next != p){
                q = q.next;
        }
        if(q == null){
            return;
        }

        newNode.next = p;
        q.next = newNode;
    }

    public void deleteBynNode(Node p){

        if (p == null|| head ==null) return;

        if (p == head){
            head = head.next;
            return;
        }

        Node q = head;
        while (q!=null && q.next != p){
            q = q.next;
        }

        if (q == null) return;

        q.next = q.next.next; //因为上边的if条件处理之后 q.next = p

    }

    public void deleteByValue(int value){
        if (head == null) return;

        Node p = head;
        Node q = null;

        while(p != null&&p.data!=value){
            q = p;
            p = p.next;
        }

        if (p==null){
            return;
        }

        if (q ==null){
            head = head.next;
        }else{
            q.next = q.next.next;
        }
    }

    public void printAll(){
        Node q = head;
        if(q != null){
            System.out.print(q.data+" ");
            q = q.next;
        }
        System.out.println();
    }


    public static class Node{
        private int data;
        private Node next;

        public Node (int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getNext(){
            return this.data;
        }
        }


}

