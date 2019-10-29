class Solution {
    
    // a math problem ,can try solve it using more than O(N)
    // before making it O(N)
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
		int trans = 2;
		int dp[][] = new int[trans + 1][prices.length];
		
		for(int i = 1; i <= trans; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 1; j < prices.length; j++) {
				min = Math.min(min, prices[j - 1] - dp[i - 1][j - 1]);
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
			}
		}
		return dp[trans][prices.length - 1];
	}
}