package com.example.struct.linkedlist;

import com.example.struct.bst.Node;

public class SingleList {

    public static class SingleNode{
        public int n;
        public String name;
        public SingleNode next;

        public SingleNode(int n, String name) {
            this.n = n;
            this.name = name;
        }

        @Override
        public String toString() {
            return "SingleNode{" +
                    "n=" + n +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public SingleNode head=new SingleNode(0,"");

    public void add(SingleNode singleNode){
        SingleNode node=this.head;
        while (node.next!=null){
            node=node.next;
        }
        node.next=singleNode;
    }

    public void insert(SingleNode singleNode){
        SingleNode node=this.head;
        while (node.next!=null){
            if(node.next.n>=singleNode.n){
                break;
            }
            node=node.next;
        }
        if(node.next!=null){
            singleNode.next=node.next.next;
        }
        node.next=singleNode;
    }

    public void update(SingleNode singleNode){
        SingleNode node=this.head;
        boolean flag=false;
        while (node.next!=null){
            if(node.next.n==singleNode.n){
                flag=true;
                node.next.name=singleNode.name;
            }
            node=node.next;
        }
        if(!flag){
            //没有这个元素
        }

    }

    public void delete(SingleNode singleNode){
        SingleNode node=this.head;
        boolean flag=false;
        while ((node.next!=null)){
            if(node.next.n==singleNode.n){
                flag=true;
                break;
            }
            node=node.next;
        }
        if(flag){
            node.next=node.next.next;
        }else {
            //没有找到
        }
    }

    //反转一个链表,也可以使用栈来实现
    public void reverseList(){
        SingleNode reverse=new SingleNode(0,"");
        if(head.next==null || head.next.next==null){
            return;
        }
        SingleNode node;
        while (head.next!=null){
            node=reverse.next;
            reverse.next=head.next;
            head.next=head.next.next;
            reverse.next.next=node;
        }
        head.next=reverse.next;
    }

    public void list(){
        SingleNode node=this.head;
        while (node.next!=null){
            System.out.println(node.next.toString());
            node=node.next;
        }
    }
}
