package com.example.struct.graph;

public class Vertex {
    private String value;
    private Vertex p;

    public Vertex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vertex getP() {
        return p;
    }

    public void setP(Vertex p) {
        this.p = p;
    }
}
