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

    public void printAll() {
        Node q = head;
        while (q != null) {
            System.out.print(q.data + " ");
            q = q.next;
        }
        System.out.println();
    }

    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);

        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                break;
            }
        }
        System.out.println("什么结果");
        if (l == null && r == null) {
            System.out.println("什么结果");
            return true;
        } else {
            return false;
        }
    }
    //回文判断
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            //1.开始找中间节点
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }

            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }
            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;

            if (q.next == null) {
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个节点" + leftLink.data);
                System.out.println("右边的第一个节点" + rightLink.data);
            } else {
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }

            return TFResult(leftLink, rightLink);

        }

    }
    //带节点的链表翻转
    public Node inverseLinkList_head(Node p) {
        //Head 为新建一个头节点
        Node Head = new Node(9999, null);
        //p 为原来整个链表的头结点，现在Head 指向整个链表
        Head.next = p;
        /*带头结点的链表翻转等价于
        从第二个元素开始重新插法建立链表
        */
        Node Cur = p.next;
        p.next = null;
        Node next = null;

        while (Cur != null) {
            next = Cur.next;
            Cur.next = Cur;
            System.out.println("first" + Head.data);

            Cur = next;
        }
        //返回左半部分的中点之前的那个节点
        //从此开始同步向两边比较
        return Head;

    }
    //无头节点的链表翻转
    public Node inverseLinkList(Node p) {

        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.data);
        Node next = null;
        while (r != p) {
            next = r.next;
            r.next = pre;

            pre = r;
            r = next;
        }

        r.next = pre;

        return r;
    }
    public static  Node creatNode(int value){
        return new Node(value,null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getNext() {
            return this.data;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello linkedList");

        //int[] data = {1,2,5,3,1};
        int[] data = {1,2,5,2,1};

        for (int i = 0; i < data.length; i++) {
            link.insertTail(data[i]);
        }

        link.printAll();

        Node p = link.inverseLinkList_head(link.head);
        while (p!=null){
            System.out.println("aa"+p.data);
            p = p.next;
        }

        System.out.println("打印原始：");
        link.printAll();
        if (link.palindrome()){
            System.out.println("回文");
        }else {
            System.out.println("不是回文");
        }
    }


}

