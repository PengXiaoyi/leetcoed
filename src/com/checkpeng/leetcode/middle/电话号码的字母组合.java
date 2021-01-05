package com.checkpeng.leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        Map<Character, Character[]> dir = new HashMap<>();
        dir.put('2', new Character[]{'a', 'b', 'c'});
        dir.put('3', new Character[]{'d', 'e', 'f'});
        dir.put('4', new Character[]{'g', 'h', 'i'});
        dir.put('5', new Character[]{'j', 'k', 'l'});
        dir.put('6', new Character[]{'m', 'n', 'o'});
        dir.put('7', new Character[]{'p', 'q', 'r', 's'});
        dir.put('8', new Character[]{'t', 'u', 'v'});
        dir.put('9', new Character[]{'w', 'x', 'y', 'z'});
        String a = "";
        List<String> result = new ArrayList<>();
        result.add(a);
        for (int i = 0; i < digits.length(); i++) {
            result = getnumber(result, digits.charAt(i), dir);
        }
        return result;
    }

    public List<String> getnumber(List<String> result, char index, Map<Character, Character[]> map) {
        Character[] temp = map.get(index);
        List<String> loop = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            for (Character character : temp) {
                StringBuilder a = new StringBuilder(result.get(i));
                a.append(character);
                loop.add(a.toString());
            }
        }
        return loop;
    }
}
