class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        result[0] = 0;
        for(int i = 1; i <= amount; i++){
            // +1 will cause overflow
            int min = Integer.MAX_VALUE - 1;
            for(int coin : coins){
                if(i - coin >= 0){
                    //basically just need to iterate through all the coins and that's fine
                    min = Math.min(result[i - coin] + 1, min);
                }
                result[i] = min;
            }
        }
        return result[amount] == Integer.MAX_VALUE - 1  ? -1 : result[amount];
        
    }
}