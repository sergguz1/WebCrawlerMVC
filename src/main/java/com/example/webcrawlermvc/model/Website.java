package com.example.webcrawlermvc.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Website {
    private String parentSite;
    private Set<String> marked = new HashSet<>();
    private Queue<String> list_of_websites = new LinkedList<>();

    public String getParentSite() {
        return parentSite;
    }
    public void setParentSite(String parentSite) {
        this.parentSite = parentSite;
    }
    public Set<String> getMarked() {
        return marked;
    }
    public void setMarked(Set<String> marked) {
        this.marked = marked;
    }
    public Queue<String> getList_of_websites() {
        return list_of_websites;
    }
    public void setList_of_websites(Queue<String> list_of_websites) {
        this.list_of_websites = list_of_websites;
    }
}
