package com.practice.designpattern.behavioral.iterator;

import com.practice.designpattern.behavioral.iterator.good.Iterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Iterator Pattern in a Bad Way");
        badBrowserHistory();

        System.out.println("Iterator Pattern in a Good Way");
        goodBrowserHistory();
    }

    private static void goodBrowserHistory() {
        var history = new com.practice.designpattern.behavioral.iterator.good.BrowseHistory();
        history.push("a");
        history.push("b");
        history.push("c");
        Iterator iterator = history.createIterator();
        while (iterator.hasNext()) {
            var url = iterator.current();
            System.out.println(url);
            iterator.next();
        }
    }

    private static void badBrowserHistory() {
        var historyBad = new com.practice.designpattern.behavioral.iterator.bad.BrowseHistory();
        historyBad.push("a");
        historyBad.push("b");
        historyBad.push("c");
        for (var i = 0; i < historyBad.getUrls().size(); i++) {
            var url = historyBad.getUrls().get(i);
            System.out.println(url);
        }
    }
}
