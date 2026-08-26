class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int current = nums[i];
            int complement = target - current;
            if(map.containsKey(complement)){
                int previousIndex = map.get(complement);
                return new int[]{previousIndex,i};
            }
            map.put(current,i);
        }
        return new int[]{};
        
    }
}
