package com.practice.designpattern.behavioral.command.editor;

import lombok.Getter;
import lombok.Setter;

public class HTMLDocument {

    @Getter
    @Setter
    private String content;

    public void makeBold() {
        this.content = "<b>" + content + "</b>";
    }
}
