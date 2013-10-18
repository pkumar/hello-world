package com.pktr;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PerfectRotations {

    public static boolean areRotations(String s, String t) {
    	if(s.length() != t.length()) {
    		return false;
    	}
        Map<Character, Character> originNextCMap = getNextCharMap(s);
        Map<Character, Character> destNextCMap = getNextCharMap(t);
        int count = 0;
        for (Entry<Character, Character> entry : originNextCMap.entrySet()) {
            Character key = entry.getKey();
            if (entry.getValue().equals(destNextCMap.get(key))) {
                count++;
            }
        }
        return (count == originNextCMap.size() && count == destNextCMap.size());

    }

    private static Map<Character, Character> getNextCharMap(String s) {
        Map<Character, Character> nextCharMap = new HashMap<Character, Character>();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            int nextIndex = i + 1;
            if (nextIndex == sArray.length) {
                nextIndex = 0;
            }
            nextCharMap.put(sArray[i], sArray[nextIndex]);
        }
        return nextCharMap;
    }

    public static void main(String[] args) {
        System.out.println(PerfectRotations.areRotations("tackoverflows", "stackoverflow"));
        System.out.println(PerfectRotations.areRotations("hello", "elloh"));
        System.out.println(PerfectRotations.areRotations("hello", "ohell"));
        System.out.println(PerfectRotations.areRotations("hello", "ellhoellho"));
    }

}
