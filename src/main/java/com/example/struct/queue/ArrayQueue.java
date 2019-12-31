package com.example.struct.queue;

public class ArrayQueue {
    public int[] arr;
    public int head;
    public int tail;
    private int maxSize;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr=new int[this.maxSize];
        //头部
        this.head=0;
        //尾部
        this.tail=0;
    }

    public boolean isEmpty(){
        if(this.head==this.tail){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        //tail和的最大值是maxSize-1;
        if((tail+1)%maxSize==head ){
            return true;
        }
        return false;
    }
    public void add(int i){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }

        this.arr[this.tail]=i;
        tail=(tail+1)%maxSize;
    }
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("为空");
        }else {
            int s=this.arr[head];
            this.arr[head]=0;
            head=(head+1)%maxSize;
            return s;
        }

    }

}
