package com.phenompeople.priyambada.jsonparser.utils;

import com.phenompeople.priyambada.jsonparser.node.Node;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static Node parseJson(String jsonString) {
        int first = jsonString.indexOf('{'), last = jsonString.lastIndexOf('}') + 1;

        if (first == -1 || last == 0) {
            return null;
        }

        jsonString = jsonString.substring(first, last);

        int index = jsonString.indexOf(":");
        String keySubstring = jsonString.substring(0, index);
        int keyStart = keySubstring.indexOf('"'), keyEnd = keySubstring.lastIndexOf('"');
        String key = keySubstring.substring(keyStart + 1, keyEnd);

        List<Node> values = parseValues(jsonString);

        return Node.of(key, values);
    }

    private static List<Node> parseValues(String jsonString) {

        int first = jsonString.indexOf('['), last = jsonString.lastIndexOf(']') + 1;

        if (first == -1 || last == 0) {
            return new ArrayList<>();
        }

        jsonString = jsonString.substring(first, last - 1);

        List<String> nodeStrings = extractNodes(jsonString);

        List<Node> nodes = new ArrayList<>();

        for (String nodeString : nodeStrings) {
            nodes.add(parseJson(nodeString));
        }

        return nodes;
    }

    private static List<String> extractNodes(String jsonString) {
        List<String> list = new ArrayList<>();
        int level = 0, i = 0;
        StringBuffer buffer = new StringBuffer();

        while (i < jsonString.length()) {
            buffer.append(jsonString.charAt(i));
            if (jsonString.charAt(i) == '{') {
                level++;
            }
            if (jsonString.charAt(i) == '}') {
                level--;
            }

            if (level == 0 && jsonString.charAt(i) == '}') {
                list.add(buffer.toString());
                buffer.delete(0, buffer.length());
            }
            i++;
        }

        return list;
    }

}
