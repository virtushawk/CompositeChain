package edu.epam.compchain.parser.impl;

import edu.epam.compchain.composite.Component;
import edu.epam.compchain.composite.impl.Composite;
import edu.epam.compchain.composite.impl.PunctuationMark;
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
        Composite composite = new Composite();
        if (parser == null) {
            return composite;
        } else {
            for (String lexeme : lexemes) {
                Composite temp = (Composite) parser.handleRequest(lexeme);
                composite.add(temp);
                composite.add(new PunctuationMark(' '));
            }
        }
        return composite;
    }
}
