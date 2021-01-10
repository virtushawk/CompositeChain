package edu.epam.compchain.reader;

import edu.epam.compchain.exception.TextReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {
    private static final Logger logger = LogManager.getLogger(TextReader.class);

    public List<String> readListFromFile(String path) throws TextReaderException {
        List<String> list;
        try(Stream<String> stream = Files.lines(Paths.get(path))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("an error occurred while reading the file : {} ",e.getMessage());
            throw new TextReaderException("an error occurred while reading the file : " + e);
        }
        return list;
    }

    public String readStringFromFile(String path) throws TextReaderException {
        String text = null;
        try {
            text = Files.readString(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.error("an error occurred while reading the file : {} ",e.getMessage());
            throw new TextReaderException("an error occurred while reading the file : " + e);
        }
        return text;
    }
}
