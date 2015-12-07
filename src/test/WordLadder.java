package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by programmer on 12/7/15.
 */
public class WordLadder {

    public static void main(String[] args) {

        String start = "aaa";
        String end = "abc";
        String words = "aaa\naba\nabc";
        List<String> wordDict = Arrays.asList(words.split("\n"));
        List<String> wordsFound = new ArrayList<>();
        if (start.equals(end)) System.out.println(start);
        wordsFound.add(start);
        if (convert(start, end, wordDict, wordsFound)) {
            System.out.println(wordsFound);
        } else {
            System.out.println("No");
        }

    }

    public static int theDistance(String w1, String w2) {
        int cnt = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static boolean convert(String s1, String s2, List<String> words, List<String> wordsFound) {
        //1. put words in a string Set
        //2. loop through the words
        //3. if the word from dict is one char differnt form s1, that would be a possible path

        if (theDistance(s1, s2) == 1) {
            //System.out.println(wordsFound);
            wordsFound.add(s2);
            return true;
        }

        for (String word : words) {// loop through words
            if (wordsFound.contains(word)) continue;
            if (theDistance(s1, word) == 1) {
                wordsFound.add(word);
                if (convert(word, s2, words, wordsFound)) {
                    return true;
                }
                wordsFound.remove(words.size() - 1);
            }
        }
        return false;
    }
}

