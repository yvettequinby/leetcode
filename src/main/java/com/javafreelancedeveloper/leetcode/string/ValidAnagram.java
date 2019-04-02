package com.javafreelancedeveloper.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ValidAnagram {

    @Test
    public void testIt1() {
        ValidAnagram sandbox = new ValidAnagram();
        String s = "anagram";
        String t = "naagram";
        boolean result = sandbox.isAnagram(s, t);
        assertEquals(true, result);
    }

    @Test
    public void testIt2() {
        ValidAnagram sandbox = new ValidAnagram();
        String s = "car";
        String t = "rat";
        boolean result = sandbox.isAnagram(s, t);
        assertEquals(false, result);
    }


    public boolean isAnagram(String s, String t) {
        if(s.length()==t.length()) {
            char[] sChars = s.toCharArray();
            List<Character> tCharacterList = new ArrayList<>();
            char[] tChars = t.toCharArray();
            for (char c : tChars) {
                tCharacterList.add(c);
            }
            for(char sChar : sChars) {
                if(!tCharacterList.remove(Character.valueOf(sChar))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
