package org.leetcode;

public class ContainerWithMostWater {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;         // 左指针初始化为数组头部
        int right = height.length - 1;  // 右指针初始化为数组尾部

        while (left < right) {
            // 计算当前容器的容量
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);

            // 移动较短的指针（贪心策略）
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
