package edu.epam.compchain.parser.impl;

import edu.epam.compchain.composite.Component;
import edu.epam.compchain.composite.impl.Lexeme;
import edu.epam.compchain.composite.impl.Sentence;
import edu.epam.compchain.parser.Handler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LexemeParser implements Handler {
    private static final String DELIMITER = "\\s+";
    private WordParser parser;

    public LexemeParser(WordParser parser){
        this.parser = parser;
    }
    @Override
    public Component handleRequest(String sentence) {
        List<String> lexemes = Stream.of(sentence.split(DELIMITER)).collect(Collectors.toList());
        Sentence composite = new Sentence();
        if (parser == null) {
            return composite;
        } else {
            for (String lexeme : lexemes) {
                Lexeme temp = (Lexeme) parser.handleRequest(lexeme);
                composite.add(temp);
            }
        }
        return composite;
    }
}
