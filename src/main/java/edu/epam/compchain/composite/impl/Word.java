package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.Comparator;
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
        return word.get(index);
    }

    @Override
    public int size() {
        return word.size();
    }

    @Override
    public Component findLongestWord() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component findLongestWordSentence() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeSentence(int number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component sort(Comparator<? super Component> comparator) {
        List<Component> listResult = new ArrayList<>(word);
        listResult.sort(comparator);
        Composite composite = new Composite();
        composite.addAll(listResult);
        return composite;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Component component : word) {
            text.append(component);
        }
        return text.toString();
    }
}
