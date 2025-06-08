package org.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6

});
        System.out.println(i);
    }
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }

        integers = integers.stream().sorted()
                .collect(Collectors.toSet());

        int maxLength = 0;
        for (Integer integer : integers) {
            if (!integers.contains(integer - 1)) {
                int i = 0;
                while (integers.contains(integer + i)) {
                    i++;
                }

                maxLength = Math.max(maxLength, i);
            }
        }
        return maxLength;
    }
}
