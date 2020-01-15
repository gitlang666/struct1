package com.example.struct.sort;

public class BucketSort {
    public static void Srot(int arr[],int bucket[][],int bucketIndex[]){
        int div1=1;
        int temp=0;
        while (bucketIndex[0]<arr.length-1){
            //设置桶的索引
            for(int i=0;i<bucketIndex.length;i++){
                bucketIndex[i]=0;
            }
            for(int i=0;i<arr.length;i++){
                //temp代表桶的编号
                temp=(arr[i]/div1)%10;
                bucket[temp][bucketIndex[temp]]=arr[i];
                //桶的索引变化
                bucketIndex[temp]+=1;
            }
            div1*=10;
            int count=0;
            for(int i=0;i<bucket.length;i++){
                for (int j=0;j<bucketIndex[i];j++){
                    arr[count]=bucket[i][j];
                    count+=1;
                }
            }

        }
    }
}
