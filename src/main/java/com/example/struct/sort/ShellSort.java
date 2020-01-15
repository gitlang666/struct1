package com.example.struct.sort;

public class ShellSort {

    public static void sort(int[] arr){
        int len=arr.length;
        for(int i=len/2;i>0;i/=2){
            int gad=i;
            for(int j=0;j<gad;j++){
                for(int k=j;k<len;k+=gad){
                    int temp=arr[k];
                    int l=k-gad;
                    while (l>=0 && temp<arr[l]){
                       arr[l+gad]= arr[l];
                       l-=gad;
                    }
                    arr[l+gad]=temp;
                }
            }
        }
    }
}
