package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> response = new ArrayList<>();
        char[] characters = source.toCharArray();
        StringBuilder text = new StringBuilder();
        for (char character : characters) {
            if (delimiters.contains(character + "")) {
                response.add(text.toString());
                text = new StringBuilder();
            } else {
                text.append(character);
            }
        }
        if (text.length() != 0) {
            response.add(text.toString());
        }
        return response;

    }
}
