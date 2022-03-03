package com.practice.designpattern.behavioral.iterator;

public class Main {

    public static void main(String[] args) {
        var historyBad = new com.practice.designpattern.behavioral.iterator.bad.BrowseHistory();
        historyBad.push("a");
        historyBad.push("b");
        historyBad.push("c");
        for (var i = 0; i < historyBad.getUrls().size(); i++) {
            var url = historyBad.getUrls().get(i);
            System.out.println(url);
        }

        System.out.println("Iterator Pattern in a Good Way");
        var history = new com.practice.designpattern.behavioral.iterator.BrowseHistory();
        history.push("a");
        history.push("b");
        history.push("c");
        Iterator iterator = history.createIterator();
        while(iterator.hasNext()) {
            var url = iterator.current();
            System.out.println(url);
            iterator.next();
        }
    }
}
