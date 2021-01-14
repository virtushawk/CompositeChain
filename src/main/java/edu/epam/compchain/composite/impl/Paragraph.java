package edu.epam.compchain.composite.impl;

import edu.epam.compchain.composite.Component;

import java.util.ArrayList;
import java.util.Comparator;
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
      return paragraph.get(index);
    }

    @Override
    public int size() {
        return paragraph.size();
    }

    @Override
    public Component longestWord() {
        Component longest = new Word();
        for (Component component : paragraph) {
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
        for (Component component : paragraph) {
            if (longest.longestWord().size()< component.longestWord().size()) {
                longest = (Sentence) component;
            }
        }
        return longest;
    }

    @Override
    public void removeSentence(int number) {
        paragraph.removeIf(component -> component.size() < number);
    }

    @Override
    public Component sort(Comparator<? super Component> comparator) {
        List<Component> listResult = new ArrayList<>(paragraph);
        listResult.sort(comparator);
        Composite composite = new Composite();
        composite.addAll(listResult);
        return composite;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Component component : paragraph) {
            text.append(component);
        }
        return text.toString();
    }
}
