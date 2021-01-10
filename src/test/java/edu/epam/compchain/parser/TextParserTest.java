package edu.epam.compchain.parser;

import edu.epam.compchain.composite.impl.Composite;
import edu.epam.compchain.exception.TextReaderException;
import edu.epam.compchain.parser.impl.*;
import edu.epam.compchain.reader.TextReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextParserTest {
    public String text;
    public static final String PATH = "file/text.txt";

    @BeforeClass
    public void beforeClass() throws TextReaderException {
        TextReader textReader = new TextReader();
        text = textReader.readStringFromFile(PATH);
    }

    @Test
    public void parserTest() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        Composite composite = (Composite) parser.handleRequest(text);
        System.out.println(composite.toString());
        System.out.println("letters : " + composite.numberOfLetters());
        System.out.println("Punctuation Marks : " + composite.numberOfPunctuationMarks());
    }
}
