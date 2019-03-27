package com.zhy.day03Stack;

/**
 * @ClassName: SampleBrowser
 * @Description: 实现浏览器前进后退
 * @auther: zhy
 * @Date: 2019/3/25 19:39
 * @Version: 1.0
 **/
public class SampleBrowser {

    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("www.baidu.com");
        browser.open("www.pornhub.com");
        browser.open("www.xixi.com");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();

    }
    private String currPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser(){
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    public void open(String url){
        if(this.currPage!=null){
            this.backStack.push(this.currPage);
            this.forwardStack.clear();
        }
        show(url,"Open");
    }

    public boolean canGoBack(){
        return this.backStack.size>0;
    }

    public boolean canGoForward(){
        return this.forwardStack.size>0;
    }

    public String goBack(){
        if(this.canGoBack()){
            this.forwardStack.push(this.currPage);
            String backUrl = this.backStack.pop();
            show(backUrl,"Back");
            return backUrl;
        }
        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    public  String goForward(){
        if (this.canGoForward()){
            this.backStack.push(this.currPage);
            String forwardUrl = this.forwardStack.pop();
            show(forwardUrl,"Forward");
            return forwardUrl;
        }
        System.out.println("** Cannot go forward, no pages ahead.");
        return null;
    }
    public void show(String url,String prefix){
        this.currPage = url;
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currPage);
    }

    public static class LinkedListBasedStack{
        private int size;
        private Node top;

        static Node createNode(String value,Node next){
            return new Node(value,next);
        }

        public void clear(){
            this.top = null;
            this.size = 0;
        }

        public void push(String data){
            Node node = createNode(data,this.top);
            this.top = node;
            this.size++;
        }

        public String pop(){
            Node popNode = this.top;
            if(popNode == null){
                System.out.println("Stack is empty...");
                return null;
            }

            this.top = popNode.next;
            if (this.size>0){
                this.size--;
            }
            return popNode.data;
        }

        public String getTopData(){
            if (this.top==null){
                return null;
            }
            return this.top.data;
        }


        public void print(){
            Node currNode = this.top;
            while (currNode!=null){
                System.out.print(currNode.data+"");
                currNode = currNode.next;
            }
            System.out.println("");
        }


        public static class Node{
            private String data;
            private Node next;

            public Node(String value){
                this(value,null);
            }

            public Node(String value,Node next){
                this.data = value;
                this.next = next;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }
}
