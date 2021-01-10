package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Component {

    private List<Component> sentence = new ArrayList<>();

    @Override
    public void add(Component component) {
        sentence.add(component);
    }

    @Override
    public void remove(Component component) {
        sentence.remove(component);
    }

    @Override
    public Component get(int index) {
        Component component = sentence.get(index);
        return component;
    }
}
