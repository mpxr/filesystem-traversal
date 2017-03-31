package com.mpxr.service.impl;

import com.mpxr.TreeInitializer;
import com.mpxr.model.Tree;
import com.mpxr.service.FileTraversalService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileTraversalServiceImplTest {


    private static FileTraversalService fileTraversalService;

    private static Tree tree;

    @BeforeAll
    public static void setUpTree() {
        tree = TreeInitializer.initTree();
    }

    @BeforeAll
    public static void setUp(){
        fileTraversalService = new FileTraversalServiceImpl();
    }

    @Test
    public void getPath(){
        fileTraversalService.traversal(tree);
    }

}