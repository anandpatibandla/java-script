package com.others;

/**
 * You enter a string into this program, and it will return how many words were
 * in that particular string
 *
 * @author Marcus
 */
public class CountWords {
    public static int wordCount(String s) {
        if (s == null || s.isEmpty())
            return 0;
        return s.trim().split("[\\s]+").length;
    }

    /**
     * counts the number of words in a sentence but ignores all potential
     * non-alphanumeric characters that do not represent a word. runs in O(n) where
     * n is the length of s
     *
     * @param s String: sentence with word(s)
     * @return int: number of words
     */
    public static int secondaryWordCount(String s) {
        if (s == null || s.isEmpty())
            return 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c))
                sb.append(c);
            if (Character.isSpaceChar(c))
                sb.append(c);
        }
        s = sb.toString();
        return s.trim().split("[\\s]+").length;
    }
}