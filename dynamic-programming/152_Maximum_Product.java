class Solution {
    public int maxProduct(int[] nums) {
        //maintain an array, index i means max or min product at i
        
        
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        
        max[0] = nums[0];
        min[0] = nums[0];
        
        int result = nums[0];
        for(int i = 1; i <= nums.length - 1; ++i){
            max[i] = Math.max(Math.max(nums[i]*max[i-1],nums[i]*min[i-1]),nums[i]);
            
            min[i] = Math.min(Math.min(nums[i]*max[i-1],nums[i]*min[i-1]),nums[i]);
           
            result = Math.max(max[i],result);    
                       
        }
        return result;
    }
}