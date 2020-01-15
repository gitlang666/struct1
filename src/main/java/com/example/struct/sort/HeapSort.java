package com.example.struct.sort;

public class HeapSort {

    public HeapNode createHeap(int[] arr,int last){
        if(last==0 || last>=arr.length){
            return null;
        }
        HeapNode head=new HeapNode(arr[0]);
        for(int i=0;i<last;i++){
            int li=i*2+1;
            int ri=i*2+2;

        }
        return head;
    }
}
