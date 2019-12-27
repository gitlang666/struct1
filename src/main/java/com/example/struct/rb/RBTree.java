package com.example.struct.rb;

import com.example.struct.bst.Node;

import java.util.LinkedList;
import java.util.Queue;

public class RBTree {
    public RBNode root;
    public RBTree(){

    }

    /**
     * 右旋转 当前节点与左节点
     */
    private void rotateRight(RBNode rbNode){
//        //将当前节点信息复制到新节点中
//        RBNode node=new RBNode(rbNode.value);
//        node.color=rbNode.color;
////        node.parent=rbNode.left;
//        //设置新节点的右节点
//        node.right=rbNode.right;
//        if (node.right!=null) {
//            node.right.parent=node;
//        }
//        //设置新节点的左节点
//        node.left=rbNode.left.right;
//        if (node.left!=null) {
//            node.left.parent=node;
//        }
//        //将左节点信息复制到当前节点中
//        rbNode.value=rbNode.left.value;
//        rbNode.value=rbNode.left.color;
//        //重新设置当前节点的左右节点
//        rbNode.left=rbNode.left.left;
//        if(rbNode.left!=null){
//            rbNode.left.parent=rbNode;
//        }
//        rbNode.right=node;
//        node.parent=rbNode;

        RBNode rbNodelr=rbNode.left.right;
        RBNode rbNodel=rbNode.left;
        if (rbNode.parent!=null) {
            if(rbNode.parent.left!=null&&rbNode.parent.left==rbNode){
                rbNode.parent.left=rbNode.left;
            }else {
                rbNode.parent.right=rbNode.left;
            }

        }else {
            this.root=rbNodel;
        }
        rbNodel.right=rbNode;
        rbNodel.parent=rbNode.parent;
        rbNode.left=rbNodelr;
        if (rbNodelr!=null) {
            rbNodelr.parent=rbNode;
        }
        rbNode.parent=rbNodel;


    }

    /**
     * 左旋转 当前节点与右节点
     */
    private void rotateLeft(RBNode rbNode){
//        //新建一个节点
//        RBNode node =new RBNode(rbNode.value);
//        node.color=rbNode.color;
////        node.parent=rbNode.right;
//        //设置新节点的左节点；
//        node.left=rbNode.left;
//        if (node.left!=null) {
//            node.left.parent=node;
//        }
//        //设置新节点的右节点
//        node.right=rbNode.right.left;
//        if(node.right!=null){
//            node.right.parent=node;
//        }
//        //将右节点信息复制到当前记得中
//        rbNode.value=rbNode.right.value;
//        rbNode.value=rbNode.right.color;
//        //重新设置节点
//        rbNode.left=node;
//        rbNode.right=rbNode.right.right;
//        if (rbNode.right!=null) {
//            rbNode.right.parent=rbNode;
//        }
//        node.parent=rbNode;

        RBNode rbNodelr=rbNode.right.left;
        RBNode rbNodel=rbNode.right;
        if (rbNode.parent!=null) {
            if(rbNode.parent.left!=null&&rbNode.parent.left==rbNode){
                rbNode.parent.left=rbNodel;
            }else {
                rbNode.parent.right=rbNodel;
            }
        }else {
            this.root=rbNodel;
        }
        rbNodel.left=rbNode;
        rbNodel.parent=rbNode.parent;
        rbNode.right=rbNodelr;
        if (rbNodelr!=null) {
            rbNodelr.parent=rbNode;
        }
        rbNode.parent=rbNodel;
    }
    public void add(RBNode node){
        if(root==null){
            this.root=node;
            this.root.color=0;
            node.parent=null;
            return;
        }
        add(node,this.root);
    }

    private void add(RBNode node,RBNode rbNode) {
        if(node==null){
            return;
        }
        if(node.value<rbNode.value){
            if(rbNode.left==null){
                rbNode.left=node;
                node.parent=rbNode;
            }else {
                add(node,rbNode.left);
            }
        }else {
            if(rbNode.right==null){
                rbNode.right=node;
                node.parent=rbNode;
            }else {
                add(node,rbNode.right);
            }
        }
        balanceAdd(node);


    }

    private void balanceAdd(RBNode node){
        RBNode parent;
        RBNode gParent;
        //父节点为红时进行调整
        while ((parent=parentOf(node))!=null && parent.color==1)
        {
            gParent=parentOf(parent);
                //父节点是左孩子，叔父节点是右孩子
                if(gParent.left==parent){
                    //如果是从情况1开始发生的，必然会走完情况2和3，也就是说这是一整个流程，
                    // 当然咯，实际中可能不一定会从情况1发生，如果从情况2开始发生，那再走个情况3即可完成调整，如果直接只要调整情况3，那么前两种情况均不需要调整了

                    if(gParent.right!=null && gParent.right.color==1){
                        //情况1
                        //父节点和叔父节点都为红
                        //将当前节点(4) 的父节点(5) 和叔叔节点(8) 涂黑，将祖父节点(7)涂红
                        //再将当前节点指向其祖父节点，再次从新的当前节点开始算法
                        gParent.left.color=0;
                        gParent.right.color=0;
                        gParent.color=1;
                        node=gParent;
                        continue;
                    }else {
                            if (parent.right==node){
                                //情况2
                                //插入节点的父节点是红色的，叔叔节点是黑色的，且插入节点是其父节点的右子节点
                                //将当前节点(7)的父节点(2)作为新的节点，以新的当前节点为支点做左旋操作
                                rotateLeft(parent);
                                RBNode temp=node;
                                node=parent;
                                parent=temp;
                        }
                            //情况3
                        //插入节点的父节点是红色，叔叔节点是黑色，且插入节点是其父节点的左子节点
                        //将当前节点的父节点(7)涂黑，将祖父节点(11)涂红，在祖父节点为支点做右旋操作
                        parent.color=0;
                        gParent.color=1;
                        rotateRight(gParent);
                    }

                }else {
                    //父节点和叔父节点都为红
                    if(gParent.left!=null && gParent.left.color==1){
                        gParent.left.color=0;
                        gParent.right.color=0;
                        gParent.color=1;
                        node=gParent;
                        continue;
                    }else{
                        if (parent.left==node){
                            rotateRight(parent);
                            RBNode temp=node;
                            node=parent;
                            parent=temp;

                        }
                        parent.color=0;
                        gParent.color=1;
                        rotateLeft(gParent);
                }
                }



        }
        if(root==node){
            this.root.color=0;
        }
    }

