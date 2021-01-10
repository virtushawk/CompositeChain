package edu.epam.compchain.composite;

public interface Component {
    void add(Component component);
    void remove(Component component);
    Component get(int index);

}
