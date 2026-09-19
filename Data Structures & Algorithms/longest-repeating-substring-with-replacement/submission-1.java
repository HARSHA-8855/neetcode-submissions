class Solution {
    public int characterReplacement(String s, int k) {

        // Store the frequency of each uppercase English character.
        int[] freq = new int[26];

        // Left boundary of the sliding window.
        int left = 0;

        // Stores the highest frequency of any character
        // seen in the current/previous windows.
        int maxFreq = 0;

        // Stores the longest valid window found so far.
        int maxLength = 0;

        // Expand the window using the right pointer.
        for (int right = 0; right < s.length(); right++) {

            // Convert the current character into an index from 0 to 25.
            int index = s.charAt(right) - 'A';

            // Add the current character to the window.
            freq[index]++;

            // Update the highest character frequency.
            maxFreq = Math.max(maxFreq, freq[index]);

            // Number of characters that need to be replaced
            // to make the entire window the same character.
            int replacements = (right - left + 1) - maxFreq;

            // If more than k replacements are required,
            // the current window is invalid.
            if (replacements > k) {

                // Remove the leftmost character from the window.
                freq[s.charAt(left) - 'A']--;

                // Move the left boundary forward.
                left++;
            }

            // Store the length of the current valid window.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the longest valid window.
        return maxLength;
    }
}