    /**
     * 查找一个节点的父节点
     * @param rbNode
     * @return
     */
    public RBNode parentOf(RBNode rbNode){
        return rbNode.parent;
//        return parentOf(rbNode,null,this.root);
    }

    /**
     * 查找一个节点的父节点
     * @param rbNode 要查找节点
     * @param parent  node的父节点
     * @param node 当前节点
     * @return
     */
    public RBNode parentOf(RBNode rbNode,RBNode parent,RBNode node){
        if(rbNode ==null){
            return null;
        }
        if(node==null){
            return null;
        }
        if(node.value==rbNode.value){
            return parent;
        }else if(node.value>rbNode.value){
            return parentOf(rbNode,node,node.left);
        }else {
            return parentOf(rbNode,node,node.right);
        }
    }

    /**
     * 根据层遍历树，广度优先
     */
    public void bfsShow(){
        Queue<RBNode> queue=new LinkedList<>();
        queue.add(root);
        int count1=1,count2=0,count3=0;
        RBNode rbNode;
        while (!queue.isEmpty()){
            rbNode=queue.poll();
            System.out.print(rbNode.value+"-C"+rbNode.color+" ");
            count1--;
            if(rbNode.left!=null){
                queue.add(rbNode.left);
                count2++;
            }
            if (rbNode.right!=null){
                queue.add(rbNode.right);
                count2++;
            }
            if(count1==0){
                count3++;
                count1=count2;
                count2=0;
                System.out.print("->"+count3+"\n");
            }
        }
    }

    public RBNode delete(int num){
        RBNode node=null;
        RBNode rbNode=this.root;
        while (node==null&&rbNode!=null){
            if(num==rbNode.value){
                node=rbNode;
                break;
            }else if(num<rbNode.value){
                rbNode=rbNode.left;
            }else {
                rbNode=rbNode.right;
            }
        }
        //替换节点；
        RBNode replace=null;

        if(node==null){
            return node;
        }
        //判断要删除节点的位置类型
        if(node.left==null&&node.right==null){
            //如果node是一个叶节点
            if(node.parent!=null){
                if(node.parent.left!=null && node.parent.left==node){
                    node.parent.left=null;
                }else {
                    node.parent.right=null;
                }
                //如果删除的是一个红色节点不需要调整，如果是一个黑色节点
                // 违反根节点到所有叶子节点的黑色节点数一样多。需要调整
                //没有替换节点
                if(node.color==0){
                    balanceDelete(node,replace);
                }
            }else {
                //只有一个根节点
                this.root=null;
            }


        }else if(node.left!=null && node.right!=null){
            //如果同时有左右节点
            //找到当前节点的后继节点或者前驱节点，这里使用后继节点，第一个比当前节点大的节点
            RBNode lastOneNext=node.right;
            while (lastOneNext.left!=null){
                lastOneNext=node.left;
            }
            //这个找到的节点没有左节点
            lastOneNext.parent.left=lastOneNext.right;
            if(lastOneNext.right!=null){
                lastOneNext.right.parent=lastOneNext.parent;
            }
            lastOneNext.left=node.left;
            lastOneNext.right=node.right;
            lastOneNext.parent=node.parent;


            if(node.parent!=null){
                if(node.parent.left!=null && node.parent.left==node){
                    node.parent.left=lastOneNext;
                }else {
                    node.parent.right=lastOneNext;
                }
            }else {
                this.root=lastOneNext;
            }
            replace=lastOneNext;
            //不管删除的是什么都要进行平衡

            balanceDelete(node,replace);



        }else {
            //如果只有一个节点
            if(node.left!=null){
                if(node.parent!=null){
                    if(node.parent.left!=null && node.parent.left==node){
                        node.parent.left=node.left;
                        node.left.parent=node.parent;

                    }else {
                        node.parent.right=node.left;
                        node.left.parent=node.parent;
                    }
                }else {
                    //如果删除的是根节点
                    this.root=node.left;
                    this.root.parent=null;
                    node.left=null;
                    this.root.color=0;
                    return node;
                }
                //设置替换节点
                replace=node.left;

            }else {
                if(node.parent!=null){
                    if (node.parent.left!=null && node.parent.left==node) {
                        node.parent.left=node.right;
                        node.right.parent=node.parent;
                    }else {
                        node.parent.right=node.right;
                        node.right.parent=node.parent;
                    }
                }else {
                    //如果删除的是根节点
                    this.root=node.right;
                    this.root.parent=null;
                    node.right=null;
                    this.root.color=0;
                    return node;
                }
                //设置替换节点
                replace=node.right;
            }

            //如果删除节点是红色折不需要调整
            //如果是黑色则需要根本替换节点进行变换
            if(node.color==0){
                balanceDelete(node,replace);
            }
        }
        return node;
    }

    /**
     * 删除后的平衡
     * @param delNode
     * @param repNode
     */
    public void  balanceDelete(RBNode delNode,RBNode repNode){
        if(delNode.color==0&& repNode==null){

        }
    }


}
