class Solution {
    //From the problem stated, we can only get the information that 
    //there is a maximum on K , which is the largetset pile,
    //if can't finish in this K, then the problem has no solution
    //BUt nothing else can be deduced, so it is natural to think of 
    //something else
    //Binary Search can find answer in given serach space in short time. 
    
    //
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = getMaxPile(piles);
        while (lo <= hi){
            System.out.println(hi);
            int mid = lo + ((hi - lo) >> 1);  //This line is interesting , pay attention of priority
            if (canEatAll(piles,mid,H)){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    public boolean canEatAll(int[] piles, int K, int H){
        int count = 0;
        for (int pile : piles){
            count += pile / K;
            if (pile % K != 0){
                count++;
            }
        }
        return count <= H;
    }
        
        
    public int getMaxPile(int[] piles){
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles){
            if (pile > maxPile){
                maxPile = pile;
            }
        }
        return maxPile;
    }
}