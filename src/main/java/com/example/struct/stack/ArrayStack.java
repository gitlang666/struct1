package com.example.struct.stack;

public class ArrayStack<T> {
    public Object[] arr;
    public int maxSize;
    public int head;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr=new Object[maxSize];
        this.head=-1;
    }

    public boolean isEmpty(){
        if (this.head==-1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(this.head==maxSize-1){
            return true;
        }
        return false;
    }

    public void add(T t){
        if(!isFull()){
            this.head++;
            arr[this.head]=t;
        }
    }

    public T pop(){
        if(!isEmpty()){
            return (T) arr[head--];
        }
        return null;
    }


}
