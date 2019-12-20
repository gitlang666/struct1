package com.example.struct.avl;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value=value;
    }

    public int getHeight(){
        return Math.max(left!=null?left.getHeight():0,right!=null?right.getHeight():0)+1;
    }


    public void add(Node node) {
        if(node==null){
            return;
        }
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
        if ((this.left!=null?this.left.getHeight():0)-(this.right!=null?this.right.getHeight():0)>1){
            //左左
            if(this.left.left.getHeight()>=this.left.right.getHeight()){
                rotateRight();
            }else {
                this.left.rotateLeft();
                rotateRight();
            }

        }else if ((this.left!=null?this.left.getHeight():0)-(this.right!=null?this.right.getHeight():0)<-1){
            //右右
            if(this.right.right.getHeight()>=this.right.left.getHeight()){
                rotateLeft();
            }else {
                this.right.rotateRight();
                rotateLeft();
            }
        }

    }

    /**
     * 有旋转
     */
    private void rotateRight(){
        //将当前节点信息复制到新节点中
        Node node=new Node(this.value);
        //设置新节点的右节点
        node.right=this.right;
        //设置新节点的左节点
        node.left=this.left.right;
        //将左节点信息复制到当前节点中
        this.value=this.left.value;
        //重新设置当前节点的左右节点
        this.left=this.left.left;
        this.right=node;
    }

    private void rotateLeft(){
        //新建一个节点
        Node node =new Node(this.value);
        //设置新节点的左节点；
        node.left=this.left;
        //设置新节点的右节点
        node.right=this.right.left;
        //将右节点信息复制到当前记得中
        this.value=this.right.value;
        //重新设置节点
        this.left=node;
        this.right=this.right.right;
    }

    /**
     * z中序遍历
     */
    public void midShow() {
        if (this.left!=null){
            this.left.midShow();
        }
        System.out.print(this.value+",");
        if(this.right!=null){
            this.right.midShow();
        }

    }

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
            Node rMixNode=node.right;
            Node rMixParentsNode=node;
            while (rMixNode.left!=null){
                rMixParentsNode=rMixNode;
                rMixNode=rMixNode.left;
            }
            if(rMixParentsNode.value==node.value){
                rMixNode.left=node.left;
            }else {
                rMixParentsNode.left=rMixNode.right;
                rMixNode.left=node.left;
                rMixNode.right=node.right;
            }

            return rMixNode;
        }
        if (node.right==null && node.left==null){
            //删除叶子节点
            if(parentsNode.left!=null && parentsNode.left.value==node.value){
                parentsNode.left=null;
            }else {
                parentsNode.right=null;
            }
        }else if (node.right !=null && node.left!=null){
            //要删除的节点含有两个子节点
            //使用左子树的最大节点或使用右子树的最小节点
            //适应右子树的最小值
            Node rMixNode=node.right;
            Node rMixParentsNode=node;
            while (rMixNode.left!=null){
                rMixParentsNode=rMixNode;
                rMixNode=rMixNode.left;
            }
            //判断要删除节点的左右位置
            if(parentsNode.left!=null && parentsNode.left.value==node.value){
                parentsNode.left=rMixNode;
            }else {
                parentsNode.right=rMixNode;
            }
            if(rMixParentsNode.value==node.value){
                rMixNode.left=node.left;
            }else {
                rMixParentsNode.left=rMixNode.right;
                rMixNode.left=node.left;
                rMixNode.right=node.right;
            }

        }else {
            //删除独臂节点
            if(node.left!=null){
                if(parentsNode.left!=null && parentsNode.left.value==node.value){
                    parentsNode.left=node.left;
                }else {
                    parentsNode.right=node.left;
                }
            }else {
                if(parentsNode.left!=null && parentsNode.left.value==node.value){
                    parentsNode.left=node.right;
                }else {
                    parentsNode.right=node.right;
                }
            }
        }



        return this;
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
            return select(node.left,value);
        }else {
            return select(node.right,value);
        }
    }

    /**
     * 得到这个节点的父节点
     * @param node
     * @return
     */
    private Node selectParents(Node r, Node node) {
        if(r==null){
            return null;
        }
        if ((r.left!=null &&r.left.value==node.value) || (r.right!=null && r.right.value==node.value)){
            return r;
        }
        if(node.value<r.value){
            return selectParents(r.left,node);
        }else {
            return selectParents(r.right,node);
        }

    }

    /**
     * 删除一个节点后再平衡
     */
    public void banlance(){
        if(!(this.left==null && this.right==null)){
            if ( (this.left!=null?this.left.getHeight():0)-(this.right!=null?this.right.getHeight():0)>1){
                //左左
                if(this.left.left.getHeight()>=this.left.right.getHeight()){
                    rotateRight();
                }else {
                    this.left.rotateLeft();
                    rotateRight();
                }

            }else if ((this.left!=null?this.left.getHeight():0)-(this.right!=null?this.right.getHeight():0)<-1){
                //右右
                if(this.right.right.getHeight()>=this.right.left.getHeight()){
                    rotateLeft();
                }else {
                    this.right.rotateRight();
                    rotateLeft();
                }
            }else {
                this.left.banlance();
                this.left.banlance();
            }
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    public void beforeShow(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+",");
        beforeShow(node.left);
        beforeShow(node.right);
    }
}
