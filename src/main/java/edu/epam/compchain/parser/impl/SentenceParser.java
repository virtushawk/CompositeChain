package edu.epam.compchain.parser.impl;

import edu.epam.compchain.composite.Component;
import edu.epam.compchain.composite.impl.Composite;
import edu.epam.compchain.parser.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Handler {
    private static final String REGEX = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";
    private LexemeParser parser;

    public SentenceParser(LexemeParser parser) {
        this.parser = parser;
    }

    @Override
    public Component handleRequest(String paragraph) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(paragraph);
        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            sentences.add(matcher.group());
        }
        Composite composite = new Composite();
        if (parser == null) {
            return composite;
        }
        else {
            for (String sentence : sentences) {
                Composite temp =(Composite) parser.handleRequest(sentence);
                composite.add(temp);
            }
        }
        return composite;
    }
}
