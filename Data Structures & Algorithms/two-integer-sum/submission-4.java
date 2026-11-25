class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++){
            int current = nums[i];
            int compliment = target - current;
            if(map.containsKey(compliment)){
                int prevIndex = map.get(compliment);
                return new int[]{prevIndex,i};
            }
            map.put(current,i);
        }
        return new int[]{};
        
        
    }
}




