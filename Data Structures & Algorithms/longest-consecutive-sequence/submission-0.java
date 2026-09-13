class Solution {
    public int longestConsecutive(int[] nums) {

        // Store all numbers in a HashSet
        // This allows O(1) average-time lookup
        Set<Integer> set = new HashSet<>();

        // Add every number to the set
        for (int num : nums) {
            set.add(num);
        }

        // Store the longest sequence found so far
        int longest = 0;

        // Check every number in the set
        for (int num : set) {

            // If num - 1 does NOT exist,
            // num is the beginning of a consecutive sequence
            if (!set.contains(num - 1)) {

                // Start the current sequence at num
                int current = num;

                // Length of the current sequence
                int length = 1;

                // Keep checking for the next consecutive number
                while (set.contains(current + 1)) {

                    // Move to the next number
                    current++;

                    // Increase the sequence length
                    length++;
                }

                // Update the longest sequence
                longest = Math.max(longest, length);
            }
        }

        // Return the maximum consecutive sequence length
        return longest;
    }
}