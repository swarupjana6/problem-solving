package com.practice.designpattern.behavioral.memento.bad;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Editor {

    @Getter @Setter
    private String content;

    private List<String> states;
}
