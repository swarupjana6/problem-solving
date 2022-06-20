package com.practice.designpattengeekfic.behavarioual;

import lombok.Getter;
import lombok.Setter;

import java.util.Deque;
import java.util.LinkedList;

public class Memento {

    public static void main(String[] args) {
        new Memento().call();
    }

    private void call() {
        Editor editor = new Editor();
        editor.write("ABC");
        editor.write("PRQ");
        editor.printText();
        editor.undo();
        editor.printText();
    }
}

class TextArea {
    @Setter
    @Getter
    private String text;

    public TextAreaMemento takeSnapshot() {
        return new TextAreaMemento(this.text);
    }

    public void restore(TextAreaMemento textAreaMemento) {
        this.text = textAreaMemento != null ? textAreaMemento.text() : null;
    }

    public record TextAreaMemento(String text) {
    }
}

class Editor {
    private Deque<TextArea.TextAreaMemento> stateHistory;
    private TextArea textArea;

    public Editor() {
        textArea = new TextArea();
        stateHistory = new LinkedList<>();
    }

    public void write(String text) {
        textArea.setText(text);
        stateHistory.add(textArea.takeSnapshot());
    }

    public void undo() {
        if (stateHistory.isEmpty()) {
            return;
        }
        stateHistory.removeLast();
        textArea.restore(stateHistory.peekLast());
    }

    public void printText() {
        System.out.println(textArea.getText());
    }
}
