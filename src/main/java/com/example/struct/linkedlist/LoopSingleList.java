package com.example.struct.linkedlist;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class LoopSingleList {
    public SingleList.SingleNode root;

    public LoopSingleList(SingleList.SingleNode root) {
        this.root = root;
        this.root.next=this.root;
    }

    public void add(SingleList.SingleNode singleNode){
        SingleList.SingleNode node=root;
        while (node.next!=root){
            node=node.next;
        }
        node.next=singleNode;
        singleNode.next=this.root;
    }

    public void delete(SingleList.SingleNode singleNode){
        SingleList.SingleNode node=root;
        if(node.next==root && singleNode==root){
            this.root=null;
            return;
        }
        while (node.next!=root){
            if(node.next.n==singleNode.n){
                break;
            }
            node=node.next;
        }
        node.next=node.next.next;
        if(singleNode==root){
            this.root=node;
        }
    }

    /**
     * 使用向项循环链表解决约瑟夫环
     * @param k
     */
    public void ysf(int k){
        int count=1;
        SingleList.SingleNode node=root;
        SingleList.SingleNode node1=null;
        while (root.next!=root){
            if(count==k){
                node1=node.next;
                count=1;
                System.out.println(node.n);
                delete(node);
                node=node1;
            }
            node=node.next;
            count++;
        }
        System.out.println(root.n);
    }
}
