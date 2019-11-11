class Solution {
    public int[] productExceptSelf(int[] nums) {
        //each result is composed of two parts left product and right product
        //left stores the left product
        //right stores the right product
        //better to illustrate it with a graph
        //only use O(N) and O(1) space
        //only extra memory is right
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; ++i){
            result[i] = nums[i - 1] * result[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; --i){
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

}