```java
// LeetCode #11: Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0; // Stores the maximum area found so far
        int left = 0; // Left pointer, starting at the beginning of the array
        int right = height.length - 1; // Right pointer, starting at the end of the array

        // Continue as long as the left pointer is to the left of the right pointer
        while (left < right) {
            // Calculate the width between the two lines
            int width = right - left;

            // The height of the container is limited by the shorter of the two lines
            int currentHeight = Math.min(height[left], height[right]);

            // Calculate the area of the current container
            int currentArea = width * currentHeight;

            // Update maxArea if the current container holds more water
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line inward.
            // The logic here is that moving the taller line will definitely reduce the width
            // and the height will still be limited by the shorter line, so the area will
            // definitely not increase. However, moving the shorter line might find a taller
            // line, potentially increasing the overall height of the container and thus the area.
            if (height[left] < height[right]) {
                left++; // Move the left pointer to the right if it points to the shorter line
            } else {
                right--; // Move the right pointer to the left if it points to the shorter line (or they are equal)
            }
        }

        return maxArea; // Return the maximum area found
    }
}
```