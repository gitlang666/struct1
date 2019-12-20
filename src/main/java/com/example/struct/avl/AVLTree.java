package com.example.struct.avl;

public class AVLTree {
    public Node root;

    public AVLTree(Node root){
        this.root=root;
    }
    public AVLTree(){};
    public void add(Node node){
        if(this.root==null){
            this.root=node;
        }else {
            this.root.add(node);
        }
    }

    public int getHeight(){
        return this.root.getHeight();
    }

    public void midShow(){
        this.root.midShow();
    }
    public void delete(int i){
        this.root=this.root.delete(i);
        root.banlance();
    }
    public void beforeShow(){
        this.root.beforeShow(root);
    }

    public void show() {
        this.root.show();
    }
}
