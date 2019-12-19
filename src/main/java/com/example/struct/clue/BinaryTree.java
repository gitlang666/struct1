package com.example.struct.clue;

public class BinaryTree {
    private Node root;
    private Node preNode=null;
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    public void beforeShow(){
        root.beforeShow(root);
    }
    public void midShow(){
        root.midShow(root);
    }
    public void afterShow(){
        root.afterShow(root);
    }

    public void beforeDelete(int data){
        root.beforeDelete(data,root);
    }

    public void midClue(){
        midClue(root);
    }
    public void midClue(Node node){
        if(node != null){
            midClue(node.getLeftNode());

            if(node.getLeftNode()==null){
                node.setLeftNode(preNode);
                node.setFlagl(1);
            }

            if(preNode != null && preNode.getRightNode()==null){
                preNode.setRightNode(node);
                preNode.setFlagr(1);
            }
            preNode=node;
            midClue(node.getRightNode());
        }

    }
    public void midClueShow()
    {
        Node node=root;
        while (node!=null)
        {
            while (node.getLeftNode()!=null && node.getFlagl()==0)
            {
                node=node.getLeftNode();
            }
            System.out.println(node.getData());
            while (node.getFlagr()==1)
            {
                node=node.getRightNode();
                System.out.println(node.getData());
            }
            node=node.getRightNode();
        }
    }
    public void midClue2()
    {
        midClue2(root);
    }

    public void midClue2(Node node)
    {
        if(node ==null)
        {
            return;
        }
        midClue(node.getLeftNode());
        if(node.getLeftNode()==null)
        {
            node.setLeftNode(preNode);
            node.setFlagl(1);
        }
        if(preNode!=null && preNode.getRightNode()==null){
            preNode.setRightNode(node);
            preNode.setFlagr(1);
        }
        preNode=node;
        midClue(node.getRightNode());
    }

    public void arrayToTree(int[] arr)
    {
        if(arr.length>0){
            Node[] nodes=new Node[arr.length];
            for(int i=0;i<arr.length;i++){
                nodes[i]=new Node(arr[i]);
            }
            root=nodes[0];
            for (int i=0;i<nodes.length;i++){
                if(2*i+1<nodes.length){
                    nodes[i].setLeftNode(nodes[2*i+1]);
                }
                if(2*i+2<nodes.length){
                    nodes[i].setRightNode(nodes[2*i+2]);
                }

            }
        }
    }


    public void midClueShow2(){
        Node node=root;
        while (node!=null){
            while (node.getLeftNode()!=null && node.getFlagl()==0){
                node=node.getLeftNode();
            }
            System.out.println(node.getData());
            while (node.getFlagr()==1){
                node=node.getRightNode();
                System.out.println(node.getData());
            }
            node=node.getRightNode();
        }
    }

}
