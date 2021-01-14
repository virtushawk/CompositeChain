package edu.epam.compchain.parser.impl;

import edu.epam.compchain.composite.Component;
import edu.epam.compchain.composite.impl.Lexeme;
import edu.epam.compchain.composite.impl.Word;
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
        Lexeme composite = new Lexeme();
        if (parser == null) {
            return composite;
        } else {
            for (String word : words) {
                Word temp = (Word) parser.handleRequest(word);
                composite.add(temp);
            }
        }
        return composite;
    }
}
