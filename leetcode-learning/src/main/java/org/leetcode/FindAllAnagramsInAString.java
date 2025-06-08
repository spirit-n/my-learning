package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abab", "ab");
        System.out.println("anagrams = " + anagrams);
    }
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int length = p.length();

        for (int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + length);
            byte[] bytes = sub.getBytes();
            Arrays.sort(bytes);
            byte[] pBytes = p.getBytes();
            Arrays.sort(pBytes);
            if (new String(bytes).equals(new String(pBytes))) {
                result.add(i);
            }
        }
        return result;
    }
}
