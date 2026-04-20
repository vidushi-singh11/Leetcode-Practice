```java
/**
 * LeetCode Question: 11. Container With Most Water
 *
 * Problem Description:
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the i-th line are (i, 0) and (i, height[i]).
 * Find two such lines that, together with the x-axis, form a container, such that the container
 * contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water the container can contain is 49.
 *
 * Optimized Approach: Two Pointers
 *
 * Intuition:
 * We want to maximize the area, which is `min(height[left], height[right]) * (right - left)`.
 * We start with the widest possible container (pointers at the ends).
 * At each step, we calculate the area. To potentially find a larger area, we need to try and increase
 * the `min(height[left], height[right])` value.
 * If we move the pointer associated with the taller line, we are guaranteed to decrease the width,
 * and the shorter line will still be the limiting factor (or a new shorter line might appear).
 * However, if we move the pointer associated with the *shorter* line, there's a chance we might
 * find a taller line that increases `min(height[left], height[right])`, potentially compensating
 * for the decreased width or even leading to a larger area.
 * Therefore, always move the pointer pointing to the shorter of the two lines inward.
 *
 * Time Complexity: O(N) - Each pointer traverses the array at most once.
 * Space Complexity: O(1) - Only a few variables are used.
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the width of the current container
            int width = right - left;

            // The height of the container is limited by the shorter of the two lines
            int currentHeight = Math.min(height[left], height[right]);

            // Calculate the area for the current container
            int currentArea = currentHeight * width;

            // Update the maximum area found so far
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that points to the shorter line inward.
            // This is because moving the taller line will only reduce the width
            // and keep the same shorter height (or a new shorter height),
            // making it less likely to find a larger area.
            // Moving the shorter line gives a chance to find a taller line
            // that could potentially increase the overall height of the container.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
```