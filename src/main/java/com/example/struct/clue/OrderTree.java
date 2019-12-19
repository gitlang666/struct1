package com.example.struct.clue;

public class OrderTree {
    private int[] arr;

    public OrderTree(int[] arr) {
        this.arr = arr;
    }

    public void beforeShow(int n){
        if(n<arr.length){
            System.out.println(arr[n]);
        }
        if(2*n+1<arr.length){
            beforeShow(2*n+1);
        }
        if(2*n+2<arr.length){
            beforeShow(2*n+2);
        }
    }
    //0,1,3

    public int[] getArr() {
        return arr;
    }
}
