class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for(int num : nums){
            if(num!=0){
                temp.add(num);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i<temp.size()){
                nums[i] = temp.get(i);
            } else{
                nums[i] = 0;
            }
        }
        
    }
}