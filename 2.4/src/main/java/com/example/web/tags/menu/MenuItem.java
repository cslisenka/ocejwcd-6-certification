package com.example.web.tags.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {

    private String name;
    private String url;
    private List<MenuItem> children = new ArrayList<>();

    public MenuItem(String name, String url, List<MenuItem> children) {
        this.name = name;
        this.url = url;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItem> children) {
        this.children = children;
    }
}
