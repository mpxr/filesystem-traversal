package com.mpxr.model;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private String name;

    private List<Directory> directory;

    private List<String> files;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Directory> getDirectory() {
        return directory;
    }

    public void setDirectory(List<Directory> directory) {
        this.directory = directory;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public void addFile(String file){
        if(files == null){
            files = new ArrayList<>();
        }
        files.add(file);
    }

}
