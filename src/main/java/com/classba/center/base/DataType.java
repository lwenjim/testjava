package com.classba.center.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataType {
    @Test
    public void length() {
        List<Node> list = new ArrayList<>();
        Node n = new Node();
        n.value = 2;
        list.add(n);
    }
}


class Node {
    public int value;
    public Node pre;
    public Node next;
}