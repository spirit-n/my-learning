package org.leetcode;

public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] =0;
        }
    }
}
