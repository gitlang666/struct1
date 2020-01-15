package com.example.struct.sort;

public class MergeSort {

    public static void merge(int arr[],int left,int right,int[] temp){
        if(left<right){
            int mid=(right+left)/2;
            merge(arr,left,mid,temp);
            merge(arr,mid+1,right,temp);
            process(arr,left,mid,right,temp);
        }
    }

    private static void process(int arr[],int left,int mid,int right,int temp[]){
        int i=left,j=mid+1;
        int count=0;
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[count]=arr[i];
                i+=1;
                count+=1;
            }else {
                temp[count]=arr[j];
                j+=1;
                count+=1;
            }
        }

        if(i<mid){
            for(;i<=mid;i++){
                temp[count]=arr[i];
                count+=1;
            }
        }
        if(j<=right){
            for (;j<right;j++){
                temp[count]=arr[j];
                count+=1;
            }
        }

        for(int k=0;k<count;k++){
            arr[left]=temp[k];
            left+=1;
        }
    }
}
