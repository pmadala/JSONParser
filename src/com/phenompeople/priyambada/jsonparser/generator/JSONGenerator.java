package com.phenompeople.priyambada.jsonparser.generator;

import com.phenompeople.priyambada.jsonparser.node.Node;

import java.util.ArrayList;
import java.util.List;

public class JSONGenerator {
    public static String generateRandomJson(int height, int children) {
        Node root = new Node();
        root.setKey("root");
        return generateRandomJsonNode(root, height - 1, children).toString();
    }

    private static Node generateRandomJsonNode(Node node, int height, int children) {
        List<Node> values = new ArrayList<>();
        if (height > 0) {
            for (int i = 0; i < children; i++) {
                Node child = new Node();
                child.setKey("child-" + height + "-" + i);
                values.add(generateRandomJsonNode(child, height - 1, children));
            }
        }
        node.setValues(values);
        return node;
    }

}
