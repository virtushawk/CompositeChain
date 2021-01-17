package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.Comparator;
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
        return lexeme.get(index);
    }

    @Override
    public int size() {
        return lexeme.size();
    }

    @Override
    public Component findLongestWord() {
        Component longest = new Word();
        for (Component component : lexeme) {
            if (longest.size() < component.size()) {
                longest = component;
            }
        }
        return longest;
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
        List<Component> listResult = new ArrayList<>(lexeme);
        listResult.sort(comparator);
        Composite composite = new Composite();
        composite.addAll(listResult);
        return composite;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Component component : lexeme) {
            text.append(component);
        }
        return text.toString();
    }
}
