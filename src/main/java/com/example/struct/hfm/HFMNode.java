package com.example.struct.hfm;

public class HFMNode implements Comparable<HFMNode> {
    public HFMNode leftNode;
    public HFMNode rightNode;
    public int weights;
    public Byte value;

    public int lflag,rflag;

    public HFMNode(int weights,Byte value)
    {
        this.weights=weights;
        this.value=value;
    }

    @Override
    public int compareTo(HFMNode o) {
        return this.weights-o.weights;
    }

    public void midShow(HFMNode node) {
        if (node==null){
            return;
        }
        midShow(node.leftNode);
        System.out.println("weihths="+node.weights);
        midShow(node.rightNode);
    }

    @Override
    public String toString() {
        return "HFMNode{" +
                "weights=" + weights +
                ", value=" + value +
                '}';
    }

    public void threadNode(HFMNode node, HFMNode node1) {
    }
}
