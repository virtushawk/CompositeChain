package edu.epam.compchain.composite;

import java.util.Comparator;

public interface Component {
    void add(Component component);
    void remove(Component component);
    Component get(int index);
    int size();
    Component findLongestWord();
    Component findLongestWordSentence();
    void removeSentence(int number);
    Component sort(Comparator<? super Component> comparator);
}
