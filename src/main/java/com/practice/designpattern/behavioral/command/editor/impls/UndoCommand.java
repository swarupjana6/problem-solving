package com.practice.designpattern.behavioral.command.editor.impls;

import com.practice.designpattern.behavioral.command.editor.History;
import com.practice.designpattern.behavioral.command.editor.framework.Command;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UndoCommand implements Command {

    @NonNull
    private History history;

    @Override
    public void execute() {
        if (!history.isEmpty()) history.pop().unExecute();
    }
}
