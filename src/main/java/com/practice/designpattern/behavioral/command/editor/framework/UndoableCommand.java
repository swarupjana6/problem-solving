package com.practice.designpattern.behavioral.command.editor.framework;

public interface UndoableCommand extends Command {
    void unExecute();
}
