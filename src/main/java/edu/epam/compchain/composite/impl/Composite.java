package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.Comparator;
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

    @Override
    public int size() {
        return components.size();
    }

    @Override
    public Component longestWord() {
        Component longest = new Word();
        for (Component component : components) {
            Component temp = component.longestWord();
            if (longest.size() < temp.size()) {
                longest = temp;
            }
        }
        return longest;
    }

    @Override
    public Component longestWordSentence() {
        Sentence longest = new Sentence();
        for (Component component : components) {
            Sentence temp = (Sentence) component.longestWordSentence();
            if (longest.longestWord().size()< component.longestWord().size()) {
                longest = temp;
            }
        }
        return longest;
    }

    @Override
    public void removeSentence(int number) {
        for (Component component : components) {
            component.removeSentence(number);
        }
    }

    public void addAll(List<Component> components) {
        this.components.addAll(components);
    }

    @Override
    public Component sort(Comparator<? super Component> comparator) {
        List<Component> listResult = new ArrayList<>(components);
        listResult.sort(comparator);
        Composite composite = new Composite();
        composite.addAll(listResult);
        return composite;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Component component : components) {
            text.append(component);
        }
        return text.toString();
    }
}
