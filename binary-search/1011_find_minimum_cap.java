class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        //binary search
        //Minimum is the max of weights, maximum is sum of all weights
        //use binary search to find the minimum capacity
        //need start form 1???

        int left = 0, right = 0;
        for(int weight:weights){
            left = Math.max(left, weight);
            right += weight;
        }
        while(left < right){
            int mid = left + (right - left) / 2, cur = 0, need = 1;
            for(int weight : weights){
                if(cur + weight > mid){
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            if(need > D){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}