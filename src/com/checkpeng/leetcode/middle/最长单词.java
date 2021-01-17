package com.checkpeng.leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 最长单词 {

    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length()-o1.length();
                }
            }
        });
        Set<String> set = new HashSet<String>(Arrays.asList(words));
        for (String word : words) {
            set.remove(word);
            if (find(set, word)) {
                return word;
            }
        }
        return "";
    }

    public boolean find(Set<String> set, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.substring(0, i + 1))&&find(set,word.substring(i+1))){
                return true;
            }
        }
        return false;
    }
}
