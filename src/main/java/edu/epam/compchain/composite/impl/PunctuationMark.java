package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

public class PunctuationMark implements Component {
    private char mark;

    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString(){
        return String.valueOf(mark);
    }
}
