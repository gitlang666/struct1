package com.example.struct.avl;

public class AVLTree {
    public Node root;

    public AVLTree(Node root){
        this.root=root;
    }
    public void add(Node node){
        this.root.add(node);
    }
}
