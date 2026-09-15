class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // Store all unique triplets.
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array so that we can use two pointers.
        Arrays.sort(nums);

        // Fix the first element of the triplet.
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for the first element.
            // This prevents duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Left pointer starts just after i.
            int left = i + 1;

            // Right pointer starts at the end.
            int right = nums.length - 1;

            // Move the two pointers towards each other.
            while (left < right) {

                // Calculate the sum of the three numbers.
                int sum = nums[i] + nums[left] + nums[right];

                // If the sum is too small,
                // increase left to get a larger value.
                if (sum < 0) {
                    left++;
                }

                // If the sum is too large,
                // decrease right to get a smaller value.
                else if (sum > 0) {
                    right--;
                }

                // We found a valid triplet.
                else {

                    // Add the triplet to the result.
                    result.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    // Move both pointers to search for another triplet.
                    left++;
                    right--;

                    // Skip duplicate values on the left.
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate values on the right.
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        // Return all unique triplets.
        return result;
    }
}