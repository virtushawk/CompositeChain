package edu.epam.compchain.parser.impl;

import edu.epam.compchain.composite.Component;
import edu.epam.compchain.composite.impl.Composite;
import edu.epam.compchain.composite.impl.Letter;
import edu.epam.compchain.composite.impl.PunctuationMark;
import edu.epam.compchain.parser.Handler;

public class SymbolParser implements Handler {
    private static final String LETTER_REGEX = "^[a-zA-Z0-9]*$";
    private static final String DELIMITER = "";

    @Override
    public Component handleRequest(String word) {
        Composite composite = new Composite();
        String [] symbols = word.split(DELIMITER);
        for (String symbol : symbols) {
            if (symbol.matches(LETTER_REGEX)) {
                Letter letter = new Letter(symbol.charAt(0));
                composite.add(letter);
            }
            else {
                PunctuationMark mark = new PunctuationMark(symbol.charAt(0));
                composite.add(mark);
            }
        }
        return composite;
    }
}
