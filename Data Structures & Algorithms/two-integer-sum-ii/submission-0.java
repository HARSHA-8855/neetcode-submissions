class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // Pointer starting from the smallest element.
        int left = 0;

        // Pointer starting from the largest element.
        int right = numbers.length - 1;

        // Continue until the two pointers meet.
        while (left < right) {

            // Calculate the sum of the two current elements.
            int sum = numbers[left] + numbers[right];

            // If the sum is exactly the target, we found the answer.
            if (sum == target) {

                // Problem uses 1-based indexing, so add 1.
                return new int[]{left + 1, right + 1};
            }

            // If the sum is too small,
            // move left forward to get a larger number.
            else if (sum < target) {
                left++;
            }

            // If the sum is too large,
            // move right backward to get a smaller number.
            else {
                right--;
            }
        }

        // The problem guarantees that a solution exists.
        return new int[]{};
    }
}