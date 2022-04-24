package com.practice.designpattern.behavioral.command.editor.impls;

import com.practice.designpattern.behavioral.command.editor.History;
import com.practice.designpattern.behavioral.command.editor.framework.UndoableCommand;
import com.practice.designpattern.behavioral.command.editor.HTMLDocument;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoldCommand implements UndoableCommand {

    private String prevContent;
    @NonNull
    private HTMLDocument document;
    @NonNull
    private History history;

    @Override
    public void execute() {
        prevContent = document.getContent();
        document.makeBold();
        history.push(this);
    }

    @Override
    public void unExecute() {
        document.setContent(prevContent);
    }
}
