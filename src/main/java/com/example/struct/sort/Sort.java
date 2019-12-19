package com.example.struct.sort;

public class Sort {
    public static void  bubble(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void quick(int[] arr,int s,int e){
        if(s<e){
            int i=s,j=e,temp=arr[i];
            while (i<j){
                while (i<j && arr[j]>temp){
                    j--;
                }
                if (i<j){
                    arr[i]=arr[j];
                    i++;
                }
                while (i<j && arr[i]<temp){
                    i++;
                }
                if(i<j){
                    arr[j]=arr[i];
                    j--;
                }
                arr[i]=temp;
                quick(arr,s,i-1);
                quick(arr,i+1,e);
            }
        }
    }

    public static void insert(int[] arr){
        for (int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i;
            for(;j>0;j--){
                if(arr[j-1]>temp){
                    arr[j]=arr[j-1];
                }else {

                    break;
                }
            }
            arr[j]=temp;
        }
    }
}
