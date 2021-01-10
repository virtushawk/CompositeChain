package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Component {

    private List<Component> paragraph = new ArrayList<>();

    @Override
    public void add(Component component) {
        paragraph.add(component);
    }

    @Override
    public void remove(Component component) {
        paragraph.remove(component);
    }

    @Override
    public Component get(int index) {
        Component component = paragraph.get(index);
        return component;
    }
}
