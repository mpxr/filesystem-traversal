package com.mpxr.model;

public class Directory implements FileStructure {

    private String name ;

    public Directory(String name) {
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
