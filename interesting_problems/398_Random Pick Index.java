class Solution {
    //Reservior Sampling
    int[] nums = null;
    Random rand = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        //set k = 1
        int i = 0;
        int count = 0;
        List<Integer> reservior = new ArrayList<>();
        for(; i < nums.length; ++i){
            if (nums[i] == target){
                reservior.add(i);
                ++count;
                break;
            }
        }
        count++;
        //count = 2
        for(int j = i + 1; j < nums.length; ++j){
            if (nums[j] == target){
                int prob = rand.nextInt(count);  //not inclusive (count + 1)
                //rand generate 0 ~ count - 1
                //so if count =2 then generate 0 and 1
                //only if = 0, replace old index with current index
                if (prob < 1){
                    reservior.set(0, j);
                }
                count++;
            }
        }
        return reservior.get(0);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */