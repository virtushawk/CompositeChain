package edu.epam.compchain.composite;

import edu.epam.compchain.composite.impl.Composite;
import edu.epam.compchain.parser.impl.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ComponentTest {
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
    public void longestWordTest() {
        String text = "aaaa vvvvv?. bbb longestWord.net";
        String expected = "longestWord";
        Composite composite = (Composite) parser.handleRequest(text);
        String actual = composite.findLongestWord().toString();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void longestWordSentenceTest() {
        String text = "aaaa vvvvv?. bbb longestWord";
        String expected = "bbb longestWord";
        Composite composite = (Composite) parser.handleRequest(text);
        Component component = composite.findLongestWordSentence();
        String actual = component.toString().trim();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void removeSentenceTest() {
        String text = "aaaa vvvvv? bbb longestWord. 3 word sentence";
        String expected = "3 word sentence";
        int numberOfWords = 3;
        Composite composite = (Composite) parser.handleRequest(text);
        composite.removeSentence(numberOfWords);
        String actual = composite.toString().trim();
        Assert.assertEquals(actual,expected);
    }

    @AfterClass
    public void afterClass() {
        parser = null;
    }

}
