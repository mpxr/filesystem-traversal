package com.mpxr;

import com.mpxr.model.Folder;
import com.mpxr.model.File;
import com.mpxr.model.FileSystemStructure;
import com.mpxr.model.Tree;

public class TreeInitializer {

    public static Tree initTree() {
         Tree tree;

        //Base directory & node
        FileSystemStructure baseDirectory = new Folder("DB");
        Tree.Node baseDirectoryNode = new Tree.Node(baseDirectory, null);

        //Files in base directory & nodes
        FileSystemStructure file1 = new File("file1");
        FileSystemStructure file2 = new File("file2");
        Tree.Node fileNode1 = new Tree.Node(file1, baseDirectoryNode);
        Tree.Node fileNode2 = new Tree.Node(file2, baseDirectoryNode);

        //Sub directory in base directory & node
        FileSystemStructure subDirectory = new Folder("sub");
        Tree.Node subDirectoryNode = new Tree.Node(subDirectory, baseDirectoryNode);

        //Sub sub directory in base directory & node
        FileSystemStructure subSubDirectory = new Folder("sub");
        Tree.Node subSubDirectoryNode = new Tree.Node(subDirectory, subDirectoryNode);

        FileSystemStructure subSubFile1 = new File("subSubFile1");
        Tree.Node subSubFileNode1 = new Tree.Node(subSubFile1, subSubDirectoryNode);

        subSubDirectoryNode.addChildren(subSubFileNode1);

        subDirectoryNode.addChildren(subSubDirectoryNode);

        //Files in sub directories & node
        FileSystemStructure subFile1 = new File("subFile1");
        FileSystemStructure subFile2 = new File("subFile2");
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
