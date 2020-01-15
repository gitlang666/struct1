package com.example.struct.sort;

public class HeapNode {
    public int value;
    public HeapNode parents;
    public HeapNode left;
    public HeapNode right;

    public HeapNode(int value) {
        this.value = value;
    }
}
