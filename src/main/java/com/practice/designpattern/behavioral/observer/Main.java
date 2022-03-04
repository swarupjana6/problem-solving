package com.practice.designpattern.behavioral.observer;

public class Main {
    public static void main(String[] args) {
        pullStyle();
        pushStyle();
    }

    private static void pushStyle() {
        var dataSource = new com.practice.designpattern.behavioral.observer.pullstyle.Datasource();

        var sheet1 = new com.practice.designpattern.behavioral.observer.pullstyle.observers.SpreadSheet(dataSource);
        var sheet2 = new com.practice.designpattern.behavioral.observer.pullstyle.observers.SpreadSheet(dataSource);
        var chart = new com.practice.designpattern.behavioral.observer.pullstyle.observers.Chart(dataSource);

        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);

        dataSource.setValue(1);
    }

    private static void pullStyle() {
        var dataSource = new com.practice.designpattern.behavioral.observer.pushstyle.Datasource();

        var sheet1 = new com.practice.designpattern.behavioral.observer.pushstyle.observers.SpreadSheet();
        var sheet2 = new com.practice.designpattern.behavioral.observer.pushstyle.observers.SpreadSheet();
        var chart = new com.practice.designpattern.behavioral.observer.pushstyle.observers.Chart();

        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);

        dataSource.setValue(1);
    }
}
