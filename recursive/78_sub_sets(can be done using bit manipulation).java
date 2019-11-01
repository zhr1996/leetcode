class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        RecursiveSets(nums,0,cur,result);
        result.add(new ArrayList<Integer>());
        return result;
    }
    
    public void RecursiveSets(int[] nums, int index, List<Integer> cur, List<List<Integer>> result){
        if(index==nums.length){
            return;
        }
        for(int i=index;i<=nums.length-1;i++){
            cur.add(nums[i]);
            result.add(new ArrayList<Integer>(cur));
            RecursiveSets(nums,i+1,cur,result);
            cur.remove(cur.size()-1);
        }
    }    
}
