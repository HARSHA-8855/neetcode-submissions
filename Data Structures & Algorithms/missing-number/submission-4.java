class Solution {
    public int missingNumber(int[] nums) {
        int N = nums.length ;
        long expectedsum = (long)N*(N+1)/2;
        long actualsum = 0;
        for(int num : nums){
            actualsum += num;
        }
        return (int) (expectedsum - actualsum);
        
    }
}
