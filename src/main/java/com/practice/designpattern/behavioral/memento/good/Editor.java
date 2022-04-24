package com.practice.designpattern.behavioral.memento.good;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Editor {

    private String content;

    public EditorState createState() {
        return new EditorState(content);
    }

    public void restore(EditorState state) {
        this.content = state.content();
    }
}
