package com.practice.designpattern.behavioral.memento;

import com.practice.designpattern.behavioral.memento.good.Editor;
import com.practice.designpattern.behavioral.memento.good.History;

public class Main {

    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        editor.restore(history.pop());

        System.out.println(editor.getContent());
    }
}
