package com.example.webcrawlermvc.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class  WebsiteGlobal {
    public static Queue<String> get_list_websites(String websites){
        Queue<String> list_of_websites_returned = new LinkedList<>();
        List<String> arrayString = Arrays.asList(websites.split(","));
        list_of_websites_returned.addAll(arrayString);
        return list_of_websites_returned;
    }
}
