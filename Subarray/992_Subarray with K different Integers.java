class Solution {
    //slide window
    public int subarraysWithKDistinct(int[] A, int K) {
        //slide window is suitale for subarray problems
        //because it can ensure the subarray is continuous
        return atMost(A, K) - atMost(A, K-1);
    }
    public int atMost(int[] A, int K){
        int res = 0, i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j <= A.length - 1; j++){
            if (map.getOrDefault(A[j], 0) == 0){
                K--;
            }
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            while(K < 0){
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0){
                    K++;
                }
                i++;
            }
            res += j - i + 1;      //interesting line, number of subarray ended at j
            
        }
        return res;
    }
}