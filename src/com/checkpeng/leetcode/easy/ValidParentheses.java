package com.checkpeng.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else if(c==')'||c=='}'||c==']'){
                if(!stack.isEmpty()){
                    if(stack.pop()!=map.get(c)){
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
