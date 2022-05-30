package com.practice.problems.adityaverma.tree.parent;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    public T data;

    public List<Node<T>> children;

    public Node(T data) {
        this(data, new ArrayList<>());
    }

    public Node(T data, List<Node<T>> children) {
        this.data = data;
        this.children = children;
    }

    public T data() {
        return data;
    }

    public List<Node<T>> children() {
        return children;
    }

    public void data(T val) {
        this.data = val;
    }

    public void children(List<Node<T>> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
