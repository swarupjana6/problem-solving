package com.practice.designpattern.command.editor.framework;

import com.practice.designpattern.command.editor.framework.Command;

public interface UndoableCommand extends Command {
    void unExecute();
}
