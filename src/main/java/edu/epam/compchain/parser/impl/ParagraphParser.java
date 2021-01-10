package edu.epam.compchain.parser.impl;

import edu.epam.compchain.composite.Component;
import edu.epam.compchain.composite.impl.Composite;
import edu.epam.compchain.composite.impl.PunctuationMark;
import edu.epam.compchain.parser.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParagraphParser implements Handler {
    private static final Logger logger = LogManager.getLogger(ParagraphParser.class);
    private static final String DELIMITER = "\\r?\\n";
    private SentenceParser parser;

    public ParagraphParser(SentenceParser parser) {
        this.parser = parser;
    }

    @Override
    public Component handleRequest(String text) {
        List<String> paragraphs = Stream.of(text.split(DELIMITER)).collect(Collectors.toList());
        logger.info(paragraphs);
        Composite composite = new Composite();
        if (parser == null) {
            return composite;
        } else {
            for (String paragraph : paragraphs) {
                Composite temp =(Composite) parser.handleRequest(paragraph);
                composite.add(temp);
                composite.add(new PunctuationMark('\n'));
            }
        }
        return composite;
    }
}
