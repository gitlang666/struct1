package com.example.struct.hash;

public class Node implements GetValue<Node> {

    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }


    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void append(Node node) {
        if(this.next==null){
            this.next=node;
        }else {
            this.next.append(node);
        }

    }

    @Override
    public void show() {
        System.out.print(this.value+" ");
        if (this.next==null){
            System.out.println();
        }else {
            this.next.show();
        }
    }

    @Override
    public Node getNode(int k) {
        if(k==this.value){
            return this;
        }
        return this.next.getNode(k);
    }

    @Override
    public void delete(Node node) {
        if(this.next!=null){
            if(this.next.value==node.value){
                this.next=this.next.next;
            }else {
                this.next.delete(node);
            }
        }

    }
}
