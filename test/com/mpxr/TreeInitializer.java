package com.mpxr;

import com.mpxr.model.Directory;
import com.mpxr.model.File;
import com.mpxr.model.FileStructure;
import com.mpxr.model.Tree;

public class TreeInitializer {

    public static Tree initTree() {
         Tree tree;

        //Base directory & node
        FileStructure baseDirectory = new Directory("DB");
        Tree.Node baseDirectoryNode = new Tree.Node(baseDirectory, null);

        //Files in base directory & nodes
        FileStructure file1 = new File("file1");
        FileStructure file2 = new File("file2");
        Tree.Node fileNode1 = new Tree.Node(file1, baseDirectoryNode);
        Tree.Node fileNode2 = new Tree.Node(file2, baseDirectoryNode);

        //Sub directory in base directory & node
        FileStructure subDirectory = new Directory("sub");
        Tree.Node subDirectoryNode = new Tree.Node(subDirectory, baseDirectoryNode);

        //Files in sub directories & node
        FileStructure subFile1 = new File("subFile1");
        FileStructure subFile2 = new File("subFile2");
        Tree.Node subFileNode1 = new Tree.Node(subFile1, subDirectoryNode);
        Tree.Node subFileNode2 = new Tree.Node(subFile2, subDirectoryNode);
        subDirectoryNode.addChildren(subFileNode1);
        subDirectoryNode.addChildren(subFileNode2);

        //create tree
        tree = new Tree(baseDirectory);
        tree.addNode(fileNode1);
        tree.addNode(fileNode2);
        tree.addNode(subDirectoryNode);

        return tree;
    }

}
