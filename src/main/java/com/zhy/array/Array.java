package com.zhy.array;

public class Array {
    //定义整数型数据data保存数据
    public int data[];
    //定义数组长度
    private int n;
    //定实际中的个数
    private int count;

    //构造方法,定义数组的大小
    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;//一开始一个数都没有存 所以是0
    }
    //根据索引,找到数组中的元素并返回
    public int find(int index){
        if (index<0||index>=count) return -1;
        return data[index];
    }
    //插入元素:头部插入,尾部插入
    public boolean insert(int index,int value){
        //数组空间已满 O(1)
        if(count==n){
            System.out.println("数组已满,没有插入的位置!!!");
            return false;
        }

        //如果数组还没有满,那么可以插入到数组中
        //位置不合法 O(1)
        if(index<0||index>count){
            System.out.println("位置不合法!");
            return false;
        }
        //位置合法
        /**
         * 复杂度分析
         * 如果是插入到最后一个复杂度就是O(1);这个应该和1/n的求法一样啊
         */
        for (int i = count; i <index ; --i) {
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    /**
     *时间复杂度为 O(n);
     * @param index
     * @return
     */
    //根据索引删除数组的元素
    public boolean delete (int index){
        //输入的index超出预期
        if(index<0||index>count) return false;
        //从删除位置开始,讲后边的元素向前移动一位
        for (int i = index+1; i <count ; ++i) {
            data[i-1] = data[i];
        }
        --count;
        return  true;
    }

    public void printAll(){
        for (int s = 0; s < count; s++) {
            System.out.print(data[s]+" ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();

        array.insert(0, 3);

        array.insert(0, 4);

        array.insert(1, 5);

        array.insert(3, 9);

        array.insert(3, 10);

        //array.insert(3, 11);

        array.printAll();
    }

}
