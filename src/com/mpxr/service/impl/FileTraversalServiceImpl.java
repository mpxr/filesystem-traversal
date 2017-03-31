package com.mpxr.service.impl;

import com.mpxr.model.Tree;
import com.mpxr.service.FileTraversalService;

import java.util.LinkedList;
import java.util.Queue;

public class FileTraversalServiceImpl implements FileTraversalService {


    @Override
    public void traversal(Tree tree) {
        Tree.Node rootNode = tree.getNode();
        System.out.println(rootNode.getPath());

        Queue<Tree.Node> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            Tree.Node currentNode = queue.remove();
            for (Tree.Node nodeChildren : currentNode.getChildren()) {
                queue.add(nodeChildren);
                if(nodeChildren.getData().isDirectory()){
                    System.out.println(nodeChildren.getPath());
                } else {
                    System.out.println(nodeChildren.getPath());
                }
            }

        }

    }

}
