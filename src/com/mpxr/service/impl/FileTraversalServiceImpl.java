package com.mpxr.service.impl;

import com.mpxr.model.Directory;
import com.mpxr.model.Tree;
import com.mpxr.service.FileTraversalService;

import java.util.ArrayList;
import java.util.List;

public class FileTraversalServiceImpl implements FileTraversalService {


    @Override
    public void traversal(Tree tree) {
        Tree.Node rootNode = tree.getNode();

        Directory directory = visitNode(rootNode);
    }

    private Directory visitNode(Tree.Node node) {
        Directory directory = new Directory();
        directory.setName(node.getPath());

        List<Directory> subDirectories = new ArrayList<>();
        List<String> files = new ArrayList<>();

        for (Tree.Node subNode : node.getChildren()) {
            if(subNode.getData().isDirectory()){
                subDirectories.add(visitNode(subNode));
            } else {
                files.add(subNode.getData().getName());
            }
        }

        directory.setDirectory(subDirectories);
        directory.setFiles(files);
        return directory;
    }

}
