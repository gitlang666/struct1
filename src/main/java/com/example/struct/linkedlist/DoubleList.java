package com.example.struct.linkedlist;

public class DoubleList {
    public static class DoubleNode{
        public int n;
        public String name;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int n, String name) {
            this.n = n;
            this.name = name;
        }
    }

    public DoubleNode head=new DoubleNode(0,"");
    public void delete(DoubleNode doubleNode){
        DoubleNode node=this.head;
        boolean flag=false;
        while (node.next!=null){
            if(node.next.n==doubleNode.n){
                if(node.next.next!=null){
                    node.next.next.pre=node;
                }
                node.next=node.next.next;
                flag=true;
                break;
            }
        }
        if(!flag){
            //没有这个数据
        }
    }

}


