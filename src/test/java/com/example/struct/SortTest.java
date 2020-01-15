package com.example.struct;

import com.example.struct.sort.BucketSort;
import com.example.struct.sort.MergeSort;
import com.example.struct.sort.ShellSort;
import com.example.struct.sort.Sort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.Arrays;

public class SortTest {
    @Test
    void shellTest(){
        int len=8000000;
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=(int)(Math.random()*80000000);
        }
        System.out.println("kaishi");
        long date1=System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
//        ShellSort.sort(arr);
//        Sort.bubble(arr);
//        Sort.insert(arr);
//        Sort.quick(arr,0,arr.length-1);
//        int[] temp=new int[len];
//        MergeSort.merge(arr,0,len-1,temp);
        //桶排序
        int[][] bucket=new int[10][len];
        int[] bucketIndex=new int[10];
        BucketSort.Srot(arr,bucket,bucketIndex);
        long date2=System.currentTimeMillis();
        System.out.println(date2 - date1);
//        System.out.println(Arrays.toString(arr));
    }
}
