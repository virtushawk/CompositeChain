package edu.epam.compchain.parser;

import edu.epam.compchain.composite.impl.*;
import edu.epam.compchain.exception.TextReaderException;
import edu.epam.compchain.parser.impl.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextParserTest {
    public ParagraphParser parser;

    @BeforeClass
    public void beforeClass() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        parser = new ParagraphParser(sentenceParser);
    }

    @Test
    public void parserTest() {
        String expected = "abc. I like animals. Wow!";
        Composite composite = (Composite) parser.handleRequest(expected);
        String actual = composite.toString().trim();
        Assert.assertEquals(actual,expected);
    }

    @AfterClass
    public void afterClass() {
        parser = null;
    }
}
