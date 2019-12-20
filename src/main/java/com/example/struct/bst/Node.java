package com.example.struct.bst;

import java.util.HashMap;

public class Node implements Comparable<Node> {
    public int value;
    public Node leftNode;
    public Node rightNode;

    public Node(int value){
        this.value=value;
    }
    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }

    /**
     * 添加一个节点
     * @param node
     */
    public void add(Node node,Node addNode) {
        if(addNode.value<node.value && node.leftNode==null){
            node.leftNode=addNode;
            return;
        }
        if(addNode.value<node.value && node.leftNode!=null){
            add(node.leftNode,addNode);
        }
        if (addNode.value>node.value && node.rightNode==null){
            node.rightNode=addNode;
            return;
        }
        if(addNode.value>node.value && node.rightNode!=null){
            add(node.rightNode,addNode);
        }
    }

    /**
     * 得到节点的高度
     * @return
     */
    public int getHeight(){
        return Math.max(leftNode !=null?leftNode.getHeight():0,rightNode !=null?rightNode.getHeight():0)+1;
    }

    /**
     * 中序遍历这个节点
     * @param node
     */
    public void midShow(Node node) {
        if(node!=null){
            midShow(node.leftNode);
            System.out.println(node.value);
            midShow(node.rightNode);
        }
    }

    /**
     * 查找一个节点
     * @param value
     * @return
     */
    public Node select(Node node,int value) {
        if(node==null){
            return null;
        }
        if(node.value==value){
            return node;
        }
        if(value<node.value){
            return select(node.leftNode,value);
        }else {
            return select(node.rightNode,value);
        }
    }
    /**
     * 删除一个节点
     * @param value
     */
    public Node delete(int value) {
        //得到这个结点和他的父节点
        Node node=select(this,value);
        Node parentsNode=selectParents(this,node);
        //判断节点的类型
        System.out.println("node="+node.value);
        if ( node==null){
            return this;
        }else if(parentsNode==null){
            //如果删除的是跟节点
            Node rMixNode=node.rightNode;
            Node rMixParentsNode=node;
            while (rMixNode.leftNode!=null){
                rMixParentsNode=rMixNode;
                rMixNode=rMixNode.leftNode;
            }
            if(rMixParentsNode.value==node.value){
                rMixNode.leftNode=node.leftNode;
            }else {
                rMixParentsNode.leftNode=rMixNode.rightNode;
                rMixNode.leftNode=node.leftNode;
                rMixNode.rightNode=node.rightNode;
            }

            return rMixNode;
        }
        if (node.rightNode==null && node.leftNode==null){
            //删除叶子节点
            if(parentsNode.leftNode!=null && parentsNode.leftNode.value==node.value){
                parentsNode.leftNode=null;
            }else {
                parentsNode.rightNode=null;
            }
        }else if (node.rightNode !=null && node.leftNode!=null){
            //要删除的节点含有两个子节点
            //使用左子树的最大节点或使用右子树的最小节点
            //适应右子树的最小值
            Node rMixNode=node.rightNode;
            Node rMixParentsNode=node;
            while (rMixNode.leftNode!=null){
                rMixParentsNode=rMixNode;
                rMixNode=rMixNode.leftNode;
            }
            //判断要删除节点的左右位置
            if(parentsNode.leftNode!=null && parentsNode.leftNode.value==node.value){
                parentsNode.leftNode=rMixNode;
            }else {
                parentsNode.rightNode=rMixNode;
            }
            if(rMixParentsNode.value==node.value){
                rMixNode.leftNode=node.leftNode;
            }else {
                rMixParentsNode.leftNode=rMixNode.rightNode;
                rMixNode.leftNode=node.leftNode;
                rMixNode.rightNode=node.rightNode;
            }

        }else {
            //删除独臂节点
            if(node.leftNode!=null){
                if(parentsNode.leftNode!=null && parentsNode.leftNode.value==node.value){
                    parentsNode.leftNode=node.leftNode;
                }else {
                    parentsNode.rightNode=node.leftNode;
                }
            }else {
                if(parentsNode.leftNode!=null && parentsNode.leftNode.value==node.value){
                    parentsNode.leftNode=node.rightNode;
                }else {
                    parentsNode.rightNode=node.rightNode;
                }
            }
        }
        return this;
    }

    /**
     * 得到这个节点的父节点
     * @param node
     * @return
     */
    private Node selectParents(Node r,Node node) {
        if(r==null){
            return null;
        }
        if ((r.leftNode!=null &&r.leftNode.value==node.value) || (r.rightNode!=null && r.rightNode.value==node.value)){
            return r;
        }
        if(node.value<r.value){
            return selectParents(r.leftNode,node);
        }else {
            return selectParents(r.rightNode,node);
        }


    }


}
