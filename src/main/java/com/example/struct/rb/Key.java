package com.example.struct.rb;

public class Key implements Comparable<Key> {
    public int value;
    public Key(int value){
        this.value=value;
    }

    @Override
    public int compareTo(Key o) {
        return this.value-o.value;
    }

    @Override
    public String toString() {
        return "Key{" +
                "value=" + value +
                '}';
    }
}
