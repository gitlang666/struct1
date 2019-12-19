package com.example.struct.clue;

public class Node {
    private Node leftNode;
    private int data;
    private Node rightNode;

    private int flagl,flagr;

    public Node(int data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public int getFlagl() {
        return flagl;
    }

    public void setFlagl(int flagl) {
        this.flagl = flagl;
    }

    public int getFlagr() {
        return flagr;
    }

    public void setFlagr(int flagr) {
        this.flagr = flagr;
    }

    public void afterShow(Node node) {

        if(node.getLeftNode()!=null){
            afterShow(node.getLeftNode());
        }
        if(node.getRightNode()!=null){
            afterShow(node.getRightNode());
        }
        if(node !=null){
            System.out.println(node.getData());
        }
    }

    public void midShow(Node node){
        if(node.getLeftNode()!=null){
            midShow(node.getLeftNode());
        }
        if(node!=null){
            System.out.println(node.getData());
        }
        if(node.getRightNode()!=null){
            midShow(node.getRightNode());
        }
    }

    public void beforeShow(Node node){
        if(node!=null){
            System.out.println(node.getData());
        }
        if (node.getLeftNode()!=null){
            beforeShow(node.getLeftNode());
        }
        if(node.getRightNode()!=null){
            beforeShow(node.getRightNode());
        }

    }

    public void beforeDelete(int data,Node node) {
        if(node==null){
            return;
        }
        if(node.getData()==data){
            node=null;
            return;
        }
        if(node.getLeftNode()!=null){
            if(node.getLeftNode().getData()==data){
                node.setLeftNode(null);
            }else {
                beforeDelete(data,node.getLeftNode());
            }
        }
        if(node.getRightNode()!=null){
            if(node.getRightNode().getData()==data){
                node.setRightNode(null);
            }else {
                beforeDelete(data,node.getRightNode());
            }
        }
    }
}
