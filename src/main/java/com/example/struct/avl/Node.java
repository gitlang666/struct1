package com.example.struct.avl;

public class Node {
    public int value;
    public Node left;
    public Node rigth;
    public int height;

    public Node(int value){
        this.value=value;
    }

    public boolean isBalanced(){
        int leftHeigth=this.left==null?0:this.left.height;
        int rightHeight=this.rigth==null?0:this.rigth.height;
        return Math.abs(leftHeigth=rightHeight) <=1?true:false;
    }


    public void add(Node node) {

    }


}
