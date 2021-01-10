package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private List<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public Component get(int index) {
        return components.get(index);
    }

    public List<Component> getComponents() {
        return new ArrayList<>(components);
    }

    public void addAll(Composite composite) {
        components.addAll(composite.getComponents());
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Component component : components) {
            text.append(component);
        }
        return text.toString();
    }

    public int numberOfLetters() {
        int count = 0;
        for (Component component : components) {
            if (component instanceof Composite) {
               count += ((Composite) component).numberOfLetters();
            } else if (component instanceof  Letter) {
                count++;
            }
        }
        return count;
    }

    public int numberOfPunctuationMarks() {
        int count = 0;
        for (Component component : components) {
            if (component instanceof Composite) {
                count += ((Composite) component).numberOfLetters();
            } else if (component instanceof  PunctuationMark) {
                count++;
            }
        }
        return count;
    }
}
