class Solution {
    public int majorityElement(int[] nums) {
       Map<Integer, Integer> count = new HashMap<>();
       int res = 0;
        int maxcount = 0;
       for(int num : nums){
        count.put(num,count.getOrDefault(num,0)+1);
        if(count.get(num)>maxcount){
            res = num;
            maxcount = count.get(num);
        }
       }
       return res;
    }
}