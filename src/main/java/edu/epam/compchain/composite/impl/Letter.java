package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

public class Letter implements Component {
    private char letter;

    public Letter(char letter) {
        this.letter = letter;
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
    public String toString() {
        return String.valueOf(letter);
    }
}
