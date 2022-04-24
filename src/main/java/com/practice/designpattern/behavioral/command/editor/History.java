package com.practice.designpattern.behavioral.command.editor;

import com.practice.designpattern.behavioral.command.editor.framework.UndoableCommand;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {

    public Deque<UndoableCommand> commands = new ArrayDeque<>();

    public void push(UndoableCommand command) {
        commands.add(command);
    }

    public UndoableCommand pop() {
        return commands.pop();
    }

    public boolean isEmpty() {
        return commands.size() == 0;
    }
}
