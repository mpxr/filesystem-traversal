package com.mpxr.model;

import com.mpxr.TreeInitializer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class TreeTest {

    private static Tree tree;

    @BeforeAll
    public static void setUpTree() {
        tree = TreeInitializer.initTree();
    }

    @Test
    public void noParentForBaseDirectory() {
        Tree.Node node = tree.getNode();
        assertNull(node.getParent());
    }

    @Test
    public void twoFilesAndOneDirectoryInBaseDirectory() {
        Tree.Node node = tree.getNode();

        int filesInDirectory = 0;
        int directoryInDirectory = 0;

        for (Tree.Node baseDirectoryStructure : node.getChildren()) {
            if (baseDirectoryStructure.getData().isDirectory()) {
                directoryInDirectory++;
            } else {
                filesInDirectory++;
            }
        }

        assertEquals(2, filesInDirectory);
        assertEquals(1, directoryInDirectory);
    }

    @Test
    public void twoFilesInSubdirectory() {
        Tree.Node node = tree.getNode();
        Tree.Node subDirectoryNode = null;
        for (Tree.Node baseDirectoryStructure : node.getChildren()) {
            if (baseDirectoryStructure.getData().isDirectory()) {
                subDirectoryNode = baseDirectoryStructure;
            }
        }

        assertNotNull(subDirectoryNode);

        int filesInSubDirectory = 0;
        int directoryInSubdirectory = 0;

        for (Tree.Node subDirectoryStructure : subDirectoryNode.getChildren()) {
            if (!subDirectoryStructure.getData().isDirectory()) {
                filesInSubDirectory++;
            } else {
                directoryInSubdirectory++;
            }
        }

        assertEquals(2, filesInSubDirectory);
        assertEquals(0, directoryInSubdirectory);
    }

}