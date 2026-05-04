```java
/**
 * LeetCode Question: Container With Most Water
 * Difficulty: Medium
 *
 * Problem Description:
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water the container can store.
 *
 * Notice that you may not slant the container.
 *
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water the container can contain is 49.
 *
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
class Solution {
    /**
     * Optimised Approach: Two-Pointer Technique
     *
     * The idea is to use two pointers, one at the beginning ('left') and one at the end ('right') of the height array.
     * The area formed by the lines at 'left' and 'right' is `min(height[left], height[right]) * (right - left)`.
     *
     * We want to maximize this area. The width `(right - left)` is maximized initially.
     * In each step, we calculate the current area. Then, we move the pointer of the shorter line inwards.
     *
     * Why move the shorter line?
     * If we move the taller line inwards, the height of the container will still be limited by the *shorter* of the two
     * lines (or potentially an even shorter new line), and the width will definitely decrease. This means moving the
     * taller line will never lead to a larger area.
     * However, if we move the shorter line inwards, the width decreases, but there's a possibility that the new line
     * at the moved pointer position is much taller. If this new line is taller than the previous shorter line,
     * it might be able to form a larger container area, even with the reduced width.
     *
     * This ensures that we explore all potentially maximum areas efficiently.
     *
     * Time Complexity: O(n) - Each pointer traverses the array at most once.
     * Space Complexity: O(1) - Only a few variables are used.
     */
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the current height (limited by the shorter line) and width.
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            
            // Update the maximum water found so far.
            maxWater = Math.max(maxWater, currentHeight * currentWidth);

            // Move the pointer of the shorter line inwards.
            if (height[left] < height[right]) {
                left++;
            } else { // height[right] <= height[left]
                right--;
            }
        }

        return maxWater;
    }
}
```