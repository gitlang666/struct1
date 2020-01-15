package com.example.struct.graph;

public class Connected {
    public Vertex v1;
    public Vertex v2;
    public int w;
    //新加入点的索引
    public int index;

    public Connected(Vertex v1, Vertex v2, int w,int index) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
        this.index=index;
    }

    @Override
    public String toString() {
        return "Connected{" +
                "v1=" + v1.getValue() +
                ", v2=" + v2.getValue() +
                ", w=" + w +
                '}';
    }
}
