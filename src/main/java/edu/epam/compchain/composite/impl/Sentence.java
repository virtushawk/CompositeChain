package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.Comparator;
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
        return sentence.get(index);
    }

    @Override
    public int size() {
        return sentence.size();
    }

    @Override
    public Component longestWord() {
        Component longest = new Word();
        for (Component component : sentence) {
            if (longest.size() < component.size()) {
                longest = component;
            }
        }
        return longest;
    }

    @Override
    public Component longestWordSentence() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeSentence(int number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component sort(Comparator<? super Component> comparator) {
        List<Component> listResult = new ArrayList<>(sentence);
        listResult.sort(comparator);
        Composite composite = new Composite();
        composite.addAll(listResult);
        return composite;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Component component : sentence) {
            text.append(component);
            text.append(" ");
        }
        return text.toString();
    }
}
