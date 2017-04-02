package com.mpxr.model;

public class Folder implements FileSystemStructure {

    private String name ;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
