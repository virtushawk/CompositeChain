package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Lexeme implements Component {
    private List<Component> lexeme = new ArrayList<>();

    @Override
    public void add(Component component) {
        lexeme.add(component);
    }

    @Override
    public void remove(Component component) {
        lexeme.remove(component);
    }

    @Override
    public Component get(int index) {
        Component component = lexeme.get(index);
        return component;
    }
}
