package com.practice.designpattern.behavioral.iterator.bad;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {

    @Getter
    private List<String> urls = new ArrayList<>();
    // If we choose to modify and want to store only last 10 URLs.
    // Then we choose to modify List<String> to array of String[10]
    // This will break the outside calls to the urls getter as well

    public void push(String url) {
        urls.add(url);
    }

    public String pop() {
        var lastIndex = urls.size() - 1;
        var lastUrl = urls.get(lastIndex);
        urls.remove(lastUrl);

        return lastUrl;
    }
}
