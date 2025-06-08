package org.leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int lMax = 0,rMax=0;
        int result = 0;

        while (l<r){
            if(height[l] < height[r]) {
                if(height[l] >= lMax) {
                    lMax = height[l];
                } else {
                    result += lMax - height[l];
                }

                l++;
            } else {
                if(height[r] >= rMax) {
                    rMax = height[r];
                } else {
                    result += rMax - height[r];
                }
                r--;
            }


        }
        return result;
    }
}
