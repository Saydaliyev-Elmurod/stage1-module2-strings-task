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
        String text = "";
        for (char character : characters) {
            if (delimiters.contains(character + "")) {
                if (!text.isEmpty()) {
                    response.add(text);
                    text = "";
                }

            } else {
                text += character;
            }
        }
        if (!text.isEmpty()) {
            response.add(text);
        }
        return response;

    }
}
