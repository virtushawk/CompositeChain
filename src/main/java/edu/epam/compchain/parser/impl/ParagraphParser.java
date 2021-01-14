package edu.epam.compchain.parser.impl;

import edu.epam.compchain.composite.Component;
import edu.epam.compchain.composite.impl.Composite;
import edu.epam.compchain.composite.impl.Paragraph;
import edu.epam.compchain.parser.Handler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParagraphParser implements Handler {
    private static final String DELIMITER = "(?m)^\\s*$";
    private SentenceParser parser;

    public ParagraphParser(SentenceParser parser) {
        this.parser = parser;
    }

    @Override
    public Component handleRequest(String text) {
        List<String> paragraphs = Stream.of(text.split(DELIMITER)).collect(Collectors.toList());
        Composite composite = new Composite();
        if (parser == null) {
            return composite;
        } else {
            for (String paragraph : paragraphs) {
                Paragraph temp =(Paragraph) parser.handleRequest(paragraph);
                composite.add(temp);
            }
        }
        return composite;
    }
}
