package com.phenompeople.priyambada.jsonparser;

import com.phenompeople.priyambada.jsonparser.node.Node;
import com.phenompeople.priyambada.jsonparser.generator.JSONGenerator;
import com.phenompeople.priyambada.jsonparser.utils.Parser;

public class Main {
    public static void main(String[] args) {
        int height = Double.valueOf(Math.random() * 10)
                .intValue();
        int children = Double.valueOf(Math.random() * 10)
                .intValue();

        String jsonString = JSONGenerator.generateRandomJson(height, children);
        System.out.println(jsonString);
        Node root = Parser.parseJson(jsonString);

        System.out.println(root.toString().equals(jsonString));
    }
}
