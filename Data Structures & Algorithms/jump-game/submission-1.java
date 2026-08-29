class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i = 0; i<nums.length; i++){
            if(i>maxReach){
                return false;
            }
            int currentReach = i+nums[i];
            maxReach = Math.max(currentReach, maxReach);
            if(maxReach>nums.length){
                return true;
            }
        }
        return true;
        
    }
}
