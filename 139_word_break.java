class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0){
            return false;
        }
        int n= s.length();
        boolean[] dp = new boolean[n];
        //dp: whether until i is in the dictionary
        
        for(int i=0;i<=n-1;i++){
            for(int j=0;j <= i;j++){
                //substring i+1
                String sub = s.substring(j,i+1);
                
                //contain the word and also need to check if contains j-1
                if(wordDict.contains(sub)&&(j==0||dp[j-1])){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}