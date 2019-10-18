class Solution {
    //二分法，
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        return helperfunction(nums, 0 , nums.length-1);
    }
    public int helperfunction(int[] nums, int low, int high){
        int mid = low + (high - low) / 2;
        if(low == high){
            return low;
        }
        if(high - low == 1){
            if(nums[high] > nums[low]){
                return high;
            }
            else return low;
        }
        if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid-1]){
            return mid;
        }
        else if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]){
            return helperfunction(nums, mid + 1, high );
        }
        else{
            return helperfunction(nums, low, mid - 1);
        }
    }
}