class Solution {
    //write some comments
    //The problem is that there shouldn't be duplicate solution.
    //So we can first sort the array, if there is duplicate, duplicate number
    //must be continuous.
    //fix first number, and use two pointers to locate the next two numbers
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++){
            if(i==0||nums[i]!=nums[i-1]){
                int j=i+1;
                int k=nums.length-1;
                while(j<k){
                    if(nums[j]+nums[k]<-nums[i]){
                        j++;
                        while(j+1<=k&&nums[j-1]==nums[j]){
                            j++;
                        }
                    }
                    else if(nums[j]+nums[k]>-nums[i]){
                        k--;
                        while(k-1>=j&&nums[k]==nums[k+1]){
                            k--;
                        }
                    }
                    else{
                        answer.add(Arrays.asList(nums[i],nums[j],nums[k])); 
                        j++;
                        while(j+1<=k&&nums[j-1]==nums[j]){
                            j++;
                    }
                }
            }
        }
        }
        return answer;
    }
}

