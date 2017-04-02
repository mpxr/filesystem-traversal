package com.mpxr.model;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node root;

    public Tree(FileSystemStructure rootData) {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
        root.path = "/" + rootData.getName();
    }

    public void addNode(Node node) {
        root.children.add(node);
    }

    public Node getNode() {
        return root;
    }

    public static class Node {
        private FileSystemStructure data;
        private Node parent;
        private List<Node> children;
        private String path;

        private Node() {
        }

        public Node(FileSystemStructure data, Node parent) {
            this.data = data;
            this.parent = parent;
            children = new ArrayList<>();
            if (parent != null) {
                path = parent.path + "/" + data.getName();
            } else {
                path = "/" + data.getName();
            }
        }

        public FileSystemStructure getData() {
            return data;
        }

        public Node getParent() {
            return parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChildren(Node child) {
            children.add(child);
        }

        public String getPath() {
            return path;
        }

    }

}
