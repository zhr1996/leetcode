class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] result = {-1,-1};
        if(nums.length==0){
            return result;
        }
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        if(nums[right]==target){
            result[0] = right;
        }
        left = 0;
        right = nums.length-1;
        while(left+1<right){
            int mid = (left+right)/2;
            if(nums[mid]<=target){
                left = mid;
            }
            else{
                right = mid-1;
            }
        }
        if(nums[right]==target){
            result[1]=right;
        }
        else if(nums[left]==target){
            result[1]=left;
        }
        
        return result;
    }
}