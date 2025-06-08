package org.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abcabcbb");
        System.out.println("i = " + i);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        Set<Character> occ = new HashSet<Character>();
        int r = -1;

        int result = 1;

        for (int i = 0; i < s.length(); i++) {
            if(i!=0){
                occ.remove(s.charAt(i - 1));
            }
            while (r + 1 < s.length() && !occ.contains(s.charAt(r + 1))) {
                r++;
                occ.add(s.charAt(r));
            }

            result = Math.max(result, r - i + 1);
        }
        return result;
    }
}
