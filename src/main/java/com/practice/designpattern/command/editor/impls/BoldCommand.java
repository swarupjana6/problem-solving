package com.practice.designpattern.command.editor.impls;

import com.practice.designpattern.command.editor.HTMLDocument;
import com.practice.designpattern.command.editor.History;
import com.practice.designpattern.command.editor.framework.UndoableCommand;
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
