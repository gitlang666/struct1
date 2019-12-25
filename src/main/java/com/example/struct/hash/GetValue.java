package com.example.struct.hash;

public interface GetValue<T> {
    public int getValue();
    public void append(T t);
    public void show();
    public T getNode(int k);
    public void delete(T t);
}
