package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Word implements Component {

    private List<Component> word = new ArrayList<>();

    @Override
    public void add(Component component) {
        word.add(component);
    }

    @Override
    public void remove(Component component) {
        word.remove(component);
    }

    @Override
    public Component get(int index) {
        Component component = word.get(index);
        return component;
    }
}
