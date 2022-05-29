package com.example.webcrawlermvc.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGlobalTest {
    String list_of_websites = "https://www.python.org,https://code.google.com";
    static String regex = "http[s]*://(\\w+\\.)*(\\w+)";
    @BeforeEach
    public void setUp() {
        WebsiteGlobal websiteGlobal = new WebsiteGlobal();
    }

    @Test
    public void get_list_websites() {
        WebsiteGlobal websiteGlobal = new WebsiteGlobal();

        List<String> arrayString = Arrays.asList(list_of_websites.split(","));
        for (String website: arrayString) {
            assertTrue(website.matches(regex));
        }

        Queue<String> list_of_websites_returned = websiteGlobal.get_list_websites(list_of_websites);
        assertEquals(list_of_websites_returned.getClass(), websiteGlobal.get_list_websites(list_of_websites).getClass());
    }
}