package com.mpxr.model;

public class File implements FileStructure {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
