package edu.epam.compchain.parser;

import edu.epam.compchain.composite.Component;

public interface Handler {
    Component handleRequest(String text);
}
