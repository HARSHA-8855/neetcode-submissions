class Solution {
    public int maxArea(int[] height) {

        // Start the left pointer at the beginning.
        int left = 0;

        // Start the right pointer at the end.
        int right = height.length - 1;

        // Store the maximum area found so far.
        int maxArea = 0;

        // Continue while the two pointers have not crossed.
        while (left < right) {

            // The container's height is limited by the shorter line.
            int containerHeight = Math.min(height[left], height[right]);

            // The width is the distance between the two lines.
            int width = right - left;

            // Calculate the area of the current container.
            int area = containerHeight * width;

            // Update the maximum area if this one is larger.
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // Return the maximum amount of water.
        return maxArea;
    }
}