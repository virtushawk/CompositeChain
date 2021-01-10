package edu.epam.compchain.parser.impl;

import edu.epam.compchain.composite.Component;
import edu.epam.compchain.composite.impl.Composite;
import edu.epam.compchain.parser.Handler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordParser implements Handler {
    private static final String DELIMITER ="((?<=.)|(?=.))";
    private SymbolParser parser;

    public WordParser(SymbolParser parser) {
        this.parser = parser;
    }

    @Override
    public Component handleRequest(String lexeme) {
        List<String> words = Stream.of(lexeme.split(DELIMITER)).collect(Collectors.toList());
        Composite composite = new Composite();
        if (parser == null) {
            return composite;
        } else {
            for (String word : words) {
                Composite temp = (Composite) parser.handleRequest(word);
                composite.add(temp);
            }
        }
        return composite;
    }
}
