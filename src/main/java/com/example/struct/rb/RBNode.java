package com.example.struct.rb;

import java.time.temporal.ValueRange;

public class RBNode {
    public RBNode left;
    public RBNode right;
    public RBNode parent;
    /**
     * 0代表黑色，1代表红色
     */
    public int color;
    public int value;

    public RBNode(int value){
        this.value=value;
        //插入的节点都是红色
        this.color=1;
    }




}
