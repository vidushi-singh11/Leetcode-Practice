```java
// LeetCode 11. Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the current area
            // The height of the container is limited by the shorter line
            // The width is the distance between the two lines
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;

            // Update the maximum area found so far
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer of the shorter line inward
            // The intuition here is that to potentially find a larger area,
            // we must try to increase the limiting height.
            // If we move the taller line, the limiting height (currentHeight)
            // would either stay the same (if the other line is still shorter)
            // or decrease (if the new line is shorter than the previous shorter line),
            // while the width definitely decreases.
            // By moving the shorter line, we have a chance to find a taller line
            // that could compensate for the reduced width, potentially leading to a larger area.
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