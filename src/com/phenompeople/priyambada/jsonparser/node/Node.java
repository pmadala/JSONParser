package com.phenompeople.priyambada.jsonparser.node;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String key;
    private List<Node> values;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Node> getValues() {
        return new ArrayList<>(values);
    }

    public void setValues(List<Node> values) {
        this.values = new ArrayList<>(values);
    }

    @Override
    public String toString() {
        return String.format("{\"%s\": %s}", key, values);
    }

    public static Node of(String key, List<Node> values) {
        Node node = new Node();
        node.setKey(key);
        node.setValues(values);
        return node;
    }

}
