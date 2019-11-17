class Solution {
    //The problem here is we need to generate a random number in range [0,N)
    //First we could think that we can continue generating until generate number that is not 
    //in blacklist
    //But we need to minimize using Math.random(), so we can remap the number in blacklist to number not in blacklist
    Map<Integer, Integer> map;
    int M;
    Random r;
    
    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        for (int b : blacklist){
            map.put(b, -1);
        }
        
        M = N - map.size();
        for (int b : blacklist){
            if (b < M){
                while (map.containsKey(N - 1)){
                    N--;
                }
                map.put(b, N - 1);
                N--;
            }
        }
        r = new Random();
    }
    
    public int pick() {
        //System.out.println(M);
        int result = r.nextInt(M);
        if (map.containsKey(result)){
            return map.get(result);
        }
        else{
            return result;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */