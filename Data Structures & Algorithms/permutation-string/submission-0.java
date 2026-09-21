class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer than s2, a permutation cannot exist.
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency of characters in s1.
        int[] count1 = new int[26];

        // Frequency of characters in the current window of s2.
        int[] count2 = new int[26];

        // Count all characters present in s1.
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        // Create the first window in s2.
        for (int i = 0; i < s1.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // If the first window has exactly the same frequencies,
        // it is a permutation of s1.
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        // Start the sliding window after the first window.
        int left = 0;

        // Expand the window one character at a time.
        for (int right = s1.length(); right < s2.length(); right++) {

            // Add the new character entering the window.
            count2[s2.charAt(right) - 'a']++;

            // Remove the character leaving the window.
            count2[s2.charAt(left) - 'a']--;

            // Move the left boundary forward.
            left++;

            // If the frequency arrays match,
            // the current window is a permutation of s1.
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        // No permutation was found.
        return false;
    }
}