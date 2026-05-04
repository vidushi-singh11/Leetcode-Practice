```java
/**
 * LeetCode Question: Container With Most Water (Problem 11)
 *
 * Description:
 * You are given an integer array 'height' of length 'n'. There are 'n' vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area
 * of water the container can contain is 49.
 *
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // The height of the container is limited by the shorter of the two lines.
            // The width of the container is the distance between the two lines.
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;

            // Calculate the area of the current container.
            maxArea = Math.max(maxArea, currentHeight * currentWidth);

            // Move the pointer pointing to the shorter line inwards.
            // Why? To potentially find a taller line that can increase the container's height.
            // If we move the taller line, the width will definitely decrease, and we are
            // discarding a potentially larger width with the current limiting height.
            // By moving the shorter line, we might find a taller line that can form
            // a larger area with the other (taller) line, or at least maintain the height
            // with a slightly smaller width, which is a better gamble.
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