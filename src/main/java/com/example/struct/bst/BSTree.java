package com.example.struct.bst;

public class BSTree {
    public Node root;

    public BSTree(Node root){
        this.root=root;
    }

    public void add(Node node){
        this.root.add(root,node);
    }

    /**
     *中序遍历
     */
    public void midShow(){
        this.root.midShow(root);
    }

    /**
     * 查找一个节点
     * @param value
     * @return
     */
    public Node select(int value){
        return this.root.select(root,value);
    }

    /**
     * 删除一个节点
     * @param value
     */
    public void delete(int value){
        root=this.root.delete(value);
    }
}
